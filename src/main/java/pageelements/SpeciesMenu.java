package pageelements;

import objects.SpeciesData;
import utils.PerenualRequests;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class SpeciesMenu extends JMenuBar {
    PerenualRequests perenualRequests = new PerenualRequests();
    public JMenu selectSpecies;
    private Timer timer;

    public SpeciesMenu() {
        selectSpecies = new JMenu("Select species");

        JTextField textField = new JTextField();
        JPopupMenu suggestionsPopup = new JPopupMenu();

        // Delay time in milliseconds (1000 ms = 1 second)
        int delay = 1000;

        // Create a Timer
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                System.out.println("Timer triggered. Input: " + input); // Debugging statement
                if (!input.isEmpty()) {
                    List<SpeciesData> speciesData = perenualRequests.getAllSpecies(input);
                    suggestionsPopup.removeAll();
                    System.out.println("Species data size: " + speciesData.size()); // Debugging statement

                    for (SpeciesData species : speciesData) {
                        JMenuItem speciesItem = new JMenuItem(species.getScientificName().getFirst());
                        speciesItem.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                textField.setText(species.getCommonName());
                                selectSpecies.setText(species.getCommonName());
                                suggestionsPopup.setVisible(false);
                            }
                        });
                        suggestionsPopup.add(speciesItem);
                    }

                    if (speciesData.size() > 0) {
                        suggestionsPopup.show(textField, 0, textField.getHeight());
                    } else {
                        suggestionsPopup.setVisible(false);
                    }
                } else {
                    suggestionsPopup.setVisible(false);
                }
            }
        });
        timer.setRepeats(false); // Ensure the timer only runs once per key release

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("Key released. Restarting timer."); // Debugging statement
                timer.restart(); // Restart the timer every time a key is released
            }
        });

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                SwingUtilities.invokeLater(() -> {
                    if (!suggestionsPopup.isShowing()) {
                        textField.requestFocus();
                    }
                });
            }
        });

        add(textField);
        add(selectSpecies);
    }
}
