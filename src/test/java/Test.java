import com.iustu.avatar.Avatar;
import com.iustu.avatar.AvatarConfig;

import java.awt.*;

public class Test {

    public static void main(String[] args) {
        AvatarConfig config = new AvatarConfig();
        Avatar avatar = new Avatar(config);
        int start = 0;
        int len = 10;
        for (int i = start; i < start + len; i++) {
            avatar.generateNewAvatarImage().saveAvatarAt("E:\\图片\\头像\\test\\github" + i + ".jpg");
        }
    }
}
