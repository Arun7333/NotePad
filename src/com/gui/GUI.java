package com.gui;

import com.util.Constants;
import com.util.Functions;

import javax.swing.*;
import java.awt.*;

public class GUI {
    private JFrame window;
    private JTextArea textArea;
    private MenuBar menuBar;
    private Functions functions;

    public GUI(){
        Constants.setConstants(this);
        createWindow();
        createTextArea();
        createMenuBar();
    }

    private void createWindow(){

        window = new JFrame("NotePad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setVisible(true);
    }

    private void createTextArea(){

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        window.add(scrollPane);
    }

    private void createMenuBar(){
        menuBar = new MenuBar();
        window.setJMenuBar(menuBar.getMenuBar());

        menuBar.addMenus(Constants.MENU);

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
}
