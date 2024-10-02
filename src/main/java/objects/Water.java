package objects;

import paths.Paths;
import utils.Writer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Water {
    private String plant;
    private LocalDate date;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Water(String plant, LocalDate date) {
        this.plant = plant;
        this.date = date;
    }

    public String getPlant() {
        return plant;
    }

    public LocalDate getDate() {
        return date;
    }

    public void write(){
        Writer.write(Paths.WATERS,plant + "," + date.format(formatter));
    }
}
