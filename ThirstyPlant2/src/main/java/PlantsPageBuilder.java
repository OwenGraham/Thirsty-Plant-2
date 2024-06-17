import utils.Reader;

import javax.swing.*;
import java.util.ArrayList;

public class PlantsPageBuilder {
    private static final String PLANTS_FILE = "src/main/resources/plants.txt";
    private static final String HEALTHY_PLANT_ICON = "src/main/resources/icons/good plant.png";
    private static final String UNHEALTHY_PLANT_ICON = "src/main/resources/icons/bad plant.png";
    private static ArrayList<Plant> plants = new ArrayList<>();

    public static JPanel build(){
        JPanel page = new JPanelBuilder()
                .setBackgroundColor(App.BG_COLOUR)
                .build();

        plants = createPlants(PLANTS_FILE);
        for (Plant plant : plants){
            CurvedPanel plantPanel = new PlantPanelBuilder(plant)
                    .setName(plant.getName())
                    .setLastWater(plant.getLastWater())
                    .setNextWater(plant.getNextWater())
                    .build();
            page.add(plantPanel);
        }
        return page;
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
