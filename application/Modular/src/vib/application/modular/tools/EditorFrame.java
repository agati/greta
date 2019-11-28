/*
 * This file is part of Greta.
 *
 * Greta is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Greta is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Greta.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package vib.application.modular.tools;

import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import vib.application.modular.ModularWindow;
import vib.application.modular.ModularXMLFile;
import vib.core.util.IniManager;

/**
 *
 * @author Andre-Marie Pez
 */
public class EditorFrame extends javax.swing.JFrame {

    private boolean saved = false;
    private ModularWindow parent;

    /**
     * Creates new form EditorFrame
     */
    public EditorFrame(ModularWindow parent, JPanel... panes) {
        initComponents();
        setTitle("Modular - Editor");
        this.parent = parent;
        if(panes.length > 0){
            for(JPanel pane : panes){
                jTabbedPane1.addTab(pane.getName(), pane);
            }
            jTabbedPane1.addChangeListener(new ChangeListener() {

                @Override
                public void stateChanged(ChangeEvent e) {
                    Component selectedComponent = jTabbedPane1.getSelectedComponent();
                    if(selectedComponent instanceof Updatable){
                        ((Updatable)selectedComponent).update();
                    }
                }
            });
        }
        pack();
        this.setMinimumSize(this.getSize());
    }

    public void selectPane(int selectedTab) {
        if (jTabbedPane1.getTabCount() == 0) {
            return;
        }
        if (selectedTab < 0) {
            selectedTab = 0;
        }
        if (selectedTab >= jTabbedPane1.getTabCount()) {
            selectedTab = jTabbedPane1.getTabCount() - 1;
        }
        jTabbedPane1.setSelectedIndex(selectedTab);
    }

    private void apply() {
        ModularXMLFile.save();
        saved = true;
        parent.checkValidity();
    }

    public void reload() {
        ModularXMLFile.reload();
        for(int i=0; i < jTabbedPane1.getTabCount(); ++i){
            Component selectedComponent = jTabbedPane1.getComponentAt(i);
            if(selectedComponent instanceof Updatable){
                ((Updatable)selectedComponent).reload();
            }
        }
    }

    private void exit() {
        this.dispose();
        if (saved) {
            JOptionPane.showMessageDialog(parent, IniManager.getLocaleProperty("modular.after.restart"));
            saved = false;
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        applyButton = new vib.core.utilx.gui.ToolBox.LocalizedJButton("GUI.save");
        cancelButton = new vib.core.utilx.gui.ToolBox.LocalizedJButton("GUI.exit")  ;
        okButton = new vib.core.utilx.gui.ToolBox.LocalizedJButton("modular.edit.save.and.exit");
        jButton1 = new vib.core.utilx.gui.ToolBox.LocalizedJButton("GUI.reload")  ;

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        applyButton.setText("Save");
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Exit");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        okButton.setText("Save and Exit");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Reload");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 21, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(applyButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelButton))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(applyButton)
                    .addComponent(cancelButton)
                    .addComponent(okButton)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        apply();
    }//GEN-LAST:event_applyButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        reload();
        exit();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        apply();
        exit();
    }//GEN-LAST:event_okButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        reload();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}
