import javax.swing.JFrame;
import java.awt.*;

public class JFrameBuilder {
    private String title = "";
    private int width = 800;
    private int height = 600;
    private boolean resizable = true;
    private int defaultCloseOperation = JFrame.EXIT_ON_CLOSE;
    private Component locationRelativeTo = null;

    public JFrameBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public JFrameBuilder setSize(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }

    public JFrameBuilder setResizable(boolean resizable) {
        this.resizable = resizable;
        return this;
    }

    public JFrameBuilder setDefaultCloseOperation(int operation) {
        this.defaultCloseOperation = operation;
        return this;
    }

    public JFrameBuilder setLocationRelativeTo(Component locationRelativeTo) {
        this.locationRelativeTo = locationRelativeTo;
        return this;
    }

    public JFrame build() {
        JFrame frame = new JFrame(title);
        frame.setSize(new Dimension(width, height));
        frame.setResizable(resizable);
        frame.setDefaultCloseOperation(defaultCloseOperation);
        frame.setLocationRelativeTo(locationRelativeTo);
        return frame;
    }
}
