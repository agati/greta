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
*/package vib.core.animation.body;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import vib.core.animation.Frame;
import vib.core.animation.mpeg4.bap.BAPFrame;
import vib.core.animation.mpeg4.bap.BAPFramesEmitter;
import vib.core.animation.mpeg4.bap.BAPFramesPerformer;
import vib.core.animation.mpeg4.bap.BAPType;
import vib.core.animation.mpeg4.bap.JointType;
import vib.core.repositories.Gestuary;
import vib.core.repositories.SignalEntry;
import vib.core.repositories.TorsoLibrary;
import vib.core.signals.Signal;
import vib.core.signals.SignalEmitter;
import vib.core.signals.SignalPerformer;
import vib.core.signals.TorsoSignal;
import vib.core.util.Constants;
import vib.core.util.Mode;
import vib.core.util.enums.CompositionType;
import vib.core.util.id.ID;
import vib.core.util.id.IDProvider;
import vib.core.util.math.Quaternion;
import vib.core.util.math.Vec3d;
import vib.core.util.time.Timer;

/**
 *
 * @author Jing Huang
 */


public class TorsoEditor extends javax.swing.JFrame implements BAPFramesEmitter, SignalEmitter{

    ArrayList<BAPFramesPerformer> _bapframesPerformer = new ArrayList<BAPFramesPerformer>();
    private List<SignalPerformer> signalPerformers = new ArrayList<SignalPerformer>();
    /**
     * Creates new form TorsoEditor
     */
    public TorsoEditor() {
        initComponents();
    }

