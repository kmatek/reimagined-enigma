import algorithms.CustomFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CustomFrame frame = new CustomFrame();

            frame.showPanel("start");
            frame.setVisible(true);
        });
    }
}
