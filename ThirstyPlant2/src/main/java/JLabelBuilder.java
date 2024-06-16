import javax.swing.*;
import java.awt.*;

public class JLabelBuilder {
    private Color textColour = App.TEXT_COLOUR;
    private Font font = App.JETBRAINS_MONO;
    private int fontSize;
    private String text;

    public JLabelBuilder setTextColour(Color textColour) {
        this.textColour = textColour;
        return this;
    }

    public JLabelBuilder setFont(Font font) {
        this.font = font;
        return this;
    }

    public JLabelBuilder setFontSize(int fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    public JLabelBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public JLabel build(){
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(textColour);
        return label;
    }
}
