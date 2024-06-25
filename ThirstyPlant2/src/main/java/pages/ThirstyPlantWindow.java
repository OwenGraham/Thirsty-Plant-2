package pages;

import javax.swing.*;
import java.awt.*;

public class ThirstyPlantWindow extends JFrame {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 600;

    public ThirstyPlantWindow(String title) throws HeadlessException {
        super(title);
        setSize(new Dimension(WIDTH,HEIGHT));
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
