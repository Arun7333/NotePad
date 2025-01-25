package com.util;

import java.util.*;

public class Constants {
    public static Map<String, List<String>> MENU;

    static{
        MENU = new HashMap<>();
        MENU.put("File", Arrays.asList("Save", "Save as"));
        MENU.put("Font", Arrays.asList("Big", "small", "medium"));
    }
}
