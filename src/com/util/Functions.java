package com.util;

import com.gui.GUI;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Functions {
    private GUI gui;

    public Functions(GUI gui){
        this.gui = gui;
    }

    public void newFile(){
        gui.getTextArea().setText("");
        gui.getWindow().setTitle("New");
    }

    public void open(){
        FileDialog fileDialog = new FileDialog(gui.getWindow(), "Open Text File", FileDialog.LOAD);
        fileDialog.setVisible(true);

        if(fileDialog.getFile() != null){
            String fileName = fileDialog.getFile();
            String filePath = fileDialog.getDirectory();

            gui.getWindow().setTitle(fileName);

            try(BufferedReader reader = new BufferedReader(new FileReader(filePath + fileName))){
                String line = null;

                gui.getTextArea().setText("");
                while((line = reader.readLine()) != null){
                    gui.getTextArea().append(line + "\n");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
