package builders;

import styles.Styles;

import javax.swing.*;
import java.awt.*;

public class JLabelBuilder {
    private Color textColour = Styles.TEXT_BLACK;
    private Font font = Styles.JETBRAINS_MONO;
    private int fontSize;
    private String text;
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible = true;

    public JLabelBuilder setTextColour(Color textColour) {
        this.textColour = textColour;
        return this;
    }

    public JLabelBuilder setFont(Font font) {
        this.font = font;
        return this;
    }

    public JLabelBuilder setFontSize(int fontSize) {
        this.font = font.deriveFont((float) fontSize);
        return this;
    }

    public JLabelBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public JLabelBuilder setX(int x) {
        this.x = x;
        return this;
    }

    public JLabelBuilder setY(int y) {
        this.y = y;
        return this;
    }

    public JLabelBuilder setWidth(int width) {
        this.width = width;
        return this;
    }

    public JLabelBuilder setHeight(int height) {
        this.height = height;
        return this;
    }

    public JLabelBuilder setVisible(boolean visible) {
        this.visible = visible;
        return this;
    }

    public JLabel build(){
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(textColour);
        label.setLocation(x,y);
        label.setSize(width,height);
        label.setVisible(visible);
        return label;
    }
}
