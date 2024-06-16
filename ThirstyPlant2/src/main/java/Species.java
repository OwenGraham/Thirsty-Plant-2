import java.util.ArrayList;

public class Species {
    private String name;
    private int waterPeriod;
    private static final String SPECIES_FILE = "src/main/resources/species.txt";

    public Species(String name, int waterPeriod) {
        this.name = name;
        this.waterPeriod = waterPeriod;
    }

    public String getName() {
        return name;
    }

    public int getWaterPeriod() {
        return waterPeriod;
    }

    public static Species getSpecies(String speciesName){
        ArrayList<String> records = Reader.readLines(SPECIES_FILE);
        Species species = null;
        for (String record : records){
            String[] fields = record.split(",");
            String name = fields[0];
            int waterPeriod = Integer.parseInt(fields[1]);
            if (speciesName.equals(name)) {
                species = new Species(name,waterPeriod);
            }
        }
        return species;
    }
}
