import builders.JPanelBuilder;
import pageelements.NavBar;
import pageelements.NewPlantBar;
import pages.PlantsPage;
import pages.ThirstyPlantWindow;
import styles.Styles;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class App {
    private static final int WINDOW_WIDTH = 1000;
    private static final int WINDOW_HEIGHT = 600;

    public static void main(String[] args) {
        //Making the window of rhe app
        ThirstyPlantWindow appWindow = new ThirstyPlantWindow("Thirsty objects.Plant");

        //Making a container for all the elements of the app
        JPanel container = new JPanelBuilder()
                .setBackgroundColor(Styles.BG_COLOUR)
                .setPreferredSize(WINDOW_WIDTH,WINDOW_HEIGHT)
                .setLayoutManager(new BorderLayout())
                .build();
        appWindow.getContentPane().add(container);

        NavBar navbar = new NavBar();
        container.add(navbar, BorderLayout.NORTH);

        PlantsPage plantsPage = new PlantsPage();
        container.add(plantsPage);

        NewPlantBar newPlantBar = new NewPlantBar();
        container.add(newPlantBar,BorderLayout.SOUTH);

        appWindow.setVisible(true);
    }
}
