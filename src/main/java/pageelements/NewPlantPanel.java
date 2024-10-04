package pageelements;

import app.App;
import builders.CurvedButtonBuilder;
import builders.JLabelBuilder;
import objects.Plant;
import objects.Species;
import styles.Styles;
import utils.PerenualRequests;
import utils.SpeciesReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPlantPanel extends CurvedPanel {
    private int panelWidth = 0;
    private int panelHeight = 0;
    private int panelArc = 0;
    JLabel panelLabel;
    JLabel nameLabel;
    JTextField nameField;
    JLabel speciesLabel;
    SpeciesMenu speciesMenu;
    CurvedButton submitButton;

    public NewPlantPanel() {
        setBg(Styles.LIGHT_GREEN);
        setLayout(null);

        panelLabel = new JLabelBuilder()
                .setText("New Plant")
                .setX(38)
                .setY(11)
                .setWidth(130)
                .setHeight(32)
                .setVisible(false)
                .build();
        add(panelLabel);

        nameLabel = new JLabelBuilder()
                .setText("Name")
                .setFontSize(16)
                .setX(241)
                .setY(53)
                .setWidth(41)
                .setHeight(22)
                .setVisible(false)
                .build();
        add(nameLabel);

        nameField = new JTextField();
        nameField.setSize(166,25);
        nameField.setLocation(290,52);
        nameField.setBorder(null);
        nameField.setVisible(false);
        add(nameField);

        speciesLabel = new JLabelBuilder()
                .setText("Species")
                .setFontSize(16)
                .setX(471)
                .setY(52)
                .setWidth(72)
                .setHeight(22)
                .setVisible(false)
                .build();
        add(speciesLabel);

        speciesMenu = new SpeciesMenu();
        speciesMenu.setSize(166,25);
        speciesMenu.setLocation(551,52);
        speciesMenu.setVisible(false);
        add(speciesMenu);

        submitButton = new CurvedButtonBuilder()
                .setText("Plant")
                .setX(750)
                .setY(41)
                .setWidth(133)
                .setHeight(45)
                .setArc(10)
                .setBackgroundColour(Styles.DARK_GREEN)
                .setTextColour(Styles.TEXT_WHITE)
                .build();
        submitButton.setVisible(false);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newPlantName = nameField.getText();
                String newPlantSpeciesName = speciesMenu.textField.getText();
                Species newPlantSpecies = PerenualRequests.getAllSpecies(newPlantSpeciesName).getFirst();

                if (!SpeciesReader.hasSpecies(newPlantSpeciesName)){
                    newPlantSpecies.write();
                }

                Plant newPlant = new Plant(newPlantName,newPlantSpecies);
                newPlant.write();
                App.getInstance().plantsPage.showPlants();
            }
        });
        add(submitButton);
    }

    public void setPanelWidth(int panelWidth) {
        this.panelWidth = panelWidth;
        setPreferredSize(new Dimension(panelWidth, panelHeight));
    }

    public void setPanelHeight(int panelHeight) {
        this.panelHeight = panelHeight;
        setPreferredSize(new Dimension(panelWidth, panelHeight));
    }

    public void setPanelArc(int panelArc) {
        this.panelArc = panelArc;
    }

    public void showContent(){
        panelLabel.setVisible(true);
        nameLabel.setVisible(true);
        nameField.setVisible(true);
        speciesLabel.setVisible(true);
        speciesMenu.setVisible(true);
        submitButton.setVisible(true);

        revalidate();
        repaint();
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.fillRoundRect(0, 0, panelWidth, panelHeight, panelArc, panelArc);
    }
}
