package com.iustu.avatar.util;

import java.util.Random;

public class DataGenerator {

    /**
     * generate data at random for drawing avatar
     * the element of generated data is 0 or 1
     * @param length the number of both rows and columns of data
     * @return
     */
    public static int[][] generateData(int length) {
        int halfSquare = (length / 2) * length;
        // control the amount of filled cells of the avatar
        int min = (int) Math.floor(0.3 * halfSquare);
        int max = (int) Math.ceil(0.8 * halfSquare);
        int count = 0;
        int[][] data = new int[length][length];
        Random random = new Random();

        do {
            count = 0;
            for (int i = 0; i < (length + 1) / 2; i++) {
                for (int j = 0; j < length; j++) {
                    count += data[i][j] = data[length - 1 - i][j] = Math.abs(random.nextInt()) % 2;
                }
            }
        } while (count < min || count > max);

        return data;
    }
}
