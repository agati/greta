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
package vib.tools.editors;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import vib.core.util.time.Temporizable;

/**
 *
 * @author Andre-Marie
 */
public abstract class MultiTimeLineEditors<T extends Temporizable> extends javax.swing.JFrame {
    public static final double MAX_TIME = 3600;//1 hour
    public static final double MIN_TIME = 0.5;
    private static final double base_time = 10;
    private static final String time_characters = "0123456789.";
    private double actualTime = base_time;

    private File currentFile = null;
    private ArrayList<TimeLineManager<? extends T>> timeLines = new ArrayList<TimeLineManager<? extends T>>();

    private javax.swing.GroupLayout jPanel1Layout_;
    private javax.swing.GroupLayout.SequentialGroup verticalGroup;
    private javax.swing.GroupLayout.ParallelGroup horizontalGroup;


    /** Creates new form MultiTimeLineEditors */
    public MultiTimeLineEditors() {
        initComponents();
        setTime(base_time);
        jPanel1Layout_ = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout_);
        horizontalGroup = jPanel1Layout_.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        jPanel1Layout_.setHorizontalGroup(horizontalGroup);
        verticalGroup = jPanel1Layout_.createSequentialGroup();
        jPanel1Layout_.setVerticalGroup(jPanel1Layout_.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(verticalGroup));

