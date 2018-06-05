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

import java.util.HashMap;
import vib.core.signals.gesture.Hand;
import vib.core.signals.gesture.TouchPosition;
import vib.core.util.math.Vec3d;

/**
 *
 * @author Jing Huang
 */
public class TouchPointOneHandPanel extends javax.swing.JPanel {

    private HashMap<String, String> _touchPosition = new HashMap<String, String>();
    private HashMap<String, Vec3d> _touchPosOffset = new HashMap<String, Vec3d>();
    private HashMap<String, Vec3d> _touchRotOffset = new HashMap<String, Vec3d>();

    /**
     * Creates new form TouchPointOneHandPanel
     */
    public TouchPointOneHandPanel() {
        initComponents();
    }

    public HandOrientationEulerPanel getHandOrientationPanel() {
        return handOrientationPanel;
    }

    public HandShapePanel getHandShapePanel() {
        return handShapePanel;
    }

    public TouchPointHandPositionPanel getTouchPointHandPositionPanel() {
        return touchPointHandPositionPanel;
    }

    public void loadHand(Hand hand, GestureEditor parent) {
        if (hand == null) {
            return;
        }

        if (hand.getPosition() instanceof TouchPosition) {
            touchPointHandPositionPanel.loadHand(hand, parent);
        }

        handOrientationPanel.loadHand(hand, parent);
        handShapePanel.loadHand(hand, parent);
        opennessPanel.loadHand(hand, parent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        touchPointHandPositionPanel = new vib.tools.animation.gestureeditor.TouchPointHandPositionPanel();
        handOrientationPanel = new vib.tools.animation.gestureeditor.HandOrientationEulerPanel();
        handShapePanel = new vib.tools.animation.gestureeditor.HandShapePanel();
        opennessPanel = new vib.tools.animation.gestureeditor.OpennessPanel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("TouchPoint"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(touchPointHandPositionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(handOrientationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                    .addComponent(handShapePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(opennessPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(touchPointHandPositionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(handOrientationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(handShapePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opennessPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private vib.tools.animation.gestureeditor.HandOrientationEulerPanel handOrientationPanel;
    private vib.tools.animation.gestureeditor.HandShapePanel handShapePanel;
    private vib.tools.animation.gestureeditor.OpennessPanel opennessPanel;
    private vib.tools.animation.gestureeditor.TouchPointHandPositionPanel touchPointHandPositionPanel;
    // End of variables declaration//GEN-END:variables
}
