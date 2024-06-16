import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class CurvedPanel extends JPanel {
    private Color bg;
    private int width;
    private int height;
    private int arc;

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
