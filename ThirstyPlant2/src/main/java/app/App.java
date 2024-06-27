package app;

import builders.JPanelBuilder;
import pageelements.NavBar;
import pageelements.NewPlantBar;
import pages.PlantsPage;
import pages.ThirstyPlantWindow;
import styles.Styles;
import utils.PerenualRequests;

import javax.swing.*;
import java.awt.*;
import java.net.http.HttpResponse;

public class App {
    private static final int WINDOW_WIDTH = 1000;
    private static final int WINDOW_HEIGHT = 600;

    private static App instance;

    public static synchronized App getInstance() {
        if (instance == null){
            instance = new App();
        }
        return instance;
    }

    public static PlantsPage plantsPage;

    public App() {
        init();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                App.getInstance();
            }
        });
    }

    private void init(){
        //Making the window of the app
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

        plantsPage = new PlantsPage();
        container.add(plantsPage);

        NewPlantBar newPlantBar = new NewPlantBar();
        container.add(newPlantBar,BorderLayout.SOUTH);

        appWindow.setVisible(true);
    }
}
