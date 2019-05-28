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
        int min = 20;
        int max = 240;
        return !((r < min && g < min && b < min) || (r > max && g > max && b > max));
    }
}
