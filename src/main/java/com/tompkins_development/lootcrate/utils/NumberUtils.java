package com.tompkins_development.lootcrate.utils;

import java.util.Random;

public class NumberUtils {

    public static int generateRandomInt(int length) {
        return length < 1 ? 0 : new Random()
                .nextInt((9 * (int) Math.pow(10, length - 1)) - 1)
                + (int) Math.pow(10, length - 1);
    }

}
