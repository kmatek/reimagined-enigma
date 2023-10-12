package algorithms;

import javax.swing.*;
import java.time.Instant;

public class BubbleSort extends BaseSort{
    public BubbleSort() {
        JLabel title = new JLabel("Bubble sort");
        add(title);

        // Add action to start button
        getStartButton().addActionListener(e -> {
            // Prevent start again during sorting
            if (isSorting()) {
                return;
            }

            setStart(Instant.now()); // Start time performance
            setSorting(true);

            // Start worker
            if (getSortingWorker() == null || getSortingWorker().isDone()) {
                setSortingWorker(new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() {
                        // Start sorting
                        sort(getArray());
                        return null;
                    }

                    @Override
                    protected void done() {
                        setSorting(false);
                        repaint();
                    }
                });
                getSortingWorker().execute();
            }
        });
    }

    private void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    setCurrentIndex(j + 1);
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
