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
package vib.tools.animation.gestureeditor;

import java.awt.event.ItemEvent;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.AbstractButton;
import vib.core.repositories.HandShape;
import vib.core.repositories.HandShapeLibrary;
import vib.core.signals.gesture.Hand;

/**
 *
 * @author Jing Huang
 */
public class HandShapePanel extends javax.swing.JPanel {

    private Hand _hand;
    private GestureEditor _gestureEditor;

    private boolean initialized = false;

    /**
     * Creates new form HandShape
     */
    public HandShapePanel() {
        initComponents();
    }

    public void loadHand(Hand hand, GestureEditor parent) {
        initValue();
        _hand = hand;
        _gestureEditor = parent;
        invariantButton.setSelected(!hand.isHandShapeOverridable());
        setHandShape(hand.getHandShape());
    }

    private void initValue() {
        if (!initialized) {
            handShapeMenu.removeAllItems();
            HandShapeLibrary lib = new HandShapeLibrary();
            List<HandShape> list = lib.getAll();
            Collections.sort(list, new Comparator<HandShape>() {
                @Override
                public int compare(HandShape t, HandShape t1) {
                    return t.getParamName().compareToIgnoreCase(t1.getParamName());
                }
            });
            for (HandShape hand : list) {
                handShapeMenu.addItem(hand.getParamName().toUpperCase());
            }
            initialized = true;
        }
    }

    public void setHandShape(String HandShape) {
        this.handShapeMenu.setSelectedItem(HandShape.toUpperCase());
    }

    public String getHandShape() {
        return (handShapeMenu.getSelectedItem().toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        handShapeLabel = new javax.swing.JLabel();
        handShapeMenu = new javax.swing.JComboBox();
        invariantButton = new javax.swing.JCheckBox();

        setBorder(javax.swing.BorderFactory.createTitledBorder("HandShape"));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        handShapeLabel.setText("HandShape:");

        handShapeMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        handShapeMenu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                handShapeMenuItemStateChanged(evt);
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
                .addComponent(handShapeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(handShapeMenu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(invariantButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(handShapeLabel)
                    .addComponent(handShapeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invariantButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void handShapeMenuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_handShapeMenuItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED && _hand != null) {
            _hand.setHandShape(handShapeMenu.getSelectedItem().toString());
            _gestureEditor.sendCurrentKeyFrame();
        }
    }//GEN-LAST:event_handShapeMenuItemStateChanged

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        initValue();
    }//GEN-LAST:event_formComponentShown

    private void settingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingButtonActionPerformed

        AbstractButton settingButton = (AbstractButton) evt.getSource();

        String settingName = "";
        if (settingButton == invariantButton) {
            settingName = "handShapeInvariant";
        }
        _gestureEditor.askApplySettingToOtherPhases(settingName, settingButton.isSelected(), _hand.getSide());

        _hand.setHandShapeOverridable(!invariantButton.isSelected());

    }//GEN-LAST:event_settingButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel handShapeLabel;
    private javax.swing.JComboBox handShapeMenu;
    private javax.swing.JCheckBox invariantButton;
    // End of variables declaration//GEN-END:variables
}
