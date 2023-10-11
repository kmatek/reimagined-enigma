import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CustomFrame frame = new CustomFrame();
            frame.setVisible(true);
        });
    }
}
