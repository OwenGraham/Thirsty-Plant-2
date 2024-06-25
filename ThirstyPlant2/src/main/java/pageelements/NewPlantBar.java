package pageelements;

import builders.CurvedButtonBuilder;
import builders.CurvedPanelBuilder;
import styles.Styles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPlantBar extends JPanel {
    private static final int HEIGHT = 65;
    private static final int WIDTH = 980;
    private static final int BUTTON_WIDTH = 207;
    private static final int BUTTON_HEIGHT = 53;
    private static final int BUTTON_ARC = 11;
    private static final int PANEL_WIDTH = 955;
    private static final int PANEL_HEIGHT = 126;
    private static final int PANEL_ARC = 11;

    public NewPlantBar() {
        setSize(new Dimension(WIDTH,HEIGHT));
        setBackground(Styles.BG_COLOUR);

        NewPlantPanel newPlantPanel = new NewPlantPanel();
        add(newPlantPanel);

        CurvedButton newPlantButton = new CurvedButtonBuilder()
                .setBackgroundColour(Styles.LIGHT_GREEN)
                .setWidth(BUTTON_WIDTH)
                .setHeight(BUTTON_HEIGHT)
                .setArc(BUTTON_ARC)
                .setText("New Plant")
                .build();
        newPlantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(newPlantButton);
                newPlantPanel.setVisible(true);

                newPlantPanel.setPanelWidth(PANEL_WIDTH);
                newPlantPanel.setPanelHeight(PANEL_HEIGHT);
                newPlantPanel.setPanelArc(PANEL_ARC);

                newPlantPanel.showContent();

                revalidate();
                repaint();
            }
        });
        add(newPlantButton);
    }
}
