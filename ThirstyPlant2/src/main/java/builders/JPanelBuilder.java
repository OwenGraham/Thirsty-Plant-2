package builders;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;

public class JPanelBuilder {
    private Color backgroundColor = Color.WHITE;
    private Dimension preferredSize;
    private LayoutManager layoutManager;

    public JPanelBuilder setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public JPanelBuilder setPreferredSize(int width, int height) {
        this.preferredSize = new Dimension(width, height);
        return this;
    }

    public JPanelBuilder setLayoutManager(LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
        return this;
    }

    public JPanel build() {
        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor);

        if (preferredSize != null) {
            panel.setPreferredSize(preferredSize);
        }

        if (layoutManager != null) {
            panel.setLayout(layoutManager);
        }

        return panel;
    }
}
