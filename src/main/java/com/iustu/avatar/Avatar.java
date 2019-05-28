package com.iustu.avatar;

import com.iustu.avatar.exception.AvatarException;
import com.iustu.avatar.util.DataGenerator;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
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
     * create new avatar image according to configuration at random
     * and then write image to specified position
     * @param filepath position where to store the avatar
     * @return
     */
    public void createPNGAvatarAt(String filepath) {
        generateAvatar();
        // write image
        try {
            ImageIO.write(avatarImage, "png", new File(filepath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * generate avatar at random
     */
    private void generateAvatar() {
        if(avatarConfig == null) throw new AvatarException("avatar hasn't been configured yet!");

        int cellCount = avatarConfig.getCellCount();
        int padding = avatarConfig.getPadding();
        int cellLength = avatarConfig.getCellLength();
        int avatarLength = 2 * padding + cellCount * cellLength;
        int[][] data = DataGenerator.generateData(cellCount);

        avatarImage = new BufferedImage(avatarLength, avatarLength, BufferedImage.TYPE_INT_BGR);
        Graphics2D g = avatarImage.createGraphics();

        // draw background
        g.setColor(avatarConfig.getBackColor());
        g.fillRect(0, 0, avatarLength, avatarLength);

        // draw cells according to data
        g.setColor(avatarConfig.getForeColor());
        for (int i = 0; i < cellCount; i++) {
            for (int j = 0; j < cellCount; j++) {
                if (data[i][j] == 0) continue;
                g.fillRect(padding + i * cellLength, padding + j * cellLength, cellLength, cellLength);
            }
        }

        g.dispose();
    }

}
