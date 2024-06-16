import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class App {
    public static final Color BG_COLOUR = new Color(171,216,226);
    public static final Color FG_COLOUR = new Color(137,221,130);
    public static final Color TEXT_COLOUR = new Color(0,0,0);
    private static final int WINDOW_WIDTH = 1000;
    private static final int WINDOW_HEIGHT = 600;
    private static final File JETBRAINS_MONO_FILE = new File("src/main/resources/fonts/fonts/ttf/JetBrainsMono-Regular.ttf");
    public static final Font JETBRAINS_MONO;
    static GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();

    static {
        try {
            JETBRAINS_MONO = Font.createFont(Font.TRUETYPE_FONT,JETBRAINS_MONO_FILE).deriveFont(22f);
            genv.registerFont(App.JETBRAINS_MONO);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static void main(String[] args) {
        //Making the window of rhe app
        JFrame appWindow = AppWindowBuilder.getAppWindow();

        //Making a container for all the elements of the app
        JPanel container = new JPanelBuilder()
                .setBackgroundColor(BG_COLOUR)
                .setPreferredSize(WINDOW_WIDTH,WINDOW_HEIGHT)
                .setLayoutManager(new BorderLayout())
                .build();
        appWindow.getContentPane().add(container);

        JPanel navbar = NavBarBuilder.getNavBar();
        container.add(navbar, BorderLayout.NORTH);

        JPanel plantsPage = PlantsPageBuilder
                .build();
        container.add(plantsPage);

        JPanel newPlantBar = NewPlantBarBuilder.build();
        container.add(newPlantBar,BorderLayout.SOUTH);


        appWindow.setVisible(true);
    }
}
