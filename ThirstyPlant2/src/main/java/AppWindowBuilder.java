import javax.swing.*;
import java.awt.*;

public class AppWindowBuilder {
    private static final Color BG_COLOUR = new Color(171,216,226);
    private static final int WINDOW_WIDTH = 1000;
    private static final int WINDOW_HEIGHT = 600;

    public static JFrame getAppWindow(){
        JFrame frame = new JFrameBuilder()
                .setSize(WINDOW_WIDTH,WINDOW_HEIGHT)
                .setTitle("Thirsty Plant")
                .build();

        return frame;
    }
}
