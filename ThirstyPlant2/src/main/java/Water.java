import java.time.LocalDate;

public class Water {
    private String plant;
    private LocalDate date;

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
}
