package utils;

import objects.Species;

import java.util.ArrayList;

public class SpeciesReader {
    public static ArrayList<Species> readAllSpecies(String file){
        ArrayList<String> records = Reader.readLines(file);
        ArrayList<Species> allSpecies = new ArrayList<>();
        for (String record : records){
            allSpecies.add(readSpecies(record));
        }
        return allSpecies;
    }

    public static Species readSpecies(String record){
        String[] fields = record.split(",");
        String speciesName = fields[0];
        int waterPeriod = Integer.parseInt(fields[1]);
        return new Species(speciesName,waterPeriod);
    }
}