    void send(){
         long time = Timer.getTimeMillis();
         ArrayList<BAPFrame> frames = new ArrayList<BAPFrame>();
         int current = (int) (time / 1000.0 * Constants.FRAME_PER_SECOND + 0.5);
         Frame f1 = new Frame();
         Quaternion q0 = new Quaternion();
         q0.fromEulerXYZ((double)(vt2X.getValue()/100.0), (double)(vt2Y.getValue()/100.0), (double)(vt2Z.getValue()/100.0));
         f1.addRotation(vt2.getText(), q0);
         Quaternion q1 = new Quaternion();
         q1.fromEulerXYZ((double)(vt5X.getValue()/100.0), (double)(vt5Y.getValue()/100.0), (double)(vt5Z.getValue()/100.0));
         f1.addRotation(vt5.getText(), q1);
         Quaternion q2 = new Quaternion();
         q2.fromEulerXYZ((double)(vt12X.getValue()/100.0), (double)(vt12Y.getValue()/100.0), (double)(vt12Z.getValue()/100.0));
         f1.addRotation(vt12.getText(), q2);
         Quaternion q3 = new Quaternion();
         q3.fromEulerXYZ((double)(vl5X.getValue()/100.0), (double)(vl5Y.getValue()/100.0), (double)(vl5Z.getValue()/100.0));
         f1.addRotation(vl5.getText(), q3);
         String v = "<KeyPoint type =\"\">\n";
         v+= "<Rotations>\n";
         v+= "<vt2 x= \""+ q0.x() +" \" y= \""+ q0.y()+"\" z= \""+q0.z() +"\" w=\""+ q0.w()+"\"/>\n";
         v+= "<vt5 x= \""+ q1.x() +" \" y= \""+ q1.y()+"\" z= \""+q1.z() +"\" w=\""+ q1.w()+"\"/>\n";
         v+= "<vt12 x= \""+ q2.x() +" \" y= \""+ q2.y()+"\" z= \""+q2.z() +"\" w=\""+ q2.w()+"\"/>\n";
         v+= "<vl5 x= \""+ q3.x() +" \" y= \""+ q3.y()+"\" z= \""+q3.z() +"\" w=\""+ q3.w()+"\"/>\n";
         v+= "</Rotations>\n";
         v+= "</KeyPoint>";
         textR.setText(v);
         frames.add(getBapFrame(f1, current + 1));
         frames.add(getBapFrame(f1, current + 2));
         ID id = IDProvider.createID("TorsoEditor");
         sendFrames(frames,id);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        vt2 = new javax.swing.JLabel();
        vt2X = new javax.swing.JSlider();
        vt2Y = new javax.swing.JSlider();
        vt2Z = new javax.swing.JSlider();
        jPanel8 = new javax.swing.JPanel();
        vt5 = new javax.swing.JLabel();
        vt5X = new javax.swing.JSlider();
        vt5Y = new javax.swing.JSlider();
        vt5Z = new javax.swing.JSlider();
        jPanel9 = new javax.swing.JPanel();
        vt12 = new javax.swing.JLabel();
        vt12X = new javax.swing.JSlider();
        vt12Y = new javax.swing.JSlider();
        vt12Z = new javax.swing.JSlider();
        jPanel10 = new javax.swing.JPanel();
        vl5 = new javax.swing.JLabel();
        vl5X = new javax.swing.JSlider();
        vl5Y = new javax.swing.JSlider();
        vl5Z = new javax.swing.JSlider();
        jPanel1 = new javax.swing.JPanel();
        send = new javax.swing.JButton();
        result = new javax.swing.JScrollPane();
        textR = new javax.swing.JTextArea();
        id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        torsoComb = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 1800));
        setPreferredSize(new java.awt.Dimension(541, 947));

        vt2.setText("vt2");

        vt2X.setMinimum(-100);
        vt2X.setValue(0);
        vt2X.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                vl5XMouseReleased(evt);
            }
        });
        vt2X.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                vl5XMouseMoved(evt);
            }
        });

        vt2Y.setMinimum(-100);
        vt2Y.setValue(0);
        vt2Y.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                vl5XMouseReleased(evt);
            }
        });
        vt2Y.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                vl5XMouseMoved(evt);
            }
        });

        vt2Z.setMinimum(-100);
        vt2Z.setValue(0);
        vt2Z.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                vl5XMouseReleased(evt);
            }
        });
        vt2Z.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                vl5XMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(vt2)
                .addGap(47, 47, 47)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(vt2Y, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(vt2X, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vt2Z, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vt2X, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(vt2Y, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vt2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vt2Z, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        vt5.setText("vt5");

        vt5X.setMinimum(-100);
        vt5X.setValue(0);
        vt5X.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                vl5XMouseReleased(evt);
            }
        });
        vt5X.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                vl5XMouseMoved(evt);
            }
        });

        vt5Y.setMinimum(-100);
        vt5Y.setValue(0);
        vt5Y.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                vl5XMouseReleased(evt);
            }
        });
        vt5Y.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                vl5XMouseMoved(evt);
            }
        });

        vt5Z.setMinimum(-100);
        vt5Z.setValue(0);
        vt5Z.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                vl5XMouseReleased(evt);
            }
        });
        vt5Z.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                vl5XMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(vt5)
                .addGap(47, 47, 47)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(vt5X, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(vt5Y, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vt5Z, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vt5X, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(vt5Y, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vt5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vt5Z, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel9.setPreferredSize(new java.awt.Dimension(412, 108));

        vt12.setText("vt12");

        vt12X.setMinimum(-100);
        vt12X.setValue(0);
        vt12X.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                vl5XMouseReleased(evt);
            }
        });
        vt12X.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                vl5XMouseMoved(evt);
            }
        });

        vt12Y.setMinimum(-100);
        vt12Y.setValue(0);
        vt12Y.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                vl5XMouseReleased(evt);
            }
        });
        vt12Y.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                vl5XMouseMoved(evt);
            }
        });

        vt12Z.setMinimum(-100);
        vt12Z.setValue(0);
        vt12Z.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                vl5XMouseReleased(evt);
            }
        });
        vt12Z.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                vl5XMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(vt12)
                .addGap(41, 41, 41)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(vt12Y, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                    .addComponent(vt12X, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vt12Z, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vt12X, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(vt12Y, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vt12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vt12Z, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel10.setPreferredSize(new java.awt.Dimension(412, 108));

        vl5.setText("vl5");

        vl5X.setMinimum(-100);
        vl5X.setValue(0);
        vl5X.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                vl5XMouseReleased(evt);
            }
        });
        vl5X.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                vl5XMouseMoved1(evt);
            }
        });

        vl5Y.setMinimum(-100);
        vl5Y.setValue(0);
        vl5Y.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                vl5XMouseReleased(evt);
            }
        });
        vl5Y.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                vl5XMouseMoved(evt);
            }
        });

        vl5Z.setMinimum(-100);
        vl5Z.setValue(0);
        vl5Z.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                vl5XMouseReleased(evt);
            }
        });
        vl5Z.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                vl5XMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(vl5)
                .addGap(47, 47, 47)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(vl5Y, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                    .addComponent(vl5X, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vl5Z, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vl5X, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(vl5Y, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vl5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vl5Z, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 100));

        send.setText("send");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        textR.setColumns(20);
        textR.setRows(5);
        textR.setPreferredSize(new java.awt.Dimension(164, 200));
        result.setViewportView(textR);

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(send)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(send)
                .addGap(27, 27, 27))
        );

        jButton1.setText("sendTorso");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        torsoComb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        torsoComb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                torsoCombActionPerformed(evt);
            }
        });

        jButton2.setText("reload");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(42, 42, 42)
                .addComponent(torsoComb, 0, 214, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(82, 82, 82))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(torsoComb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))
                        .addContainerGap())
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vl5XMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vl5XMouseMoved
        // TODO add your handling code here:

    }//GEN-LAST:event_vl5XMouseMoved

    private void vl5XMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vl5XMouseReleased
        // TODO add your handling code here:
        send();
    }//GEN-LAST:event_vl5XMouseReleased

    private void vl5XMouseMoved1(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vl5XMouseMoved1
        // TODO add your handling code here:
    }//GEN-LAST:event_vl5XMouseMoved1

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        // TODO add your handling code here:
        send();
    }//GEN-LAST:event_sendActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        loadTorso();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void torsoCombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_torsoCombActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_torsoCombActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        List<Signal> Gsignals = new ArrayList<Signal>();
        TorsoSignal torso = new TorsoSignal("sd");
        torso.setReference(torsoComb.getSelectedItem().toString());
        torso.getStart().setValue(0);

        Gsignals.add(torso);
        ID id = IDProvider.createID("Torsoditor");
        for (SignalPerformer perf : signalPerformers) {
            perf.performSignals(Gsignals, id, new Mode(CompositionType.replace));
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    void loadTorso(){
        torsoComb.removeAllItems();
        Gestuary.global_gestuary.refreshAll();
        List<SignalEntry<TorsoSignal>> signals = TorsoLibrary.globalLibrary.getAll();
        for (SignalEntry<TorsoSignal> signal : signals) {
            torsoComb.addItem(signal.getParamName());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TorsoEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TorsoEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TorsoEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TorsoEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TorsoEditor().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane result;
    private javax.swing.JButton send;
    private javax.swing.JTextArea textR;
    private javax.swing.JComboBox torsoComb;
    private javax.swing.JLabel vl5;
    private javax.swing.JSlider vl5X;
    private javax.swing.JSlider vl5Y;
    private javax.swing.JSlider vl5Z;
    private javax.swing.JLabel vt12;
    private javax.swing.JSlider vt12X;
    private javax.swing.JSlider vt12Y;
    private javax.swing.JSlider vt12Z;
    private javax.swing.JLabel vt2;
    private javax.swing.JSlider vt2X;
    private javax.swing.JSlider vt2Y;
    private javax.swing.JSlider vt2Z;
    private javax.swing.JLabel vt5;
    private javax.swing.JSlider vt5X;
    private javax.swing.JSlider vt5Y;
    private javax.swing.JSlider vt5Z;
    // End of variables declaration//GEN-END:variables

    @Override
    public void addBAPFramesPerformer(BAPFramesPerformer bapfp) {
        if (bapfp != null) {
            _bapframesPerformer.add(bapfp);
        }
    }

    @Override
    public void removeBAPFramesPerformer(BAPFramesPerformer bapfp) {
        _bapframesPerformer.remove(bapfp);
    }

    void sendFrames(List<BAPFrame> bapframes, ID requestId) {
        for (int i = 0; i < _bapframesPerformer.size(); ++i) {
            BAPFramesPerformer performer = _bapframesPerformer.get(i);
            performer.performBAPFrames(bapframes, requestId);
        }
    }

    /**
     *
     * @param info
     * @param index
     * @return the {@code BAPFrame} at the specified index
     */
    public BAPFrame getBapFrame(Frame info, int index) {
        BAPFrame bf = new BAPFrame();
        bf.setFrameNumber(index);
        HashMap<String, Quaternion> results = info.getRotations();
        Iterator iterator = results.keySet().iterator();
        while (iterator.hasNext()) {
            String name = (String) iterator.next();
            Quaternion q = results.get(name);
            Vec3d angle = q.getEulerAngleXYZ();
            JointType joint = JointType.get(name);
            BAPType z = joint.rotationZ;
            BAPType y = joint.rotationY;
            BAPType x = joint.rotationX;
            bf.setRadianValue(z, angle.z());
            bf.setRadianValue(y, angle.y());
            bf.setRadianValue(x, angle.x());
        }
        //_bframe = bf.clone();
        return bf;
    }

    @Override
    public void addSignalPerformer(SignalPerformer sp) {
        if (sp != null) {
            signalPerformers.add(sp);
        }
    }

    @Override
    public void removeSignalPerformer(SignalPerformer performer) {
        if (performer != null) {
            signalPerformers.add(performer);
        }
    }
}
