import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class PlantPanelBuilder {
    private final int PANEL_WIDTH = 955;
    private final int PANEL_HEIGHT = 126;
    private final int ARC = 37;
    private final float FONT_SIZE = 17f;
    private String name;
    private LocalDate lastWater;
    private int nextWater;
    ImageIcon pottedPlant = new ImageIcon();

    public PlantPanelBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PlantPanelBuilder setLastWater(LocalDate lastWater){
        this.lastWater = lastWater;
        return this;
    }

    public PlantPanelBuilder setNextWater(int nextWater) {
        this.nextWater = nextWater;
        return this;
    }

    public PlantPanelBuilder setPottedPlant(ImageIcon pottedPlant) {
        this.pottedPlant = pottedPlant;
        return this;
    }

    public CurvedPanel build(){
        CurvedPanel plantPanel =  new CurvedPanelBuilder()
                .setBackgroundColor(App.FG_COLOUR)
                .setWidth(PANEL_WIDTH)
                .setHeight(PANEL_HEIGHT)
                .setArc(ARC)
                .build();

        plantPanel.setLayout(new BoxLayout(plantPanel,BoxLayout.X_AXIS));

        Image pottedPlantImage = pottedPlant.getImage();
        Image newPottedPlantImage = pottedPlantImage.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
        pottedPlant = new ImageIcon(newPottedPlantImage);
        JLabel pottedPlantLabel = new JLabel(pottedPlant);
        plantPanel.add(pottedPlantLabel);

        JLabel nameLabel = new JLabelBuilder()
                .setFont(App.JETBRAINS_MONO.deriveFont(FONT_SIZE))
                .setText("<html>" + String.format("%s hasn't been watered since %s.",name,lastWater) + "<br>" + String.format("%s should be watered in %d days.",name,nextWater) + "</html>")
                .setTextColour(App.TEXT_COLOUR)
                .build();
        plantPanel.add(nameLabel);

        return plantPanel;
    }
}
