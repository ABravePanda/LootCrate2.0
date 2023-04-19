package com.tompkins_development.lootcrate.utils;

import org.bukkit.ChatColor;

public class StringUtils {

    public static String strip(String s) {
        String newString = s.toString();
        newString = newString
                .replaceAll("[\\\\/:*?\"<>|]", "")
                .replace(" ", "_")
                .toLowerCase();
        newString = ChatColor.translateAlternateColorCodes('&', newString);
        newString = ChatColor.stripColor(newString);
        return newString;
    }

}
