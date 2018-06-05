/* This file is part of Greta.
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
*/package vib.tools.animation.gestureeditor;

import javax.swing.AbstractButton;
import vib.core.signals.gesture.Hand;
import vib.core.signals.gesture.SymbolicPosition;
import vib.core.signals.gesture.UniformPosition;

/**
 *
 * @author Jing Huang
 */
public class SymbolicHandPositionPanel extends javax.swing.JPanel {

    private Hand _hand;
    private GestureEditor _gestureEditor;

    /**
     * Creates new form SymbolicHandPosition
     */
    public SymbolicHandPositionPanel() {
        initComponents();
        initValue();
    }

    private void initValue() {
        xParameter.removeAllItems();
        yParameter.removeAllItems();
        zParameter.removeAllItems();

        xParameter.addItem("XEP");
        xParameter.addItem("XP");
        xParameter.addItem("XC");
        xParameter.addItem("XCC");
        xParameter.addItem("XOppC");

        yParameter.addItem("YUpperEP");
        yParameter.addItem("YUpperP");
        yParameter.addItem("YUpperC");
        yParameter.addItem("YCC");
        yParameter.addItem("YLowerC");
        yParameter.addItem("YLowerP");
        yParameter.addItem("YLowerEP");

        zParameter.addItem("ZNear");
        zParameter.addItem("ZMiddle");
        zParameter.addItem("ZFar");
    }

    public void loadHand(Hand hand, GestureEditor parent) {
        _hand = hand;
        _gestureEditor = parent;
        SymbolicPosition pos = (SymbolicPosition) hand.getPosition();
        xFixedButton.setSelected(pos.isXFixed());
        yFixedButton.setSelected(pos.isYFixed());
        zFixedButton.setSelected(pos.isZFixed());
        xInvariantButton.setSelected(!pos.isXOverridable());
        yInvariantButton.setSelected(!pos.isYOverridable());
        zInvariantButton.setSelected(!pos.isZOverridable());
        setXValue(pos.getHorizontalLocation());
        setYValue(pos.getVerticalLocation());
        setZValue(pos.getFrontalLocation());
    }

    public String getXValue() {
        return (xParameter.getSelectedItem().toString());
    }

    public void setXValue(String x) {
        this.xParameter.setSelectedItem(x);
    }

    public String getYValue() {
        return (yParameter.getSelectedItem().toString());
    }

    public void setYValue(String y) {
        this.yParameter.setSelectedItem(y);
    }

    public String getZValue() {
        return (zParameter.getSelectedItem().toString());
    }

    public void setZValue(String z) {
        this.zParameter.setSelectedItem(z);
    }

    private void updateAndSend() {
        if (_hand != null) {
            SymbolicPosition s = new SymbolicPosition();
            s.setFrontalLocation(getZValue());
            s.setHorizontalLocation(getXValue());
            s.setVerticalLocation(getYValue());
            s.setXFixed(xFixedButton.isSelected());
            s.setYFixed(yFixedButton.isSelected());
            s.setZFixed(zFixedButton.isSelected());
            s.setXOverridable(!xInvariantButton.isSelected());
            s.setYOverridable(!yInvariantButton.isSelected());
            s.setZOverridable(!zInvariantButton.isSelected());
            _hand.setPosition(s);
            _gestureEditor.sendCurrentKeyFrame();
        }
    }

    public void convertToUniform() {
        if (_hand.getPosition() instanceof UniformPosition) {
            _hand.setPosition(new UniformPosition((UniformPosition) _hand.getPosition()));
            _gestureEditor.refreshCurrentGestureView();
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

        xLabel = new javax.swing.JLabel();
        yLabel = new javax.swing.JLabel();
        zLabel = new javax.swing.JLabel();
        xParameter = new javax.swing.JComboBox();
        yParameter = new javax.swing.JComboBox();
        zParameter = new javax.swing.JComboBox();
        xFixedButton = new javax.swing.JCheckBox();
        yFixedButton = new javax.swing.JCheckBox();
        zFixedButton = new javax.swing.JCheckBox();
        xInvariantButton = new javax.swing.JCheckBox();
        yInvariantButton = new javax.swing.JCheckBox();
        zInvariantButton = new javax.swing.JCheckBox();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Position"));

        xLabel.setText("X:");

        yLabel.setText("Y:");

        zLabel.setText("Z:");

        xParameter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        xParameter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                parameterItemStateChanged(evt);
            }
        });

        yParameter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        yParameter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                parameterItemStateChanged(evt);
            }
        });

        zParameter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        zParameter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                parameterItemStateChanged(evt);
            }
        });

        xFixedButton.setText("Fixed");
        xFixedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingButtonActionPerformed(evt);
            }
        });

        yFixedButton.setText("Fixed");
        yFixedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingButtonActionPerformed(evt);
            }
        });

        zFixedButton.setText("Fixed");
        zFixedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingButtonActionPerformed(evt);
            }
        });

        xInvariantButton.setText("Invariant");
        xInvariantButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingButtonActionPerformed(evt);
            }
        });

        yInvariantButton.setText("Invariant");
        yInvariantButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingButtonActionPerformed(evt);
            }
        });

        zInvariantButton.setText("Invariant");
        zInvariantButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(xLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(xParameter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(xFixedButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(zLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(zParameter, 0, 1, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(zFixedButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(yLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(yParameter, 0, 1, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(yFixedButton)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xInvariantButton)
                    .addComponent(yInvariantButton)
                    .addComponent(zInvariantButton))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xLabel)
                    .addComponent(xParameter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xFixedButton)
                    .addComponent(xInvariantButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yLabel)
                    .addComponent(yParameter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yFixedButton)
                    .addComponent(yInvariantButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zLabel)
                    .addComponent(zParameter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zFixedButton)
                    .addComponent(zInvariantButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void parameterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_parameterItemStateChanged
        updateAndSend();
    }//GEN-LAST:event_parameterItemStateChanged

    private void settingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingButtonActionPerformed

        AbstractButton settingButton = (AbstractButton) evt.getSource();

        String settingName = "";
        if (settingButton == xFixedButton) {
            settingName = "xFixed";
        } else if (settingButton == yFixedButton) {
            settingName = "yFixed";
        } else if (settingButton == zFixedButton) {
            settingName = "zFixed";
        } else if (settingButton == xInvariantButton) {
            settingName = "xInvariant";
        } else if (settingButton == yInvariantButton) {
            settingName = "yInvariant";
        } else if (settingButton == zInvariantButton) {
            settingName = "zInvariant";
        }
        _gestureEditor.askApplySettingToOtherPhases(settingName, settingButton.isSelected(), _hand.getSide());

        updateAndSend();
    }//GEN-LAST:event_settingButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox xFixedButton;
    private javax.swing.JCheckBox xInvariantButton;
    private javax.swing.JLabel xLabel;
    private javax.swing.JComboBox xParameter;
    private javax.swing.JCheckBox yFixedButton;
    private javax.swing.JCheckBox yInvariantButton;
    private javax.swing.JLabel yLabel;
    private javax.swing.JComboBox yParameter;
    private javax.swing.JCheckBox zFixedButton;
    private javax.swing.JCheckBox zInvariantButton;
    private javax.swing.JLabel zLabel;
    private javax.swing.JComboBox zParameter;
    // End of variables declaration//GEN-END:variables
}
