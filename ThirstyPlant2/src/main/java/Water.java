import utils.Writer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Water {
    private String plant;
    private LocalDate date;
    private static final String WATER_FILE = "src/main/resources/waters.txt";
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
        Writer.write(WATER_FILE,plant + "," + date.format(formatter));
    }
}
