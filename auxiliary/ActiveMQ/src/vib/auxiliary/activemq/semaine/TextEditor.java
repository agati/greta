/*
 * This file is part of the auxiliaries of Greta.
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
/*
 * TextEditor.java
 *
 * Created on 20 juin 2012, 12:52:39
 */
package vib.auxiliary.activemq.semaine;

import vib.auxiliary.activemq.TextSender;
import vib.core.util.IniManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;

/**
 *
 * @author Andre-Marie Pez
 */
public class TextEditor extends javax.swing.JFrame {

    private File currentFile = null;
    private TextSender sender;
    private javax.swing.text.Document editorPaneDocument;
    private javax.swing.undo.UndoManager undoManager = new javax.swing.undo.UndoManager();
    private javax.swing.event.UndoableEditListener undoHandler = new javax.swing.event.UndoableEditListener() {
        @Override
        public void undoableEditHappened(javax.swing.event.UndoableEditEvent e) {
            undoManager.addEdit(e.getEdit());
            undoAction.update();
            redoAction.update();
        }
    };
    private UndoAction undoAction = null;
    private RedoAction redoAction = null;

    public void setSender(TextSender sender) {
        this.sender = sender;
    }

    public TextSender getSender() {
        return sender;
    }

    public void setCurrentDirectory(String directory){
        openFileChooser.setCurrentDirectory(new File(directory));
    }

    public String getCurrentDirectory(){
        try {
            return openFileChooser.getCurrentDirectory().getCanonicalPath();
        } catch (Exception ex) {
            return "./";
        }
    }

    @Override
    public void setLocale(Locale l) {
        super.setLocale(l);
        if(openFileChooser!=null){
            openFileChooser.setLocale(l);
            openFileChooser.updateUI();
        }
        // update text in "file" menu
        if(fileMenu!=null){fileMenu.setText(IniManager.getLocaleProperty("GUI.file", l));}
        if(newMenuItem!=null){newMenuItem.setText(IniManager.getLocaleProperty("GUI.new", l));}
        if(openMenuItem!=null){openMenuItem.setText(IniManager.getLocaleProperty("GUI.open", l));}
        if(saveMenuItem!=null){saveMenuItem.setText(IniManager.getLocaleProperty("GUI.save", l));}
        if(saveAsMenuItem!=null){saveAsMenuItem.setText(IniManager.getLocaleProperty("GUI.saveAs", l));}

        // update text in "edit" menu
        if(editMenu!=null){editMenu.setText(IniManager.getLocaleProperty("GUI.edit", l));}
        if(undoAction!=null){undoAction.update();}
        if(redoAction!=null){redoAction.update();}

        // update text in "send" button
        if(sendButton!=null){sendButton.setText(IniManager.getLocaleProperty("GUI.send", l));}
    }



    /** Creates new form TextEditor */
    public TextEditor() {
        initComponents();
        //jTextPane1.setText("\u32db\u32e1");
        editorPaneDocument = jTextPane1.getDocument();
        editorPaneDocument.addUndoableEditListener(undoHandler);

        KeyStroke undoKeystroke = KeyStroke.getKeyStroke(KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK);
        KeyStroke redoKeystroke = KeyStroke.getKeyStroke(KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK);

        undoAction = new UndoAction();
        jTextPane1.getInputMap().put(undoKeystroke, "undoKeystroke");
        jTextPane1.getActionMap().put("undoKeystroke", undoAction);

        redoAction = new RedoAction();
        jTextPane1.getInputMap().put(redoKeystroke, "redoKeystroke");
        jTextPane1.getActionMap().put("redoKeystroke", redoAction);

        JMenuItem undoMenuItem = new JMenuItem(undoAction);
        undoMenuItem.setAccelerator(undoKeystroke);
        JMenuItem redoMenuItem = new JMenuItem(redoAction);
        redoMenuItem.setAccelerator(redoKeystroke);
        editMenu.add(undoMenuItem);
        editMenu.add(redoMenuItem);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new JTextPane()
        {
            public boolean getScrollableTracksViewportWidth()
            {
                return getUI().getPreferredSize(this).width 
                <= getParent().getSize().width;
            }
        };
        sendButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newMenuItem = new javax.swing.JMenuItem();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();

        openFileChooser.setCurrentDirectory(new java.io.File("./"));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jTextPane1);

