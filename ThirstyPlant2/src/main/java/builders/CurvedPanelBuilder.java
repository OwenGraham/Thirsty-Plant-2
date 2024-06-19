package builders;

import pageelements.CurvedPanel;

import java.awt.*;

public class CurvedPanelBuilder {
    private Color backgroundColor;
    private int x = 0;
    private int y = 0;
    private int width;
    private int height;
    private int arc = 0;
    private LayoutManager layoutManager;

    public CurvedPanelBuilder setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public CurvedPanelBuilder setX(int x) {
        this.x = x;
        return this;
    }

    public CurvedPanelBuilder setY(int y) {
        this.y = y;
        return this;
    }

    public CurvedPanelBuilder setWidth(int width) {
        this.width = width;
        return this;
    }

    public CurvedPanelBuilder setHeight(int height) {
        this.height = height;
        return this;
    }

    public CurvedPanelBuilder setArc(int arc) {
        this.arc = arc;
        return this;
    }

    public CurvedPanelBuilder setLayoutManager(LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
        return this;
    }

    public CurvedPanel build(){
        CurvedPanel panel = new CurvedPanel();
        panel.setBg(backgroundColor);
        panel.setWidth(width);
        panel.setHeight(height);
        panel.setArc(arc);
        panel.setPreferredSize(new Dimension(width,height));
        panel.setLocation(x,y);

        if (layoutManager != null) {
            panel.setLayout(layoutManager);
        }

        return panel;
    }
}

