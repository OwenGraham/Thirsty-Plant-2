package builders;

import pageelements.CurvedButton;
import styles.Styles;

import javax.swing.*;
import java.awt.*;

public class CurvedButtonBuilder {
    private Color backgroundColor;
    private Color textColour = Styles.TEXT_BLACK;
    private int x;
    private int y;
    private int width;
    private int height;
    private int arc = 0;
    private String text;
    private static final Cursor HAND = new Cursor(Cursor.HAND_CURSOR);

    public CurvedButtonBuilder setBackgroundColour(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public CurvedButtonBuilder setTextColour(Color textColour) {
        this.textColour = textColour;
        return this;
    }

    public CurvedButtonBuilder setX(int x) {
        this.x = x;
        return this;
    }

    public CurvedButtonBuilder setY(int y) {
        this.y = y;
        return this;
    }

    public CurvedButtonBuilder setWidth(int width) {
        this.width = width;
        return this;
    }

    public CurvedButtonBuilder setHeight(int height) {
        this.height = height;
        return this;
    }

    public CurvedButtonBuilder setArc(int arc) {
        this.arc = arc;
        return this;
    }

    public CurvedButtonBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public CurvedButton build() {
        CurvedButton button = new CurvedButton();
        button.setBg(backgroundColor);
        button.setSize(width,height);
        button.setLocation(x,y);
        button.setWidth(width);
        button.setHeight(height);
        button.setArc(arc);
        button.setPreferredSize(new Dimension(width,height));
        button.setBorder(null);
        button.setLayout(new GridBagLayout());
        button.setCursor(HAND);

        JLabel label = new JLabelBuilder()
                .setText(text)
                .setFont(Styles.JETBRAINS_MONO)
                .setTextColour(textColour)
                .build();
        button.add(label, new GridBagConstraints());

        return button;
    }
}
