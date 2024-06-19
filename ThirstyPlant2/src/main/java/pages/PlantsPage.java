package pages;

import objects.Plant;
import objects.Species;
import pageelements.PlantPanel;
import styles.Styles;
import utils.Reader;

import javax.swing.*;
import java.util.ArrayList;

public class PlantsPage extends JPanel {
    private static final String PLANTS_FILE = "src/main/resources/plants.txt";

    public PlantsPage() {
        setBackground(Styles.BG_COLOUR);
        for (Plant plant : createPlants(PLANTS_FILE)){
            PlantPanel plantPanel = new PlantPanel(plant);
            add(plantPanel);
        }
    }

    public static ArrayList<Plant> createPlants(String file){
        ArrayList<String> records = Reader.readLines(file);
        ArrayList<Plant> plants = new ArrayList<>();
        for (String record : records){
            plants.add(createPlant(record));
        }
        return plants;
    }

    public static Plant createPlant(String record){
        String[] fields = record.split(",");
        String name = fields[0];
        Species species = Species.getSpecies(fields[1]);
        return new Plant(name,species);
    }
}
