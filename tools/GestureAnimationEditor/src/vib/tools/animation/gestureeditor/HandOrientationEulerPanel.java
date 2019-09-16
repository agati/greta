/*
 * This file is part of Greta.
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

package vib.tools.animation.gestureeditor;

import javax.swing.AbstractButton;
import vib.core.signals.gesture.Hand;
import vib.core.util.math.Quaternion;
import vib.core.util.math.Vec3d;
import vib.core.utilx.gui.ToolBox;

/**
 *
 * @author Jing Huang
 */
public class HandOrientationEulerPanel extends javax.swing.JPanel {

    private Hand _hand;
    private GestureEditor _gestureEditor;

    /**
     * Creates new form HandOrientation
     */
    public HandOrientationEulerPanel() {
        initComponents();
        initField(xValue);
        initField(yValue);
        initField(zValue);
    }

    public void loadHand(Hand hand, GestureEditor parent) {
        _hand = hand;
        _gestureEditor = parent;
        globalButton.setSelected(hand.isWristOrientationGlobal());
        invariantButton.setSelected(!hand.isWristOrientationOverridable());
        Quaternion r = hand.getWristOrientation();
        if (r == null) {
            r = new Quaternion();
        }
        Vec3d axis = r.getEulerAngleXYZ();
        xParameter.setValue(translateAngle(axis.x()));
        yParameter.setValue(translateAngle(axis.y()));
        zParameter.setValue(translateAngle(axis.z()));
    }

    private int translateAngle(double d) {
        return (int) (Math.round(d / Math.PI * 1000.0));
    }

    private double translateAngle(int i) {
        return (double) (Math.round(i * Math.PI) / 1000.0);
    }

    private String parameterToValue(javax.swing.JSlider parameter) {
        return String.valueOf(translateAngle(parameter.getValue()));
    }

    private int valueToParameter(javax.swing.JTextField value) {
        return translateAngle(Double.parseDouble(value.getText()));
    }

