package com.util;

import com.gui.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class Constants {
    public static Map<String, List<JMenuItem>> MENU;
    private static Functions functions;
    private static String[] fontSizes;
    private static String[] fontStyles;
    private static String[] colors;
    public static Map<String, ColorDetails> colorDetails;

    static{
        MENU = new LinkedHashMap<>();
        fontSizes = new String[] {"8", "12", "18", "24", "28"};
        fontStyles = new String[] {"Arial", "Gill Sans MT", "Times New Roman"};
        colors = new String[]{"White", "Black", "Blue"};
        colorDetails = new HashMap<>();
        colorDetails.put("White", new ColorDetails(Color.white, Color.black));
        colorDetails.put("Black", new ColorDetails(Color.black, Color.white));
        colorDetails.put("Blue", new ColorDetails(Color.blue, Color.yellow));
    }

    public static void setConstants(GUI gui){
        functions = gui.getFunctions();
        addFileMenu();
        addEditMenu();
        addFormatMenu();
        addColorMenu();
    }

    public static void addFormatMenu(){
        JMenuItem iWrap = new JMenuItem("Word Wrap : Off");

        JMenu font = new JMenu("Font");
        JMenu fontSize = new JMenu("Font Size");

        iWrap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functions.wrapWords();
            }
        });

        ActionListener fontStyleListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();

                functions.setFont(command.trim());
            }
        };

        ActionListener fontSizeListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();

                functions.setFontSize(Integer.parseInt(command));
            }
        };


        //creating and adding Font style menu items
        for(String style : fontStyles){
            JMenuItem styleItem = new JMenuItem(style);

            styleItem.setActionCommand(style);
            styleItem.addActionListener(fontStyleListener);
            font.add(styleItem);
        }


        //creating and adding Font sizes menu items
        for(String size : fontSizes){
            JMenuItem sizeItem = new JMenuItem(size);

            sizeItem.setActionCommand(size);
            sizeItem.addActionListener(fontSizeListener);
            fontSize.add(sizeItem);
        }



        MENU.put("Format", Arrays.asList(iWrap, font, fontSize));
    }

    public static void addFileMenu(){
        JMenuItem iNew = new JMenuItem("New");
        JMenuItem iOpen = new JMenuItem("Open");
        JMenuItem iSave = new JMenuItem("Save");
        JMenuItem iSaveAs = new JMenuItem("Save As");
        JMenuItem iExit = new JMenuItem("Exit");

        iNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functions.newFile();
            }
        });

        iOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functions.open();
            }
        });

        iSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functions.save();
            }
        });

        iSaveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functions.saveAs();
            }
        });

        iExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functions.exit();
            }
        });


        MENU.put("File", Arrays.asList(iNew, iOpen, iSave, iSaveAs, iExit));
    }

    public static void addColorMenu(){
        List<JMenuItem> colorItems = new ArrayList<>();
        ActionListener colorListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                functions.setColor(command);
            }
        };

        for(String color : colors){
            JMenuItem newColor = new JMenuItem(color);
            newColor.setActionCommand(color);
            newColor.addActionListener(colorListener);

            colorItems.add(newColor);
        }

        MENU.put("Color", colorItems);
    }

    public static void addEditMenu(){
        JMenuItem iUndo = new JMenuItem("Undo");
        JMenuItem iRedo = new JMenuItem("Redo");

        iUndo.setActionCommand("Undo");
        iRedo.setActionCommand("Redo");

        iUndo.addActionListener((e) -> functions.undo());
        iRedo.addActionListener((e) -> functions.redo());

        MENU.put("Edit", Arrays.asList(iUndo, iRedo));
    }
}
