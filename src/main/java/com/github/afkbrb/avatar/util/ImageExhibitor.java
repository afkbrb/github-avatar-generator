package com.github.afkbrb.avatar.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageExhibitor {

    /**
     * Show image with local application.
     * @param image
     */
    public static void showImage(BufferedImage image) {
        try {
            Path path = Files.createTempFile("java-avatar-generator", ".png");
            ImageIO.write(image, "png", path.toFile());
            Desktop.getDesktop().open(path.toFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
