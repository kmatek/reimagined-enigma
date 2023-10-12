package algorithms;

import javax.swing.*;

public enum Algorithm {
    QUICK("quick", new QuickSort()),
    BUBBLE("bubble", new BubbleSort());

    private final String panelName;
    private final BaseSort panel;

    Algorithm(String panelName, BaseSort panel) {
        this.panelName = panelName;
        this.panel = panel;
    }

    public String getPanelName() {
        return panelName;
    }

    public BaseSort getSortClass() {
        return panel;
    }

    public JPanel getPanel() {
        return (JPanel) panel;
    }
}