    private void updateWristOrientation() {
        Quaternion q = new Quaternion();
        q.fromEulerXYZ(
                translateAngle(xParameter.getValue()),
                translateAngle(yParameter.getValue()),
                translateAngle(zParameter.getValue())
        );
        _hand.setWristOrientation(q);
        _hand.setWristOrientationGlobal(globalButton.isSelected());
        _hand.setWristOrientationOverridable(!invariantButton.isSelected());
        _gestureEditor.sendCurrentKeyFrame();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        xLabel = new javax.swing.JLabel();
        yLabel = new javax.swing.JLabel();
        zLabel = new javax.swing.JLabel();
        xValue = new javax.swing.JFormattedTextField();
        yValue = new javax.swing.JFormattedTextField();
        zValue = new javax.swing.JFormattedTextField();
        xParameter = new javax.swing.JSlider();
        yParameter = new javax.swing.JSlider();
        zParameter = new javax.swing.JSlider();
        localButton = new javax.swing.JRadioButton();
        globalButton = new javax.swing.JRadioButton();
        invariantButton = new javax.swing.JCheckBox();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Orientation"));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        xLabel.setText("X:");

        yLabel.setText("Y:");

        zLabel.setText("Z:");

        xValue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                valueFocusLost(evt);
            }
        });
        xValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valueActionPerformed(evt);
            }
        });
        xValue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                xValueKeyTyped(evt);
            }
        });

        yValue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                valueFocusLost(evt);
            }
        });
        yValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valueActionPerformed(evt);
            }
        });
        yValue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                yValueKeyTyped(evt);
            }
        });

        zValue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                valueFocusLost(evt);
            }
        });
        zValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valueActionPerformed(evt);
            }
        });
        zValue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                zValueKeyTyped(evt);
            }
        });

        xParameter.setMaximum(1000);
        xParameter.setMinimum(-1000);
        xParameter.setValue(0);
        xParameter.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                parameterStateChanged(evt);
            }
        });

        yParameter.setMaximum(1000);
        yParameter.setMinimum(-1000);
        yParameter.setValue(0);
        yParameter.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                parameterStateChanged(evt);
            }
        });

        zParameter.setMaximum(1000);
        zParameter.setMinimum(-1000);
        zParameter.setValue(0);
        zParameter.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                parameterStateChanged(evt);
            }
        });

        buttonGroup.add(localButton);
        localButton.setSelected(true);
        localButton.setText("Local");
        localButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingButtonActionPerformed(evt);
            }
        });

        buttonGroup.add(globalButton);
        globalButton.setText("Global");
        globalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingButtonActionPerformed(evt);
            }
        });

        invariantButton.setText("Invariant");
        invariantButton.addActionListener(new java.awt.event.ActionListener() {
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yLabel)
                            .addComponent(xLabel)
                            .addComponent(zLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(xValue, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yValue, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(zValue, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(xParameter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(yParameter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(zParameter, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(localButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(globalButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(invariantButton)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xParameter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(xLabel)
                        .addComponent(xValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yParameter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(yLabel)
                        .addComponent(yValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(zParameter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(zLabel)
                        .addComponent(zValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(localButton)
                        .addComponent(globalButton))
                    .addComponent(invariantButton)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void initField(javax.swing.JFormattedTextField field) {
        field.setFormatterFactory(
                new javax.swing.text.DefaultFormatterFactory(
                        new javax.swing.text.NumberFormatter(
                                vib.core.util.IniManager.getNumberFormat()
                        )
                )
        );
        field.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
    }

    private void xValueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xValueKeyTyped
        ToolBox.checkDoubleInRange(evt, xValue, -Math.PI, Math.PI);
    }//GEN-LAST:event_xValueKeyTyped

    private void yValueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yValueKeyTyped
        ToolBox.checkDoubleInRange(evt, yValue, -Math.PI, Math.PI);
    }//GEN-LAST:event_yValueKeyTyped

    private void zValueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_zValueKeyTyped
        ToolBox.checkDoubleInRange(evt, zValue, -Math.PI, Math.PI);
    }//GEN-LAST:event_zValueKeyTyped

    private void valueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valueActionPerformed
        if (!xValue.getText().isEmpty()) {
            xParameter.setValue(valueToParameter(xValue));
        }
        if (!yValue.getText().isEmpty()) {
            yParameter.setValue(valueToParameter(yValue));
        }
        if (!zValue.getText().isEmpty()) {
            zParameter.setValue(valueToParameter(zValue));
        }
    }//GEN-LAST:event_valueActionPerformed

    private void valueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valueFocusLost
        valueActionPerformed(null);
    }//GEN-LAST:event_valueFocusLost

    private void parameterStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_parameterStateChanged
        xValue.setText(parameterToValue(xParameter));
        yValue.setText(parameterToValue(yParameter));
        zValue.setText(parameterToValue(zParameter));
        updateWristOrientation();
    }//GEN-LAST:event_parameterStateChanged

    private void settingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingButtonActionPerformed

        AbstractButton settingButton = (AbstractButton) evt.getSource();

        String settingName = "";
        if (settingButton == localButton) {
            settingName = "orientationLocal";
        } else if (settingButton == globalButton) {
            settingName = "orientationGlobal";
        } else if (settingButton == invariantButton) {
            settingName = "orientationInvariant";
        }
        _gestureEditor.askApplySettingToOtherPhases(settingName, settingButton.isSelected(), _hand.getSide());

        updateWristOrientation();
    }//GEN-LAST:event_settingButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JRadioButton globalButton;
    private javax.swing.JCheckBox invariantButton;
    private javax.swing.JRadioButton localButton;
    private javax.swing.JLabel xLabel;
    private javax.swing.JSlider xParameter;
    private javax.swing.JFormattedTextField xValue;
    private javax.swing.JLabel yLabel;
    private javax.swing.JSlider yParameter;
    private javax.swing.JFormattedTextField yValue;
    private javax.swing.JLabel zLabel;
    private javax.swing.JSlider zParameter;
    private javax.swing.JFormattedTextField zValue;
    // End of variables declaration//GEN-END:variables
}
