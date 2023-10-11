package algorithms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomFrame extends JFrame {
    private final CardLayout cardLayout = new CardLayout();
    private final JPanel cardPanel = new JPanel(cardLayout);
    private final JComboBox<Algorithm> algorithmsComboBox = new JComboBox<>(Algorithm.values());

    public CustomFrame() {
        super("Sorting Algorithms Visualization");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        add(cardPanel);

        // Add algorithm panels
        for (Algorithm value : Algorithm.values()) {
            value.getSortClass().setCustomFrame(this); // Set frame for back button feature
            addPanel(value.getPanelName(), value.getPanel());
        }

        // Algorithms selection
        algorithmsComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Algorithm algorithm = (Algorithm) algorithmsComboBox.getSelectedItem();
                showPanel(algorithm.getPanelName());
            }
        });

        // Start app panel
        JPanel startPanel = new JPanel();
        startPanel.add(new JLabel("Choose algorithm:"));
        startPanel.add(algorithmsComboBox);

        // Add start app panel
        addPanel("start", startPanel);
    }

    public void addPanel(String panelName, JPanel panel) {
        cardPanel.add(panel, panelName);
    }

    public void showPanel(String panelName) {
        cardLayout.show(cardPanel, panelName);
    }
}
