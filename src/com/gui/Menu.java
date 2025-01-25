package com.gui;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private JMenu menu;
    private Map<String, JMenuItem> menuItems;

    Menu(String menuName){
        menu = new JMenu(menuName);
        menuItems = new HashMap<>();
    }

    public void addMenuItems(List<String> items){

        for(String itemName : items){
            JMenuItem newItem = new JMenuItem(itemName);
            menu.add(newItem);
            menuItems.put(itemName, newItem);
        }
    }

    public JMenu getMenuObject(){
        return menu;
    }

    public JMenuItem getItem(String name){
        return menuItems.get(name);
    }

    public void removeItem(String name){
        menu.remove(menuItems.get(name));
        menuItems.remove(name);
    }
}
