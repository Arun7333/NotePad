package com.gui;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuBar {
    private JMenuBar menuBar;
    private Map<String, Menu> menus;

    MenuBar(){
        menuBar = new JMenuBar();
        menus = new HashMap<>();
    }

    public void addMenus(Map<String, List<JMenuItem>> menus){

        for(Map.Entry<String, List<JMenuItem>> entry : menus.entrySet()){
            String menuName = entry.getKey();
            List<JMenuItem> menuItems = entry.getValue();

            Menu newMenu = new Menu(menuName);
            menuItems.stream().forEach(item -> newMenu.addItem(item));

            menuBar.add(newMenu.getMenuObject());
            this.menus.put(menuName, newMenu);
        }
    }

    public JMenuBar getMenuBar(){
        return menuBar;
    }

    public Menu getMenu(String menuName){
        return menus.get(menuName);
    }
}
