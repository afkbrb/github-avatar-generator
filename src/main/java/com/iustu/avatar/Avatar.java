package com.iustu.avatar;

import com.iustu.avatar.exception.AvatarException;
import com.iustu.avatar.util.DataGenerator;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Avatar {

    /**
     * configuration for avatar
     */
    private AvatarConfig avatarConfig;
    /**
     * actual avatar image
     */
    private BufferedImage avatarImage;

    public Avatar(AvatarConfig avatarConfig) {
        this.avatarConfig = avatarConfig;
    }

    /**
     * generate new image according to the configuration at random
     *
     * @return the caller itself
     */
    public Avatar generateNewAvatarImage() {

        int cellCount = avatarConfig.getCellCount();
        int padding = avatarConfig.getPadding();
        int cellLength = avatarConfig.getCellLength();
        int avatarLength = 2 * padding + cellCount * cellLength;
        int[][] data = DataGenerator.generateData(cellCount);

        avatarImage = new BufferedImage(avatarLength, avatarLength, BufferedImage.TYPE_INT_BGR);
        Graphics2D g = avatarImage.createGraphics();
        g.setColor(avatarConfig.getBackColor());
        // draw background
        g.fillRect(0, 0, avatarLength, avatarLength);
        g.setColor(avatarConfig.getForeColor());
        // draw cells according to data
        for (int i = 0; i < cellCount; i++) {
            for (int j = 0; j < cellCount; j++) {
                if (data[i][j] == 0) continue;
                g.fillRect(padding + i * cellLength, padding + j * cellLength, cellLength, cellLength);
            }
        }
        g.dispose();

        return this;
    }

    /**
     * save avatar at a specified position
     * @param filepath position where to store the avatar image
     */
    public void saveAvatarAt(String filepath) {
        if (avatarImage == null) throw new AvatarException("avatarImage is null!\navatarImage must be generated before save it in a file");

        BufferedOutputStream bos = null;
        try {
            FileOutputStream fos = new FileOutputStream(filepath);
            bos = new BufferedOutputStream(fos);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
            encoder.encode(avatarImage);
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
