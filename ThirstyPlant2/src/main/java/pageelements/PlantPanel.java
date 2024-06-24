package pageelements;

import App.App;
import builders.CurvedButtonBuilder;
import objects.Plant;
import objects.Water;
import styles.Styles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class PlantPanel extends CurvedPanel{
    private final int WIDTH = 955;
    private final int HEIGHT = 126;
    private final int ARC = 37;
    private static final String WATERING_ICON_FILE = "src/main/resources/icons/watering-plants.png";

    public PlantPanel(Plant plant) {
        setBg(Styles.LIGHT_GREEN);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setWidth(WIDTH);
        setHeight(HEIGHT);
        setArc(ARC);
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

        PlantHealthIcon pottedPlantLabel = new PlantHealthIcon(plant);
        add(pottedPlantLabel);

        PlantInfo plantInfo = new PlantInfo(plant);
        add(plantInfo);

        ImageIcon wateringCan = new ImageIcon(WATERING_ICON_FILE);
        Image image = wateringCan.getImage();
        Image newimg = image.getScaledInstance(85, 89, java.awt.Image.SCALE_SMOOTH);
        wateringCan = new ImageIcon(newimg);
        JButton water = new JButton(wateringCan);
        water.setBackground(Styles.LIGHT_GREEN);
        water.setBorder(null);
        water.setCursor(new Cursor(Cursor.HAND_CURSOR));
        water.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Water water = new Water(plant.getName(), LocalDate.now());
                water.write();
                plantInfo.repaint();
                pottedPlantLabel.repaint();
            }
        });
        add(water);

        CurvedButton deleteButton = new CurvedButtonBuilder()
                .setBackgroundColour(Styles.LIGHT_GREEN)
                .setText("X")
                .build();
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plant.delete();
                App.getInstance().plantsPage.showPlants();
            }
        });
        add(deleteButton);
    }
}
