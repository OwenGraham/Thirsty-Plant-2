package styles;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Styles {
    //Colours
    public static final Color BG_COLOUR = new Color(171,216,226);
    public static final Color LIGHT_GREEN = new Color(137,221,130);
    public static final Color DARK_GREEN = new Color(121,183,110);
    public static final Color TEXT_BLACK = new Color(0,0,0);
    public static final Color TEXT_WHITE = new Color(255,255,255);

    //Fonts
    static GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
    public static final Font JETBRAINS_MONO;
    static {
        try {
            JETBRAINS_MONO = Font
                    .createFont(Font.TRUETYPE_FONT,
                            new File("src/main/resources/fonts/fonts/ttf/JetBrainsMono-Regular.ttf"))
                    .deriveFont(22f);
            genv.registerFont(JETBRAINS_MONO);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
