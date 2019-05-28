package com.iustu.avatar.util;

import java.awt.*;
import java.util.Random;

public class ColorGenerator {

    /**
     * Return a random color that meets certain conditions.
     * @return
     */
    public static Color generateColor() {
        Random random = new Random();
        int r, g, b;
        do {
            r = random.nextInt(255);
            g = random.nextInt(255);
            b = random.nextInt(255);
        } while (!checkColor(r, g, b));

        System.out.printf("(r, g, b) = (%d, %d, %d)\n", r, g, b);
        return new Color(r, g, b);
    }

    /**
     * Check if (r, g, b) is valid.
     * Return true if valid,
     * return false if invalid.
     * @param r
     * @param g
     * @param b
     * @return
     */
    private static boolean checkColor(int r, int g, int b) {
        int bright = 210;
        int dark = 200;
        int gray = 30;

        // make the color bright
        if(r < bright && g < bright && g < bright) return false;

        // make the color dark
        if(r > dark && g > dark && b > dark) return false;

        // make the color less gray
        if(Math.abs(r - g) < gray && Math.abs(g - b) < gray && Math.abs(b - r) < gray) return false;

        return true;
    }
}
