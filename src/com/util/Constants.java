package com.util;

import com.gui.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Constants {
    public static Map<String, List<JMenuItem>> MENU;
    private static Functions functions;
    private static String[] fontSizes;
    private static String[] fontStyles;

    static{
        MENU = new LinkedHashMap<>();
        fontSizes = new String[] {"8", "12", "18", "24", "28"};
        fontStyles = new String[] {"Arial", "Gill Sans MT", "Times New Roman"};
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
        JMenuItem iNew = new JMenuItem("new");
        JMenuItem iOpen = new JMenuItem("open");
        JMenuItem iSave = new JMenuItem("save");
        JMenuItem iSaveAs = new JMenuItem("save as");
        JMenuItem iExit = new JMenuItem("exit");

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

    public static void addEditMenu(){


        MENU.put("Edit", Arrays.asList());
    }

    public static void addColorMenu(){


        MENU.put("Color", Arrays.asList());
    }
}
