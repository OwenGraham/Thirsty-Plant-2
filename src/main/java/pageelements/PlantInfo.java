package pageelements;

import objects.Plant;
import styles.Styles;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class PlantInfo extends JLabel {
    private final float FONT_SIZE = 17f;
    private Plant plant;
    private String name;
    private LocalDate lastWater;
    private int nextWater;

    public PlantInfo(Plant plant) {
        setFont(Styles.JETBRAINS_MONO.deriveFont(FONT_SIZE));
        setForeground(Styles.TEXT_BLACK);

        this.plant = plant;
        name = plant.getName();
        lastWater = plant.getLastWater();
        nextWater = plant.getNextWater();
        setText("<html>" + String.format("%s hasn't been watered since %s.",name,lastWater) + "<br>" + String.format("%s should be watered in %d days.",name,nextWater) + "</html>");
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        lastWater = plant.getLastWater();
        nextWater = plant.getNextWater();
        this.setText("<html>" + String.format("%s hasn't been watered since %s.",name,lastWater) + "<br>" + String.format("%s should be watered in %d days.",name,nextWater) + "</html>");
    }
}