        sendButton.setText(vib.core.util.IniManager.getLocaleProperty("GUI.send"));
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        fileMenu.setText(vib.core.util.IniManager.getLocaleProperty("GUI.file"));

        newMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newMenuItem.setText(vib.core.util.IniManager.getLocaleProperty("GUI.new"));
        newMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(newMenuItem);

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenuItem.setText(vib.core.util.IniManager.getLocaleProperty("GUI.open"));
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenuItem.setText(vib.core.util.IniManager.getLocaleProperty("GUI.save"));
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveAsMenuItem.setText(vib.core.util.IniManager.getLocaleProperty("GUI.saveAs"));
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenuItem);

        jMenuBar1.add(fileMenu);

        editMenu.setText(vib.core.util.IniManager.getLocaleProperty("GUI.edit"));
        jMenuBar1.add(editMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                    .addComponent(sendButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        if (sender != null) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("content-id", "textEditor_" + System.currentTimeMillis());
            sender.send(jTextPane1.getText(), map);
        }
    }//GEN-LAST:event_sendButtonActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        if (openFileChooser.showOpenDialog(this) == javax.swing.JFileChooser.APPROVE_OPTION) {
            currentFile = openFileChooser.getSelectedFile();
            load();
        }
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void newMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMenuItemActionPerformed
        currentFile = null;
        load();
    }//GEN-LAST:event_newMenuItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        if(currentFile == null) {
            saveAsMenuItemActionPerformed(evt);
        }
        else {
            save();
        }
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed
        openFileChooser.setSelectedFile(currentFile);
        System.out.println(openFileChooser.getSelectedFile());
        if (openFileChooser.showSaveDialog(this) == javax.swing.JFileChooser.APPROVE_OPTION) {
            currentFile = openFileChooser.getSelectedFile();
            save();
        }
    }//GEN-LAST:event_saveAsMenuItemActionPerformed

    private void save(){
        try {
            FileWriter out = new FileWriter(currentFile);
            out.write(jTextPane1.getText());
            out.close();
        } catch (Exception ex) {}
    }

    private void load(){
        editorPaneDocument.removeUndoableEditListener(undoHandler);
        undoManager.discardAllEdits();
        try {
            jTextPane1.setPage(currentFile.toURI().toURL());
        } catch (Exception ex) {
            jTextPane1.setDocument(new DefaultStyledDocument());
            currentFile = null;
        }
        editorPaneDocument = jTextPane1.getDocument();
        editorPaneDocument.addUndoableEditListener(undoHandler);
        redoAction.update();
        undoAction.update();
    }


    class UndoAction extends AbstractAction {
        public UndoAction() { update(); }
        @Override
        public void actionPerformed(ActionEvent e) {
            try { undoManager.undo(); }
            catch (Exception ex) {}
            update();
            redoAction.update();
        }
        protected final void update() {
            putValue(Action.NAME, vib.core.util.IniManager.getLocaleProperty("GUI.undo"));
            setEnabled(undoManager.canUndo());
        }
    }
    class RedoAction extends AbstractAction {
        public RedoAction() { update(); }
        @Override
        public void actionPerformed(ActionEvent e) {
            try { undoManager.redo(); }
            catch (Exception ex) {}
            update();
            undoAction.update();
        }
        protected final void update() {
            putValue(Action.NAME, vib.core.util.IniManager.getLocaleProperty("GUI.redo"));
            setEnabled(undoManager.canRedo());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JMenuItem newMenuItem;
    private javax.swing.JFileChooser openFileChooser;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JButton sendButton;
    // End of variables declaration//GEN-END:variables
}
