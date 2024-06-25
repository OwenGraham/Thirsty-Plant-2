package pageelements;

import javax.swing.*;

import builders.CurvedButtonBuilder;
import styles.Styles;

import java.awt.*;

public class NavBar extends JPanel {
    private static final int HEIGHT = 50;
    private static final int WIDTH = 980;

    public NavBar() {
        setBackground(Styles.BG_COLOUR);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setLayout(new FlowLayout(FlowLayout.LEFT));

        //Button to navigate to plants page
        CurvedButton plantsButton = new CurvedButtonBuilder()
                .setText("Plants")
                .setWidth(131)
                .setHeight(40)
                .setArc(9)
                .setBackgroundColour(Styles.LIGHT_GREEN)
                .setTextColour(Styles.TEXT_BLACK)
                .build();
        add(plantsButton);

        //Button to navigate to species page
        CurvedButton speciesButton = new CurvedButtonBuilder()
                .setText("Species")
                .setWidth(131)
                .setHeight(40)
                .setArc(9)
                .setBackgroundColour(Styles.LIGHT_GREEN)
                .setTextColour(Styles.TEXT_BLACK)
                .build();
        add(speciesButton);
    }
}
