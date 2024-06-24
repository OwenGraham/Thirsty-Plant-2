package pageelements;

import javax.swing.*;
import java.awt.*;

public class CurvedButton extends JButton {
    private Color bg;
    private int width;
    private int height;
    private int arc;

//    public CurvedButton(Color bg, int width, int height, int arc) {
//        this.bg = bg;
//        this.width = width;
//        this.height = height;
//        this.arc = arc;
//    }

    public void setBg(Color bg) {
        this.bg = bg;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setArc(int arc) {
        this.arc = arc;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(bg);

        g.fillRoundRect(0, 0, width, height, arc, arc);
    }
}
