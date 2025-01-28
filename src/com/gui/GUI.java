package com.gui;

import com.util.Constants;
import com.util.Functions;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.*;

public class GUI {
    private JFrame window;
    private JTextArea textArea;
    private MenuBar menuBar;
    private Functions functions;
    private UndoManager undoManager;

    public GUI(){
        undoManager = new UndoManager();
        createWindow();
        createTextArea();

        Constants.setConstants(this);
        createMenuBar();

        window.revalidate();
        window.repaint();
    }

    private void createWindow(){

        window = new JFrame("NotePad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setVisible(true);
    }

    private void createTextArea(){

        textArea = new JTextArea();
        textArea.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
                    @Override
                    public void undoableEditHappened(UndoableEditEvent e) {
                        undoManager.addEdit(e.getEdit());
                    }
                }
        );

        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        window.add(scrollPane);
    }

    private void createMenuBar(){
        menuBar = new MenuBar();
        menuBar.getMenuBar().setVisible(true);

        menuBar.addMenus(Constants.MENU);
        window.setJMenuBar(menuBar.getMenuBar());
    }

    public Functions getFunctions(){
        if(functions != null){
            return functions;
        }

        return functions = new Functions(this);
    }

    public JFrame getWindow(){
        return window;
    }

    public JTextArea getTextArea(){
        return textArea;
    }

    public MenuBar getMenuBar(){
        return menuBar;
    }

    public UndoManager getUndoManager(){
        return undoManager;
    }
}
