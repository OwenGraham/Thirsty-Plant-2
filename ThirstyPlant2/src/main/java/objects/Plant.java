package objects;

import utils.Reader;
import utils.Writer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Plant {
    private String name;
    private final String WATERS_FILE = "src/main/resources/waters.txt";
    private final String PLANTS_FILE = "src/main/resources/plants.txt";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Species species;
    private LocalDate lastWater = LocalDate.MIN;

    private int daysSinceWater = getDaysSinceWater();
    private Health health;

    public Plant(String name, Species species) {
        this.name = name;
        this.species = species;
    }

    public String getSpeciesName() {
        return species.getName();
    }

    public String getName() {
        return name;
    }

    public LocalDate getLastWater(){
        ArrayList<String> records = Reader.readLines(WATERS_FILE);
        LocalDate date = LocalDate.MIN;
        for (String record : records){
            String[] fields = record.split(",");
            String plantName = fields[0];
            date = LocalDate.parse(fields[1],formatter);
            Water water = new Water(plantName, date);
            if (water.getPlant().equals(name)){
                lastWater = water.getDate();
            }
        }
        return lastWater;
    }

    public int getDaysSinceWater(){
        LocalDate now = LocalDate.now();
        return (int) ChronoUnit.DAYS.between(getLastWater(),now);
    }

    public int getNextWater(){
        return species.getWaterPeriod() - getDaysSinceWater();
    }

    public Health getHealth(){
        float healthFloat = getNextWater() / (float) species.getWaterPeriod();

        if (healthFloat > 0.5) health = Health.BAD;
        else if (healthFloat > 0.25) health = Health.NORMAL;
        else health = Health.GOOD;

        return health;
    }

    public void write(){
        Writer.write(PLANTS_FILE,name + "," + species);
    }
}
