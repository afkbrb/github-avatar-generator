import com.iustu.avatar.Avatar;
import com.iustu.avatar.AvatarConfig;
import com.iustu.avatar.util.ImageExhibitor;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Examples {

    public static void main(String[] args) {
        showExample();

        //saveExample("E:/avatar.png");

        //sizeConfigExample();

        //cellCountConfigExample();

        //transparentConfigExample();

        //singleColorConfigExample();

        //multiColorConfigExample1();

        //multiColorConfigExample2();

    }

    /**
     * Show default avatar.
     */
    public static void showExample() {
        Avatar avatar = new Avatar();
        avatar.showAvatar();
    }

    /**
     * Save avatar.
     * @param filepath where to save the avatar
     */
    public static void saveExample(String filepath) {
        Avatar avatar = new Avatar();
        avatar.saveAsPNG(filepath);
    }

    /**
     * Set padding and cell size.
     */
    public static void sizeConfigExample() {
        AvatarConfig config = new AvatarConfig();
        config.setPadding(16);
        config.setCellSize(32);
        Avatar avatar = new Avatar(config);
        avatar.showAvatar();
    }

    /**
     * Set the number of cells per row / column.
     */
    public static void cellCountConfigExample() {
        AvatarConfig config = new AvatarConfig();
        config.setCellCount(8);
        Avatar avatar = new Avatar(config);
        avatar.showAvatar();
    }

    /**
     * Set the avatar transparent.
     */
    public static void transparentConfigExample() {
        AvatarConfig config = new AvatarConfig();
        config.setTransparent(true);
        Avatar avatar = new Avatar(config);
        avatar.showAvatar();
    }

    /**
     * Set foreground color.
     */
    public static void singleColorConfigExample() {
        AvatarConfig config = new AvatarConfig();
        config.setForeColor(Color.MAGENTA);
        // config.setBackColor(Color.LIGHT_GRAY);
        Avatar avatar = new Avatar(config);
        avatar.showAvatar();
    }

    /**
     * Set foreground colors.
     * Final color will be chosen at random in the given array.
     */
    public static void multiColorConfigExample1() {
        AvatarConfig config = new AvatarConfig();
        config.setForeColors(Color.MAGENTA, Color.BLUE, Color.GREEN);
        Avatar avatar = new Avatar(config);
        multiImageExhibitor(avatar, config.getCellSize(), config.getCellSize(), 6);
    }

    /**
     * Set foreground colors.
     * Final color will be chosen at random in the given list.
     */
    public static void multiColorConfigExample2() {
        AvatarConfig config = new AvatarConfig();
        List<Color> colors = new ArrayList<>();
        colors.add(Color.YELLOW);
        colors.add(Color.ORANGE);
        colors.add(Color.CYAN);
        config.setForeColors(colors);
        Avatar avatar = new Avatar(config);
        multiImageExhibitor(avatar, config.getCellSize(), config.getCellSize(), 6);
    }

    /**
     * Tool for showing multi image together.
     * @param avatar
     * @param width
     * @param height
     * @param n
     */
    public static void multiImageExhibitor(Avatar avatar,int width, int height, int n) {
        BufferedImage image = new BufferedImage(n * width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        for(int i = 0; i < n; i++) {
            g.drawImage(avatar.generateAndGetAvatar(), i * width, 0, width, height, null);
        }

        g.dispose();
        ImageExhibitor.showImage(image);
    }
}
