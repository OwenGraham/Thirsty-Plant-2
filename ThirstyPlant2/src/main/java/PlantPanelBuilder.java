import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class PlantPanelBuilder {
    private final int PANEL_WIDTH = 955;
    private final int PANEL_HEIGHT = 126;
    private final int ARC = 37;
    private final float FONT_SIZE = 17f;

    private static final String WATERING_ICON_FILE = "src/main/resources/icons/watering-plants.png";

    private Plant plant;
    private String name;
    private LocalDate lastWater;
    private int nextWater;

    public PlantPanelBuilder(Plant plant) {
        this.plant = plant;
    }

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

    public CurvedPanel build(){
        CurvedPanel plantPanel =  new CurvedPanelBuilder()
                .setBackgroundColor(App.FG_COLOUR)
                .setWidth(PANEL_WIDTH)
                .setHeight(PANEL_HEIGHT)
                .setArc(ARC)
                .build();

        plantPanel.setLayout(new BoxLayout(plantPanel,BoxLayout.X_AXIS));

        PlantHealthIcon pottedPlantLabel = new PlantHealthIcon(plant);
        plantPanel.add(pottedPlantLabel);

        PlantInfo plantInfo = new PlantInfo(plant);
        plantPanel.add(plantInfo);

        ImageIcon wateringCan = new ImageIcon(WATERING_ICON_FILE);
        Image image = wateringCan.getImage();
        Image newimg = image.getScaledInstance(85, 89, java.awt.Image.SCALE_SMOOTH);
        wateringCan = new ImageIcon(newimg);
        JButton water = new JButton(wateringCan);
        water.setBackground(App.FG_COLOUR);
        water.setBorder(null);
        water.setCursor(new Cursor(Cursor.HAND_CURSOR));
        water.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Water water = new Water(name,LocalDate.now());
                water.write();
                plantInfo.repaint();
                pottedPlantLabel.repaint();
            }
        });
        plantPanel.add(water);

        return plantPanel;
    }
}
