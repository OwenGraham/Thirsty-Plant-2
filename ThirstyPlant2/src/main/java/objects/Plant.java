package objects;

import paths.Paths;
import utils.PlantReader;
import utils.Reader;
import utils.Writer;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Plant {
    private String name;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Species species;
    private LocalDate lastWater = LocalDate.MIN;
    private Health health;

    public Plant(String name, Species species) {
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public LocalDate getLastWater(){
        ArrayList<String> records = Reader.readLines(Paths.WATERS);
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
        Writer.write(Paths.PLANTS,name + "," + species.getName());
    }

    public void write(String file){
        Writer.write(file,name + "," + species.getName());
    }

    public void delete(){
        for (Plant plant : PlantReader.readAllPlants(Paths.PLANTS)){
            if (!plant.getName().equals(name)){
                plant.write(Paths.TEMP);
            }
        }
        File plantsFile = new File(Paths.PLANTS);
        plantsFile.delete();
        plantsFile = new File(Paths.PLANTS);
        File temp = new File(Paths.TEMP);
        temp.renameTo(plantsFile);
    }
}
