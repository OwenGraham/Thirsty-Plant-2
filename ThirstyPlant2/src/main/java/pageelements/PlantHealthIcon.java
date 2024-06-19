package pageelements;

import objects.Plant;

import javax.swing.*;
import java.awt.*;

public class PlantHealthIcon extends JLabel {
    private Plant plant;
    private ImageIcon plantImageIcon;

    private static final String PLANTS_FILE = "src/main/resources/plants.txt";
    private static final String HEALTHY_PLANT_ICON = "src/main/resources/icons/good plant.png";
    private static final String UNHEALTHY_PLANT_ICON = "src/main/resources/icons/bad plant.png";

    private static final int WIDTH = 83;
    private static final int HEIGHT = 108;

    public PlantHealthIcon(Plant plant) {
        this.plant = plant;
        plantImageIcon = pickPlantIcon();
        Image plantImage = plantImageIcon.getImage().getScaledInstance(WIDTH,HEIGHT,Image.SCALE_SMOOTH);
        plantImageIcon = new ImageIcon(plantImage);
        this.setIcon(plantImageIcon);
    }

    public ImageIcon pickPlantIcon(){
        ImageIcon icon = new ImageIcon();
        switch (plant.getHealth()){
            case BAD -> icon = new ImageIcon(HEALTHY_PLANT_ICON);
            case NORMAL -> icon = new ImageIcon(UNHEALTHY_PLANT_ICON);
            case GOOD -> icon = new ImageIcon(UNHEALTHY_PLANT_ICON);
        }
        return icon;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        plantImageIcon = pickPlantIcon();
        this.setIcon(new ImageIcon(plantImageIcon.getImage().getScaledInstance(WIDTH,HEIGHT,Image.SCALE_SMOOTH)));
    }
}