        Rule<T> r = new Rule<T>();
        r.setColor(Color.white);
        addTimeLine(new TimeLineManager<T>(r));
        
    }

    protected void setFileFilter(javax.swing.filechooser.FileFilter fileFilter){
        openFileChooser.removeChoosableFileFilter(openFileChooser.getAcceptAllFileFilter());
        openFileChooser.addChoosableFileFilter(fileFilter);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        openFileChooser = new javax.swing.JFileChooser();
        openFileChooser.setCurrentDirectory(new File("./"));
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        durationTextField = new javax.swing.JTextField();
        secondsLabel = new javax.swing.JLabel();
        durationLabel = new javax.swing.JLabel();
        updateCheckBox = new javax.swing.JCheckBox();
        jButton1 = new vib.core.utilx.gui.ToolBox.LocalizedJButton("GUI.send");
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new vib.core.utilx.gui.ToolBox.LocalizedJMenu("GUI.file");
        newMenuItem = new vib.core.utilx.gui.ToolBox.LocalizedJMenuItem("GUI.new");
        openMenuItem = new vib.core.utilx.gui.ToolBox.LocalizedJMenuItem("GUI.open");
        saveMenuItem = new vib.core.utilx.gui.ToolBox.LocalizedJMenuItem("GUI.save");
        saveAsMenuItem = new vib.core.utilx.gui.ToolBox.LocalizedJMenuItem("GUI.saveAs");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jPanel1MouseWheelMoved(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 228, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        durationTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        durationTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                durationTextFieldActionPerformed(evt);
            }
        });
        durationTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                durationTextFieldFocusLost(evt);
            }
        });
        durationTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                durationTextFieldKeyTyped(evt);
            }
        });

        secondsLabel.setText("second(s)");

        durationLabel.setText("Duration: ");

        updateCheckBox.setText("Update from events");
        updateCheckBox.setEnabled(false);
        updateCheckBox.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        updateCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        newMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(newMenuItem);

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenuItem);

        jMenuBar1.add(fileMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(durationLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(durationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(secondsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateCheckBox))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(durationLabel)
                    .addComponent(durationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(secondsLabel)
                    .addComponent(updateCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void durationTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_durationTextFieldKeyTyped
        char pressed = evt.getKeyChar();
        if(time_characters.contains(""+pressed)){
            try{ Double.parseDouble(durationTextField.getText() + pressed); }
            catch(Exception e){ evt.consume(); }
        }
        else evt.consume();
    }//GEN-LAST:event_durationTextFieldKeyTyped

    private void durationTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_durationTextFieldActionPerformed
        updateTime();
    }//GEN-LAST:event_durationTextFieldActionPerformed

    private void durationTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_durationTextFieldFocusLost
        updateTime();
    }//GEN-LAST:event_durationTextFieldFocusLost

    private void newMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMenuItemActionPerformed
        int dialogButton = JOptionPane.YES_NO_CANCEL_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (this, "Would you like to save your current file first?", "Warning", dialogButton);
        
        switch (dialogResult) {
            case JOptionPane.YES_OPTION:
            {
                boolean outcome = save();
                // if file was not saved ends here
                if (!outcome) { break; }
                //Else drops to the NO_OPTION case and clears the timeline
            }
            case JOptionPane.NO_OPTION: {
                newFile();
                currentFile = null;
                clearTimeLines();
                break;
            }
            case JOptionPane.CANCEL_OPTION: {}
        }       
        
    }//GEN-LAST:event_newMenuItemActionPerformed

    private void jPanel1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jPanel1MouseWheelMoved
        zoom(evt.getWheelRotation()*-30);
    }//GEN-LAST:event_jPanel1MouseWheelMoved

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        if(currentFile!=null) {
            openFileChooser.setCurrentDirectory(currentFile.getParentFile());
        }
        openFileChooser.setLocale(Locale.getDefault());
        openFileChooser.updateUI();
        if(openFileChooser.showOpenDialog(this) == javax.swing.JFileChooser.APPROVE_OPTION){
            currentFile = openFileChooser.getSelectedFile();
            clearTimeLines();
            loadFile(currentFile);
        }
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        performTestButton();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed
        saveAsShowDialog();
    }//GEN-LAST:event_saveAsMenuItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        save();
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private boolean save() {
        if(currentFile==null) {
            return saveAsShowDialog();
        }
        else{
            saveAs(currentFile.getAbsolutePath());
            return true;
        }
    }

    protected void clearTimeLines(){
        
        for(TimeLineManager<? extends T> tlm : timeLines) {
            tlm.timeline.clear();
        }
    }
        
    public boolean isUpdatedFromEvent(){
        return updateCheckBox!=null && updateCheckBox.isSelected();
    }
    public void setUpdatedFromEvent(boolean updated){
        updateCheckBox.setSelected(updated);
    }

    public List<T> getAllTemporizable(){
        ArrayList<T> list = new ArrayList<T>();
        for(TimeLineManager<? extends T> tlm : timeLines){
            for(TemporizableContainer<? extends T> tc :tlm.timeline.getItems()){
                list.add(tc.getTemporizable());
            }
        }
        return list;
    }
    
    
    public List<? extends TemporizableContainer<? extends T>> getAllTemporizableContainers(){
        ArrayList<TemporizableContainer<? extends T>> list = new ArrayList<TemporizableContainer<? extends T>>();
        for(TimeLineManager<? extends T> tlm : timeLines){
            for(TemporizableContainer<? extends T> tc :tlm.timeline.getItems()){
                list.add(tc);
            }
        }
        return list;
    }
    
    private void zoom(int pixels){
        Dimension d = new Dimension(jPanel1.getWidth() + pixels, timelinesHeight);
        jPanel1.setPreferredSize(d);
        jPanel1.setSize(d);
    }

    protected void setTime(double time){
        durationTextField.setText(""+time);
        for(TimeLineManager<? extends T> tlm : timeLines) {
            tlm.timeline.setTotalDuration(time);
        }
    }

    private void updateTime(){
        actualTime = Double.parseDouble(durationTextField.getText());
        if(actualTime < MIN_TIME) {
            actualTime = MIN_TIME;
        }
        if(actualTime > MAX_TIME) {
            actualTime = MAX_TIME;
        }
        setTime(actualTime);
    }

    private int timelinesHeight = 0;
    public void addTimeLine(TimeLineManager<? extends T> tlm){
        tlm.timeline.setTotalDuration(actualTime);
        horizontalGroup.addComponent(tlm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        verticalGroup.addComponent(tlm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
        timeLines.add(tlm);
        timelinesHeight+=tlm.getPreferredSize().getHeight();
        
    }
    
    private boolean saveAsShowDialog() {
        if(currentFile!=null) {
            openFileChooser.setCurrentDirectory(currentFile.getParentFile());
        }
       
        openFileChooser.setLocale(Locale.getDefault());
        openFileChooser.updateUI();
        if(openFileChooser.showSaveDialog(this) == javax.swing.JFileChooser.APPROVE_OPTION){
            File prevFile = currentFile;
            currentFile = openFileChooser.getSelectedFile();
            if ((currentFile != null) && currentFile.exists()) {
                int response = JOptionPane.showConfirmDialog(this,
                    "The file " + currentFile.getName() + 
                    " already exists. Do you want to replace the existing file?",
                    "Confirm Save As", JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
                if (response == JOptionPane.YES_OPTION)
                {
                    saveAs(currentFile.getAbsolutePath());
                    return true;
                }
                else {
                    currentFile = prevFile;
                    return false;
                }
            } else {
                if (currentFile != null) {
                    saveAs(currentFile.getAbsolutePath());
                    return true;
                }
                else {
                    return false;
                }
            } 
        }
        return false;
    }
    
    public List<String> getNonEmptyTimeLineLables(){
        
        ArrayList<String> output = new ArrayList<String>();
        
        for(TimeLineManager<? extends T> tlm : timeLines){
            if (tlm.notEmpty()) {
                output.add(tlm.getLabel());
            }
        }
        return output;
    }
    
    public TimeLineManager<? extends T> getTimeLineManager(String type) {
        for(TimeLineManager<? extends T> tlm : timeLines){
            if (tlm.getLabel().equalsIgnoreCase(type)) {
                return tlm;
            }
        }
        return null;
    }
    
    protected abstract void loadFile(File f);
    protected abstract void performTestButton();
    protected abstract void saveAs(String filename);
    protected abstract void newFile();


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel durationLabel;
    private javax.swing.JTextField durationTextField;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem newMenuItem;
    private javax.swing.JFileChooser openFileChooser;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JLabel secondsLabel;
    protected javax.swing.JCheckBox updateCheckBox;
    // End of variables declaration//GEN-END:variables
}
