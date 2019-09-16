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
public class HandOrientationPanel extends javax.swing.JPanel {

    private Hand _hand;
    private GestureEditor _gestureEditor;

    /**
     * Creates new form HandOrientation
     */
    public HandOrientationPanel() {
        initComponents();
        initField(xValue);
        initField(yValue);
        initField(zValue);
        initField(angleValue);
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
        xParameter.setValue(translate(r.axis().x(), false));
        yParameter.setValue(translate(r.axis().y(), false));
        zParameter.setValue(translate(r.axis().z(), false));
        angleParameter.setValue(translate(r.angle(), true));
    }

    private int translate(double d, boolean angle) {
        return angle ? (int) (Math.round(d / Math.PI * 1000.0)) : (int) (Math.round(d * 1000.0));
    }

    private double translate(int i, boolean angle) {
        return angle ? (double) (Math.round(i * Math.PI) / 1000.0) : (double) (i / 1000.0);
    }

    private String parameterToValue(javax.swing.JSlider parameter, boolean angle) {
        return String.valueOf(translate(parameter.getValue(), angle));
    }

    private int valueToParameter(javax.swing.JTextField value, boolean angle) {
        return translate(Double.parseDouble(value.getText()), angle);
    }

    private void updateWristOrientation() {
        Vec3d axis = new Vec3d(
                translate(xParameter.getValue(), false),
                translate(yParameter.getValue(), false),
                translate(zParameter.getValue(), false)
        );
        double angle = translate(angleParameter.getValue(), true);
        Quaternion q = new Quaternion();
        q.setAxisAngle(axis, angle);
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
        angleLabel = new javax.swing.JLabel();
        xValue = new javax.swing.JFormattedTextField();
        yValue = new javax.swing.JFormattedTextField();
        zValue = new javax.swing.JFormattedTextField();
        angleValue = new javax.swing.JFormattedTextField();
        xParameter = new javax.swing.JSlider();
        yParameter = new javax.swing.JSlider();
        zParameter = new javax.swing.JSlider();
        angleParameter = new javax.swing.JSlider();
        localButton = new javax.swing.JRadioButton();
        globalButton = new javax.swing.JRadioButton();
        invariantButton = new javax.swing.JCheckBox();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Orientation"));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        xLabel.setText("X:");

        yLabel.setText("Y:");

        zLabel.setText("Z:");

        angleLabel.setText("Angle:");

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

        angleValue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                valueFocusLost(evt);
            }
        });
        angleValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valueActionPerformed(evt);
            }
        });
        angleValue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                angleValueKeyTyped(evt);
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

        angleParameter.setMaximum(1000);
        angleParameter.setMinimum(-1000);
        angleParameter.setValue(0);
        angleParameter.addChangeListener(new javax.swing.event.ChangeListener() {
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
                        .addComponent(localButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(globalButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addComponent(invariantButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(yLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(xLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(zLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(angleLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(angleValue, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(zValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(xValue, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(yValue, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(xParameter, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(yParameter, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(zParameter, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(angleParameter, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xParameter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(xValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(xLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yParameter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(yValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(yLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(zParameter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(zValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(zLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(angleParameter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(angleValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(angleLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(localButton)
                        .addComponent(globalButton))
                    .addComponent(invariantButton))
                .addContainerGap())
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
        ToolBox.checkDoubleInRange(evt, xValue, -1.0, 1.0);
    }//GEN-LAST:event_xValueKeyTyped

    private void yValueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yValueKeyTyped
        ToolBox.checkDoubleInRange(evt, yValue, -1.0, 1.0);
    }//GEN-LAST:event_yValueKeyTyped

    private void zValueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_zValueKeyTyped
        ToolBox.checkDoubleInRange(evt, zValue, -1.0, 1.0);
    }//GEN-LAST:event_zValueKeyTyped

    private void angleValueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_angleValueKeyTyped
        ToolBox.checkDoubleInRange(evt, angleValue, -Math.PI, Math.PI);
    }//GEN-LAST:event_angleValueKeyTyped

    private void valueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valueActionPerformed
        if (!xValue.getText().isEmpty()) {
            xParameter.setValue(valueToParameter(xValue, false));
        }
        if (!yValue.getText().isEmpty()) {
            yParameter.setValue(valueToParameter(yValue, false));
        }
        if (!zValue.getText().isEmpty()) {
            zParameter.setValue(valueToParameter(zValue, false));
        }
        if (!angleValue.getText().isEmpty()) {
            angleParameter.setValue(valueToParameter(angleValue, true));
        }
    }//GEN-LAST:event_valueActionPerformed

    private void valueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valueFocusLost
        valueActionPerformed(null);
    }//GEN-LAST:event_valueFocusLost

    private void parameterStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_parameterStateChanged
        xValue.setText(parameterToValue(xParameter, false));
        yValue.setText(parameterToValue(yParameter, false));
        zValue.setText(parameterToValue(zParameter, false));
        angleValue.setText(parameterToValue(angleParameter, true));
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
    private javax.swing.JLabel angleLabel;
    private javax.swing.JSlider angleParameter;
    private javax.swing.JFormattedTextField angleValue;
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
