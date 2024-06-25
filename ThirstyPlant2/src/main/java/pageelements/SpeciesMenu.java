package pageelements;

import objects.Species;
import paths.Paths;
import utils.SpeciesReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SpeciesMenu extends JMenuBar {
    public JMenu selectSpecies;
    public SpeciesMenu() {
        selectSpecies = new JMenu("Select species");

        ArrayList<Species> speciesList = SpeciesReader.readAllSpecies(Paths.SPECIES);
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
