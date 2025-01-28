package com.util;

import com.gui.GUI;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Map;

public class Functions {
    private GUI gui;
    private String fileName;
    private String filePath;
    public boolean iSWrapped = false;
    public String selectedFont;
    private int selectedFontSize;


    public Functions(GUI gui){
        this.gui = gui;
        selectedFont = "Times New Roman";
        setFontSize(8);
    }

    public void newFile(){
        gui.getTextArea().setText("");
        gui.getWindow().setTitle("New");

        fileName = null;
        filePath = null;
    }

    public void open(){
        FileDialog fileDialog = new FileDialog(gui.getWindow(), "Open Text File", FileDialog.LOAD);
        fileDialog.setVisible(true);

        if(fileDialog.getFile() != null){
            fileName = fileDialog.getFile();
            filePath = fileDialog.getDirectory();

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

    public void save(){

        if(fileName == null){
            saveAs();
        }
        else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath + fileName))) {

                writer.write(gui.getTextArea().getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void saveAs(){
        FileDialog fileDialog = new FileDialog(gui.getWindow(), "Save As", FileDialog.SAVE);
        fileDialog.setVisible(true);

        if(fileDialog.getFile() != null){
            fileName = fileDialog.getFile();
            filePath = fileDialog.getDirectory();

            gui.getWindow().setTitle(fileName);
            save();
        }
    }

    public void exit(){
        System.exit(0);
    }

    public void wrapWords(){
        if(!iSWrapped){
            iSWrapped = true;
            gui.getTextArea().setLineWrap(true);
            gui.getTextArea().setWrapStyleWord(true);

            gui.getMenuBar().getMenu("Format").getItem("Word Wrap : Off").setText("Word Wrap : On");
        }
        else{
            iSWrapped = false;
            gui.getTextArea().setLineWrap(false);
            gui.getTextArea().setWrapStyleWord(false);

            gui.getMenuBar().getMenu("Format").getItem("Word Wrap : Off").setText("Word Wrap : Off");
        }
    }

    public void setFontSize(int fontSize){
        selectedFontSize = fontSize;

        setFont(selectedFont);
    }

    public void setFont(String fontName){
        selectedFont = fontName;

        gui.getTextArea().setFont(new Font(selectedFont, Font.PLAIN, selectedFontSize));
    }

    public void setColor(String colorName){
        Color bgColor = Constants.colorDetails.get(colorName).backGroundColor;
        Color fgColor = Constants.colorDetails.get(colorName).frontGroundColor;

        gui.getWindow().getContentPane().setBackground(bgColor);
        gui.getTextArea().setBackground(bgColor);
        gui.getTextArea().setForeground(fgColor);
    }

    public void undo(){
        if(gui.getUndoManager().canUndo()) {
            gui.getUndoManager().undo();
        }
    }

    public void redo(){
        if(gui.getUndoManager().canRedo()) {
            gui.getUndoManager().redo();
        }
    }
}
