/*
 * This file is part of the auxiliaries of Greta.
 * 
 * Greta is free software: you can redistribute it and / or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Greta is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Greta.If not, see <http://www.gnu.org/licenses/>.
 */

package vib.auxiliary.thrift.gui;

import vib.auxiliary.thrift.services.ConnectionListener;
import vib.auxiliary.thrift.services.Connector;
import vib.core.util.IniManager;
import java.awt.Color;
import java.util.Locale;

/**
 *
 * @author Ken Prepin
 */
public class ThriftFrame extends javax.swing.JFrame implements ConnectionListener {

    private static final Color green = new Color(0, 150, 0);

    private Connector connector;
    protected String host = "";
    protected String port = "";

    private String statusProperty = "word.status";
    private String notConnectedProperty = "network.notconnected";
    private String connectedProperty = "network.connected";
    private String hostProperty = "network.host";
    private String portProperty = "network.port";
    private String actualConnectedProperty;

    /**
     * Creates new form ThriftFrame
     */
    public ThriftFrame() {
        initComponents();
        setConnected(false);
    }

    public void setConnected(boolean connected) {
        if (connected) {
            actualConnectedProperty = connectedProperty;
            connectedLabel.setForeground(green);
        } else {
            actualConnectedProperty = notConnectedProperty;
            connectedLabel.setForeground(Color.RED);
        }
        updateConnectedLabel();
    }

    @Override
    public void onDisconnection() {
        setConnected(false);
    }

    @Override
    public void onConnection() {
        setConnected(true);
    }

    public void setConnector(Connector connect) {
        this.connector = connect;
        setHostValue(connector.getHost());
        setPortValue(connector.getPortString());
        setConnected(connector.isConnected());
        connector.setConnectionListener(this);
    }

    protected void setHostValue(String value) {
        host = value;
        hostField.setText(host);
    }

    protected void setPortValue(String value) {
        port = value;
        portField.setText(port);
    }

    private void updateConnection() {
        if (!host.equals(hostField.getText())
                || !port.equals(portField.getText())) {
            host = hostField.getText();
            port = portField.getText();
            updateURL(host, port);
        }
    }

    protected void updateURL(String host, String port) {
        if (connector != null) {
            connector.setURL(host, port);
        }
    }

    @Override
    public void setLocale(Locale l) {
        super.setLocale(l);
        System.out.println("updateLabels");
        updateConnectedLabel();
        updateLabelWithColon(statusLabel, statusProperty);
        updateLabelWithColon(hostLabel, hostProperty);
        updateLabelWithColon(portLabel, portProperty);
    }

    private void updateConnectedLabel() {
        if (connectedLabel != null) {
            connectedLabel.setText(IniManager.getLocaleProperty(actualConnectedProperty));
        }
    }

    private void updateLabelWithColon(javax.swing.JLabel label, String property) {
        System.out.println(label);
        if (label != null) {
            System.out.println(label);
            label.setText(IniManager.getLocaleProperty(property) + ":");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        connectedLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        portLabel = new javax.swing.JLabel();
        portField = new javax.swing.JTextField();
        hostLabel = new javax.swing.JLabel();
        hostField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        connectedLabel.setText(IniManager.getLocaleProperty("network.notconnected"));

        statusLabel.setText(IniManager.getLocaleProperty("word.status")+":");

        portLabel.setText(IniManager.getLocaleProperty("network.port")+":");

        portField.setText("portField");
        portField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portFieldActionPerformed(evt);
            }
        });
        portField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                portFieldFocusLost(evt);
            }
        });
        portField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                portFieldKeyTyped(evt);
            }
        });

        hostLabel.setText(IniManager.getLocaleProperty("network.host")+":");

        hostField.setText("hostField");
        hostField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hostFieldActionPerformed(evt);
            }
        });
        hostField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                hostFieldFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hostField)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(statusLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(connectedLabel))
                            .addComponent(hostLabel)
                            .addComponent(portLabel))
                        .addGap(0, 210, Short.MAX_VALUE))
                    .addComponent(portField))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(connectedLabel)
                    .addComponent(statusLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hostLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hostField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(portLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hostFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hostFieldActionPerformed
        updateConnection();
    }//GEN-LAST:event_hostFieldActionPerformed

    private void portFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_portFieldKeyTyped
        char pressed = evt.getKeyChar();
        if (Character.isDigit(pressed)) {
            String beforeselect = portField.getText().substring(0, portField.getSelectionStart());
            String afterSelect = portField.getText().substring(portField.getSelectionEnd());
            long value = Long.parseLong(beforeselect + pressed + afterSelect);
            if (0 <= value && value <= 65535) {
                return;//it's ok
            }
        }
        evt.consume();
    }//GEN-LAST:event_portFieldKeyTyped

    private void portFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portFieldActionPerformed
        updateConnection();
    }//GEN-LAST:event_portFieldActionPerformed

    private void portFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_portFieldFocusLost
        updateConnection();
    }//GEN-LAST:event_portFieldFocusLost

    private void hostFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hostFieldFocusLost
        updateConnection();
    }//GEN-LAST:event_hostFieldFocusLost
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel connectedLabel;
    private javax.swing.JTextField hostField;
    private javax.swing.JLabel hostLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField portField;
    private javax.swing.JLabel portLabel;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
