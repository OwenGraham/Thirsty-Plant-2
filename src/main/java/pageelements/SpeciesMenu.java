package pageelements;

import objects.Species;
import utils.PerenualRequests;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class SpeciesMenu extends JMenuBar {
    private Timer timer;
    JTextField textField;

    public SpeciesMenu() {
        textField = new JTextField();
        textField.setBorder(null);

        JPopupMenu suggestionsPopup = new JPopupMenu();

        // Delay time in milliseconds (1000 ms = 1 second)
        int delay = 500;

        // Create a Timer
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                if (!input.isEmpty()) {
                    List<Species> speciesData = PerenualRequests.getAllSpecies(input);
                    suggestionsPopup.removeAll();
                    for (Species species : speciesData) {
                        JMenuItem speciesItem = new JMenuItem(species.getName());
                        speciesItem.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                textField.setText(species.getName());
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
    }
}
