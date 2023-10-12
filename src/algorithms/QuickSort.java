package algorithms;

import javax.swing.*;
import java.time.Instant;

public class QuickSort extends BaseSort{
    public QuickSort() {
        JLabel title = new JLabel("Quick sort");
        add(title);

        // Add action to start button
        getStartButton().addActionListener(e -> {
            // Prevent start again during sorting
            if (isSorting() || isSorted()) {
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
                        quickSort(getArray(), 0, getArray().length - 1);
                        return null;
                    }

                    @Override
                    protected void done() {
                        setSorting(false);
                        setSorted(true);
                        repaint();
                    }
                });
                getSortingWorker().execute();
            }
        });
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                setCurrentIndex(j);
                repaint();
                try {
                    Thread.sleep(getSleepSec());  // Delay for visualization
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        setCurrentIndex(-1);
        repaint();
        try {
            Thread.sleep(getSleepSec());  // Delay for visualization
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return i + 1;
    }
}
