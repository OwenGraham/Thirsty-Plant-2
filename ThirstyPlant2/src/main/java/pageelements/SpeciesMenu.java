package pageelements;

import objects.Species;
import utils.SpeciesReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SpeciesMenu extends JMenuBar {
    private static final String SPECIES_FILE = "src/main/resources/species.txt";
    public SpeciesMenu() {
        JMenu selectSpecies = new JMenu("Select species");

        ArrayList<Species> speciesList = SpeciesReader.readAllSpecies(SPECIES_FILE);
        for (Species species : speciesList){
            JMenuItem speciesItem = new JMenuItem(species.getName());
            speciesItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    selectSpecies.setText(species.getName());
                }
            });
            selectSpecies.add(speciesItem);
        }

        add(selectSpecies);
    }
}
