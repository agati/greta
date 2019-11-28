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

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import vib.core.signals.gesture.GesturePose;
import vib.core.signals.gesture.Hand;
import vib.core.signals.gesture.Position;
import vib.core.signals.gesture.SymbolicPosition;
import vib.core.signals.gesture.TouchPosition;
import vib.core.signals.gesture.UniformPosition;
import vib.core.util.enums.Side;

/**
 *
 * @author Jing Huang
 */
public class PhasePanel extends javax.swing.JPanel {

    private GesturePose _phase;
    private GestureEditor _gestureEditor;

    /**
     * Creates new form PhasePanel
     */
    public PhasePanel(GesturePose phase, GestureEditor parent) {
        initComponents();
        _phase = phase;
        _gestureEditor = parent;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftButton = new javax.swing.JCheckBox();
        rightButton = new javax.swing.JCheckBox();
        switchArmsButton = new javax.swing.JButton();
        phaseTabbedPane = new javax.swing.JTabbedPane();
        leftPanel = new javax.swing.JPanel();
        leftScrollPane = new javax.swing.JScrollPane();
        rightPanel = new javax.swing.JPanel();
        rightScrollPane = new javax.swing.JScrollPane();

        leftButton.setLabel("Enable Left Arm");
        leftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButtonActionPerformed(evt);
            }
        });

        rightButton.setLabel("Enable Right Arm");
        rightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightButtonActionPerformed(evt);
            }
        });

        switchArmsButton.setText("Switch Arms");
        switchArmsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchArmsButtonActionPerformed(evt);
            }
        });

        leftScrollPane.setBorder(null);

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftScrollPane)
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftScrollPane)
        );

        phaseTabbedPane.addTab("Left Arm", leftPanel);

        rightScrollPane.setBorder(null);

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rightScrollPane)
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rightScrollPane)
        );

        phaseTabbedPane.addTab("Right Arm", rightPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(leftButton)
                .addGap(18, 18, 18)
                .addComponent(rightButton)
                .addGap(18, 18, 18)
                .addComponent(switchArmsButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(phaseTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leftButton)
                    .addComponent(rightButton)
                    .addComponent(switchArmsButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(phaseTabbedPane))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void insertLeftHand() {
        Object[] possibilities = {"Uniform", "Symbolic", "TouchPoint"};
        String s = (String) JOptionPane.showInputDialog(
                this,
                "Which type of phase do you want?",
                "Type chooser",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                "Uniform");
        Hand leftHand = new Hand(Side.LEFT);
        _phase.setLeftHand(leftHand);
        if (s.equals("Uniform")) {
            UniformPosition pos = new UniformPosition(0, 0, 0);
            leftHand.setPosition(pos);
        } else if (s.equals("Symbolic")) {
            SymbolicPosition pos = new SymbolicPosition();
            pos.setHorizontalLocation("XC");
            pos.setVerticalLocation("YUpperC");
            pos.setFrontalLocation("ZMiddle");
            leftHand.setPosition(pos);
        } else if (s.equals("TouchPoint")) {
            TouchPosition pos = new TouchPosition();
            pos.setId("");
            leftHand.setPosition(pos);
        }
        leftHand.setHandShape("empty");
        addLeft(buildOneHandTab(leftHand));
    }

    private void insertRightHand() {
        Object[] possibilities = {"Uniform", "Symbolic", "TouchPoint"};
        String s = (String) JOptionPane.showInputDialog(
                this,
                "Which type of phase do you want?",
                "Type chooser",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                "Uniform");
        Hand rightHand = new Hand(Side.RIGHT);
        _phase.setRightHand(rightHand);

        if (s.equals("Uniform")) {
            UniformPosition pos = new UniformPosition(0, 0, 0);
            rightHand.setPosition(pos);
        } else if (s.equals("Symbolic")) {
            SymbolicPosition pos = new SymbolicPosition();
            pos.setHorizontalLocation("XC");
            pos.setVerticalLocation("YUpperC");
            pos.setFrontalLocation("ZMiddle");
            rightHand.setPosition(pos);
        } else if (s.equals("TouchPoint")) {
            TouchPosition pos = new TouchPosition();
            pos.setId("");
            rightHand.setPosition(pos);
        }
        rightHand.setHandShape("empty");
        addRight(buildOneHandTab(rightHand));
    }

    private void leftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButtonActionPerformed

        if (leftButton.isSelected()) {
            phaseTabbedPane.setEnabledAt(0, true);
            leftScrollPane.setVisible(true);
            insertLeftHand();
        } else {
            leftPanel = new JPanel();
            phaseTabbedPane.setTitleAt(0, "Left Arm");
            phaseTabbedPane.setEnabledAt(0, false);
            leftScrollPane.setVisible(false);
            _phase.setLeftHand(null);
            leftScrollPane.setViewportView(null);
        }
    }//GEN-LAST:event_leftButtonActionPerformed

    private void rightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightButtonActionPerformed

        if (rightButton.isSelected()) {
            phaseTabbedPane.setEnabledAt(1, true);
            rightScrollPane.setVisible(true);
            insertRightHand();
        } else {
            rightPanel = new JPanel();
            phaseTabbedPane.setTitleAt(1, "Right Arm");
            phaseTabbedPane.setEnabledAt(1, false);
            rightScrollPane.setVisible(false);
            _phase.setRightHand(null);
            rightScrollPane.setViewportView(null);
        }
    }//GEN-LAST:event_rightButtonActionPerformed

    private void switchArmsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switchArmsButtonActionPerformed
        _phase.switchHands();
        _gestureEditor.refreshCurrentGestureView();
    }//GEN-LAST:event_switchArmsButtonActionPerformed

    public void addLeft(JPanel p) {
        if (p != null) {
            leftScrollPane.setViewportView(p);
            leftButton.setSelected(true);
            phaseTabbedPane.setEnabledAt(0, true);
        } else {
            leftButton.setSelected(false);
            phaseTabbedPane.setEnabledAt(0, false);
        }
    }

    public void addRight(JPanel p) {
        if (p != null) {
            rightScrollPane.setViewportView(p);
            rightButton.setSelected(true);
            phaseTabbedPane.setEnabledAt(1, true);
        } else {
            rightButton.setSelected(false);
            phaseTabbedPane.setEnabledAt(1, false);
        }
    }

    JPanel buildOneHandTab(Hand hand) {
        if (hand == null) {
            return null;
        }
        Position p = hand.getPosition();
        if (p instanceof SymbolicPosition) {
            SymbolicOneHandPanel panel = new SymbolicOneHandPanel();
            panel.loadHand(hand, _gestureEditor);
            return panel;
        } else if (p instanceof TouchPosition) {
            TouchPointOneHandPanel panel = new TouchPointOneHandPanel();
            panel.loadHand(hand, _gestureEditor);
            return panel;
        } else if (p instanceof UniformPosition) {
            UniformOneHandPanel panel = new UniformOneHandPanel();
            panel.loadHand(hand, _gestureEditor);
            return panel;
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox leftButton;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JScrollPane leftScrollPane;
    private javax.swing.JTabbedPane phaseTabbedPane;
    private javax.swing.JCheckBox rightButton;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JScrollPane rightScrollPane;
    private javax.swing.JButton switchArmsButton;
    // End of variables declaration//GEN-END:variables
}
