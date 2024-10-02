package utils;

import objects.Plant;
import objects.Species;

import java.util.ArrayList;

public class PlantReader {
    public static ArrayList<Plant> readAllPlants(String file){
        ArrayList<String> records = Reader.readLines(file);
        ArrayList<Plant> plants = new ArrayList<>();
        for (String record : records){
            plants.add(readPlant(record));
        }
        return plants;
    }

    public static Plant readPlant(String record){
        String[] fields = record.split(",");
        String name = fields[0];
        Species species = Species.getSpecies(fields[1]);
        return new Plant(name,species);
    }
}
