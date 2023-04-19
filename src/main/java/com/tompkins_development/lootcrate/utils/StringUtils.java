package com.tompkins_development.lootcrate.utils;

import org.bukkit.ChatColor;

public class StringUtils {

    public static String strip(String s) {
        String newString = s.toString();
        newString = newString
                .replaceAll("[\\\\/:*?\"<>|]", "")
                .replace(" ", "_")
                .toLowerCase();
        System.out.println(newString);
        return newString;
    }

}
