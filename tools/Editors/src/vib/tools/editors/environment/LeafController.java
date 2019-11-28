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
package vib.tools.editors.environment;

import java.util.Locale;
import vib.core.util.IniManager;
import vib.core.util.environment.Leaf;
import vib.core.util.math.Vec3d;

/**
 *
 * @author Andre-Marie Pez
 */
public class LeafController extends javax.swing.JFrame {

    Leaf node;

    /** Creates new form TreeNodeController */
    public LeafController() {
        initComponents();
        initField(posXField);
        initField(posYField);
        initField(posZField);

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        idField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
    }

    public void setLeaf(Leaf node){
        this.node = node;
        readPosition();
        readId();
        readRef();
    }

    private void initField(javax.swing.JFormattedTextField field){
        field.setFormatterFactory(
                new javax.swing.text.DefaultFormatterFactory(
                        new javax.swing.text.NumberFormatter(
                                vib.core.util.IniManager.getNumberFormat())));
        field.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
    }

    @Override
    public void setEnabled(boolean b) {
        super.setEnabled(b);
        posXField.setEnabled(b);
        posYField.setEnabled(b);
        posZField.setEnabled(b);
        jTextField1.setEnabled(b);
    }


    private void isFloatTyped(java.awt.event.KeyEvent evt, javax.swing.JFormattedTextField field){
        vib.core.utilx.gui.ToolBox.checkDouble(evt, field);
    }

    private void updatePosition(){
        if(node!=null){
            Vec3d pos = node.getSize();
            node.setSize(
                    valueOf(posXField, pos.x()),
                    valueOf(posYField, pos.y()),
                    valueOf(posZField, pos.z()));
        }
    }


    private void updateRef(){
        if(node!=null){
            node.setReference(jTextField1.getText());
        }
    }

    private void readPosition(){
        if(node!=null){
            Vec3d pos = node.getSize();
            posXField.setText(""+pos.x());
            posYField.setText(""+pos.y());
            posZField.setText(""+pos.z());
        }
    }

    private void readRef() {
        if(node!=null){
            jTextField1.setText(node.getReference());
        }
    }

    private void readId(){
        if(node!=null){
            idField.setText(node.getIdentifier());
        }
    }

    private double valueOf(javax.swing.JFormattedTextField field, double defaultValue){
        try{
            return Double.parseDouble(field.getText());
        }
        catch(Throwable t){}
        field.setText(""+defaultValue);
        return defaultValue;
    }

    @Override
    public void setLocale(Locale l) {
        super.setLocale(l);
        if(meterLabel!=null){
            meterLabel.setText("("+IniManager.getLocaleProperty("unit.meter", l).toLowerCase() +") ");
        }
//        if(posLabel!=null){
//            posLabel.setText(IniManager.getLocaleProperty("word.position", l));
//        }

        if(idLabel!=null){
            idLabel.setText(IniManager.getLocaleProperty("word.identifier", l));
        }
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        posLabel = new javax.swing.JLabel();
        posXField = new javax.swing.JFormattedTextField();
        posYField = new javax.swing.JFormattedTextField();
        posZField = new javax.swing.JFormattedTextField();
        meterLabel = new javax.swing.JLabel();
        xLabel = new javax.swing.JLabel();
        yLabel = new javax.swing.JLabel();
        zLabel = new javax.swing.JLabel();
        idField = new javax.swing.JFormattedTextField();
        idLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        posLabel.setText("Size");

        posXField.setText("0.0");
        posXField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posXFieldActionPerformed(evt);
            }
        });
        posXField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                posXFieldFocusLost(evt);
            }
        });
        posXField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                posXFieldKeyTyped(evt);
            }
        });

        posYField.setText("0.0");
        posYField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posYFieldActionPerformed(evt);
            }
        });
        posYField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                posYFieldFocusLost(evt);
            }
        });
        posYField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                posYFieldKeyTyped(evt);
            }
        });

        posZField.setText("0.0");
        posZField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posZFieldActionPerformed(evt);
            }
        });
        posZField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                posZFieldFocusLost(evt);
            }
        });
        posZField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                posZFieldKeyTyped(evt);
            }
        });

        meterLabel.setText("("+IniManager.getLocaleProperty("unit.meter").toLowerCase() +") ");

        xLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        xLabel.setText("X");

        yLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        yLabel.setText("Y");

        zLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        zLabel.setText("Z");

        idField.setEditable(false);
        idField.setToolTipText("");
        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });
        idField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                idFieldFocusLost(evt);
            }
        });
        idField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idFieldKeyTyped(evt);
            }
        });

        idLabel.setText(IniManager.getLocaleProperty("word.identifier"));

        jLabel1.setText("Ref");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(posLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(xLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(posXField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(yLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(posYField, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(zLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(posZField, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(meterLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(idField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xLabel)
                    .addComponent(yLabel)
                    .addComponent(zLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(posXField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(posYField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(posZField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(posLabel)
                    .addComponent(meterLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void posXFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posXFieldActionPerformed
        updatePosition();
    }//GEN-LAST:event_posXFieldActionPerformed

    private void posZFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posZFieldActionPerformed
        updatePosition();
    }//GEN-LAST:event_posZFieldActionPerformed

    private void posXFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_posXFieldKeyTyped
        isFloatTyped(evt,posXField);
    }//GEN-LAST:event_posXFieldKeyTyped

    private void posYFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_posYFieldKeyTyped
        isFloatTyped(evt,posYField);
    }//GEN-LAST:event_posYFieldKeyTyped

    private void posZFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_posZFieldKeyTyped
        isFloatTyped(evt,posZField);
    }//GEN-LAST:event_posZFieldKeyTyped

    private void posYFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posYFieldActionPerformed
        updatePosition();
    }//GEN-LAST:event_posYFieldActionPerformed

    private void posXFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_posXFieldFocusLost
        updatePosition();
    }//GEN-LAST:event_posXFieldFocusLost

    private void posYFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_posYFieldFocusLost
        updatePosition();
    }//GEN-LAST:event_posYFieldFocusLost

    private void posZFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_posZFieldFocusLost
        updatePosition();
    }//GEN-LAST:event_posZFieldFocusLost

    private void idFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldKeyTyped

    private void idFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldFocusLost

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        updateRef();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        updateRef();
    }//GEN-LAST:event_jTextField1FocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel meterLabel;
    private javax.swing.JLabel posLabel;
    private javax.swing.JFormattedTextField posXField;
    private javax.swing.JFormattedTextField posYField;
    private javax.swing.JFormattedTextField posZField;
    private javax.swing.JLabel xLabel;
    private javax.swing.JLabel yLabel;
    private javax.swing.JLabel zLabel;
    // End of variables declaration//GEN-END:variables

}
