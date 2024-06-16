import javax.swing.*;
import java.awt.*;

public class NavBarBuilder {
    private static final int HEIGHT = 56;
    private static final int WIDTH = 980;

    public static JPanel getNavBar(){
        JPanel navbar = new JPanelBuilder()
                .setPreferredSize(WIDTH,HEIGHT)
                .setBackgroundColor(App.BG_COLOUR)
                .setLayoutManager(new FlowLayout(FlowLayout.LEFT))
                .build();


        CurvedButton plantsButton = new CurvedButtonBuilder()
                .setText("Plants")
                .setWidth(131)
                .setHeight(40)
                .setArc(9)
                .setBackgroundColour(App.FG_COLOUR)
                .setTextColour(App.TEXT_COLOUR)
                .build();
        navbar.add(plantsButton);

        CurvedButton speciesButton = new CurvedButtonBuilder()
                .setText("Species")
                .setWidth(131)
                .setHeight(40)
                .setArc(9)
                .setBackgroundColour(App.FG_COLOUR)
                .setTextColour(App.TEXT_COLOUR)
                .build();
        navbar.add(speciesButton);

        return navbar;
    }
}
