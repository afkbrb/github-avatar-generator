package com.iustu.avatar;

import com.iustu.avatar.exception.AvatarException;
import com.iustu.avatar.util.DataGenerator;
import com.iustu.avatar.util.ImageExhibitor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Avatar {

    /**
     * Configuration for avatar.
     */
    private AvatarConfig avatarConfig;

    /**
     * Actual avatar image.
     */
    private BufferedImage avatarImage;

    public Avatar() {
        this(new AvatarConfig());
    }

    public Avatar(AvatarConfig avatarConfig) {
        this.avatarConfig = avatarConfig;
        build();
    }

    /**
     * Save avatar image as PNG file.
     * @param filepath where to store the avatar
     * @return
     */
    public void saveAsPNG(String filepath) {
        if(avatarImage == null) build();
        // write image
        try {
            ImageIO.write(avatarImage, "png", new File(filepath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Build the avatar, calling the method will create new avatar
     * image at random according to configuration.
     */
    public void build() {
        if(avatarConfig == null) throw new AvatarException("avatar hasn't been configured yet!");
        avatarImage = generateAndGetAvatar();
    }


    /**
     * Generate new avatar and return it.
     * @return the new generated avatar
     */
    public BufferedImage generateAndGetAvatar() {
        BufferedImage avatarImage;

        int cellCount = avatarConfig.getCellCount();
        int padding = avatarConfig.getPadding();
        int cellSize = avatarConfig.getCellSize();
        int avatarLength = 2 * padding + cellCount * cellSize;
        int[][] data = DataGenerator.generateData(cellCount);

        avatarImage = new BufferedImage(avatarLength, avatarLength, BufferedImage.TYPE_INT_BGR);
        Graphics2D g = avatarImage.createGraphics();

        if(avatarConfig.getTransparent()) {
            // transparent
            avatarImage = g.getDeviceConfiguration().createCompatibleImage(avatarLength, avatarLength, Transparency.TRANSLUCENT);
            g.dispose();
            g = avatarImage.createGraphics();
        }else{
            // if not transparent, draw background
            g.setColor(avatarConfig.getBackColor());
            g.fillRect(0, 0, avatarLength, avatarLength);
        }

        // draw cells according to data
        g.setColor(avatarConfig.getForeColor());
        for (int i = 0; i < cellCount; i++) {
            for (int j = 0; j < cellCount; j++) {
                if (data[i][j] == 0) continue;
                g.fillRect(padding + i * cellSize, padding + j * cellSize, cellSize, cellSize);
            }
        }

        g.dispose();

        return avatarImage;
    }

    /**
     * Show the generated avatar image with local application.
     */
    public void showAvatar() {
        if(avatarImage == null) throw new AvatarException("avatar image has been generated yet!");
        ImageExhibitor.showImage(avatarImage);
    }

}
