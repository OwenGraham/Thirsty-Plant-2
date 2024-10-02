package pages;

import objects.Plant;
import pageelements.PlantPanel;
import paths.Paths;
import styles.Styles;
import utils.PlantReader;

import javax.swing.*;

public class PlantsPage extends JPanel {
    public PlantsPage() {
        setBackground(Styles.BG_COLOUR);
        showPlants();
    }

    public void showPlants(){
        removeAll();
        for (Plant plant : PlantReader.readAllPlants(Paths.PLANTS)){
            PlantPanel plantPanel = new PlantPanel(plant);
            add(plantPanel);
        }
        revalidate();
        repaint();
    }
}
