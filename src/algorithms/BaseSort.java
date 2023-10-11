package algorithms;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public abstract class BaseSort extends JPanel{
    private int[] array = generateRandomArray();
    private static final int ARRAY_SIZE = 100;
    protected int currentIndex;
    protected Instant start;
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
        start = null;
        currentIndex = 0;
    }

    /*
    Visualize sorting
    */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int barWidth = getWidth() / ARRAY_SIZE;

        // Replace bars
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (i == currentIndex) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.BLUE);
            }
            g.fillRect(i * barWidth, getHeight() - array[i], barWidth, array[i]);
        }

        // Show time performance
        try {
            g.setColor(Color.BLACK);
            Instant current = Instant.now();
            long milis = Duration.between(start, current).toMillis();
            g.drawString("Sorting time: " + milis + " ms", 10, 20);
        } catch (Exception e) {
            g.drawString("Sorting time: " + "0" + " ms", 10, 20);
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
