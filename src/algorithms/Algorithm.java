package algorithms;

import javax.swing.*;

public enum Algorithm {
    QUICK("quick", null);

    private final String panelName;
    private final JPanel panel;

    Algorithm(String panelName, JPanel panel) {
        this.panelName = panelName;
        this.panel = panel;
    }

    public String getPanelName() {
        return panelName;
    }

    public JPanel getPanel() {
        return panel;
    }
}
