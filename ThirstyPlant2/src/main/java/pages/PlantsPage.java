package pages;

import objects.Plant;
import pageelements.PlantPanel;
import styles.Styles;
import utils.PlantReader;

import javax.swing.*;

public class PlantsPage extends JPanel {
    private static final String PLANTS_FILE = "src/main/resources/plants.txt";

    public PlantsPage() {
        setBackground(Styles.BG_COLOUR);
        showPlants();
    }

    public void showPlants(){
        removeAll();
        for (Plant plant : PlantReader.readAllPlants(PLANTS_FILE)){
            PlantPanel plantPanel = new PlantPanel(plant);
            add(plantPanel);
        }
        revalidate();
        repaint();
    }
}
