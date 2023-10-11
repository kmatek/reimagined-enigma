package algorithms;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public abstract class BaseSort extends JPanel{
    private int[] array = generateRandomArray();
    private static final int ARRAY_SIZE = 100;
    protected int currentIndex;
    protected SwingWorker<Void, Void> sortingWorker;
    private CustomFrame frame;

    public BaseSort() {
        // Reset button
        JButton goBackButton = new JButton("Go back");
        goBackButton.addActionListener(e -> {
            resetSorting();
            repaint();
            frame.showPanel("start");
        });
        add(goBackButton);
    }

    public int[] generateRandomArray() {
        Random random = new Random();
        int[] array = new int[ARRAY_SIZE];

        for (int i = 0; i < array.length; i++) {
            int value = random.nextInt(10,500);
            array[i] = value;
        }

        return array;
    }

    private void cancelWorker() {
        if (sortingWorker != null) {
            sortingWorker.cancel(true);
        }
    }

    protected void resetSorting() {
        cancelWorker();
        setArray(generateRandomArray());
        currentIndex = 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int barWidth = getWidth() / ARRAY_SIZE;

        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (i == currentIndex) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.BLUE);
            }
            g.fillRect(i * barWidth, getHeight() - array[i], barWidth, array[i]);
        }
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void setCustomFrame(CustomFrame frame) {
        this.frame = frame;
    }
}
