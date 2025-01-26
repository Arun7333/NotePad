package com.util;

import com.gui.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Constants {
    public static Map<String, List<JMenuItem>> MENU;
    private static Functions functions;

    static{
        MENU = new LinkedHashMap<>();
    }

    public static void setConstants(GUI gui){
        functions = gui.getFunctions();
        addFileMenu();
        addEditMenu();
        addFormatMenu();
        addColorMenu();
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


        MENU.put("File", Arrays.asList(iNew, iOpen, iSave, iSaveAs, iExit));
    }

    public static void addEditMenu(){


        MENU.put("Edit", Arrays.asList());
    }

    public static void addFormatMenu(){


        MENU.put("Format", Arrays.asList());
    }

    public static void addColorMenu(){


        MENU.put("Color", Arrays.asList());
    }
}
