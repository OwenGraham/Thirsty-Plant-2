package pageelements;

import builders.CurvedButtonBuilder;
import builders.CurvedPanelBuilder;
import styles.Styles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewPlantBar extends JPanel {
    private static final int HEIGHT = 65;
    private static final int WIDTH = 980;
    private static final int BUTTON_WIDTH = 207;
    private static final int BUTTON_HEIGHT = 53;
    private static final int BUTTON_ARC = 11;
    private static final int ANIMATION_DELAY = 2;
    private static final int ANIMATION_INCREMENT = 6;
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

        Timer timer = new Timer(ANIMATION_DELAY,null);
        boolean[] growing = {false};

        // Make the button expand to the size of the new plant panel when the mouse hovers over it
        newPlantButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!growing[0]) {
                    growing[0] = true;

                    ActionListener[] listeners = timer.getActionListeners();
                    if (listeners.length > 0) {
                        timer.removeActionListener(listeners[0]);
                    }

                    timer.addActionListener(new ActionListener() {
                        private int currentHeight = newPlantButton.getPreferredSize().height;
                        private int currentWidth = newPlantButton.getPreferredSize().width;

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            boolean hasMoreToGrow = currentHeight < PANEL_HEIGHT || currentWidth < PANEL_WIDTH;

                            if (hasMoreToGrow) {
                                // Increase height and width until they reach target dimensions
                                if (currentHeight < PANEL_HEIGHT) currentHeight += ANIMATION_INCREMENT;
                                if (currentWidth < PANEL_WIDTH) currentWidth += 9 * ANIMATION_INCREMENT;

                                newPlantButton.setPreferredSize(new Dimension(currentWidth, currentHeight));
                                newPlantButton.setHeight(currentHeight);
                                newPlantButton.setWidth(currentWidth);
                                newPlantButton.revalidate();
                                newPlantPanel.revalidate();
                                newPlantButton.repaint();
                            } else {
                                timer.stop();
                            }
                        }
                    });
                    timer.start();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (growing[0]) {
                    growing[0] = false;

                    ActionListener[] listeners = timer.getActionListeners();
                    if (listeners.length > 0) {
                        timer.removeActionListener(listeners[0]);
                    }

                    timer.addActionListener(new ActionListener() {
                        private int currentHeight = newPlantButton.getPreferredSize().height;
                        private int currentWidth = newPlantButton.getPreferredSize().width;

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            boolean hasMoreToShrink = currentHeight > BUTTON_HEIGHT || currentWidth > BUTTON_WIDTH;

                            if (hasMoreToShrink) {
                                // Decrease height and width until they reach original dimensions
                                if (currentHeight > BUTTON_HEIGHT) currentHeight -= ANIMATION_INCREMENT;
                                if (currentWidth > BUTTON_WIDTH) currentWidth -= 9 * ANIMATION_INCREMENT;

                                newPlantButton.setPreferredSize(new Dimension(currentWidth, currentHeight));
                                newPlantButton.revalidate();
                                newPlantPanel.revalidate();
                                newPlantButton.repaint();
                            } else {
                                timer.stop();
                            }
                        }
                    });
                    timer.start();
                }
            }
        });


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
