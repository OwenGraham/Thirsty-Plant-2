import javax.swing.*;

public class NewPlantBarBuilder {
    private static final int HEIGHT = 65;
    private static final int WIDTH = 980;
    private static final int BUTTON_WIDTH = 207;
    private static final int BUTTON_HEIGHT = 53;
    private static final int BUTTON_ARC = 11;

    public static JPanel build(){
        JPanel newPlantBar = new JPanelBuilder()
                .setBackgroundColor(App.BG_COLOUR)
                .setPreferredSize(WIDTH,HEIGHT)
                .build();

        CurvedButton newPlantButton = new CurvedButtonBuilder()
                .setBackgroundColour(App.FG_COLOUR)
                .setWidth(BUTTON_WIDTH)
                .setHeight(BUTTON_HEIGHT)
                .setArc(BUTTON_ARC)
                .setText("New Plant")
                .build();
        newPlantBar.add(newPlantButton);

        return newPlantBar;
    }
}
