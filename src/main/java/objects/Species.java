package objects;

import com.fasterxml.jackson.annotation.JsonSetter;
import paths.Paths;
import utils.Reader;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import utils.Writer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Species {
    @JsonProperty("scientific_name")
    private List<String> names;

    @JsonProperty("watering")
    private String waterPeriodString;

    // An enum for converting the value of the field "watering" given by the Perenual API into a number of days
    private enum WaterPeriod{
        Average(14),
        Frequent(7);

        private final int days;

        WaterPeriod(int days){
            this.days = days;
        }

        public int getDays() {
            return days;
        }
    }

    private String name;
    private int waterPeriod;

    public Species() {

    }

    @JsonSetter("scientific_name")
    public void setNames(List<String> names){
        this.names = names;
        if (names != null && !names.isEmpty()){
            this.name = names.get(0);
        }
    }

    @JsonSetter("watering")
    public void setWaterPeriod(String waterPeriodString){
        this.waterPeriodString = waterPeriodString;
        try {
            this.waterPeriod = WaterPeriod.valueOf(waterPeriodString).getDays();
        } catch (IllegalArgumentException e){
            this.waterPeriod = 7;
        }
    }

    public Species(String name, int waterPeriod) {
        this.name = name;
        this.waterPeriod = waterPeriod;
    }

    public Species(List<String> names, String waterPeriod) {
        this.name = names.getFirst();
        this.waterPeriod = WaterPeriod.valueOf(waterPeriod).getDays();
    }

    public String getName() {
        return name;
    }

    public int getWaterPeriod() {
        return waterPeriod;
    }

    public static Species getSpecies(String speciesName){
        ArrayList<String> records = Reader.readLines(Paths.SPECIES);
        Species species = null;
        for (String record : records){
            String[] fields = record.split(",");
            String name = fields[0];
            int waterPeriod = Integer.parseInt(fields[1]);
            if (speciesName.equals(name)) {
                species = new Species(name, waterPeriod);
            }
        }
        return species;
    }

    public void write(){
        Writer.write(Paths.SPECIES,name + "," + String.valueOf(waterPeriod));
    }
}
