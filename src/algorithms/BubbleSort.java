package algorithms;

import javax.swing.*;

public class BubbleSort extends BaseSort{
    public BubbleSort() {
        JLabel title = new JLabel("Bubble sort");
        add(title);

        // Start sorting button
        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> {
            if (sortingWorker == null || sortingWorker.isDone()) {
                sortingWorker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() {
                        sort(getArray());
                        return null;
                    }

                    @Override
                    protected void done() {
                        repaint();
                    }
                };
                sortingWorker.execute();
            }
        });

        add(startButton);

        // Reset button
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            resetSorting();
            repaint();
        });

        add(resetButton);
    }

    private void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    currentIndex = j + 1;
                    repaint();
                    try {
                        Thread.sleep(5);  // Delay for visualization
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        }
    }
}
