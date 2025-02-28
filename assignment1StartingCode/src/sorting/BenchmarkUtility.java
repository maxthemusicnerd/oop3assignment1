package sorting;

import java.util.Comparator;

/**
 * The {@code BenchmarkUtility} class provides a method to benchmark the performance of different sorting algorithms.
 * <p>
 * It measures the time taken by a sorting algorithm to sort an array using the {@code System.nanoTime()} method.
 * The supported sorting algorithms include:
 * <ul>
 *     <li>Bubble Sort ("bubble")</li>
 *     <li>Selection Sort ("selection")</li>
 *     <li>Insertion Sort ("insertion")</li>
 *     <li>Merge Sort ("merge")</li>
 *     <li>Quick Sort ("quick")</li>
 *     <li>Heap Sort ("heap")</li>
 * </ul>
 * </p>
 * 
 * @author Your Name
 * @version 1.0
 */
public class BenchmarkUtility {

    /**
     * Benchmarks a given sorting algorithm by measuring the time it takes to sort an array.
     * <p>
     * This method:
     * <ol>
     *     <li>Creates a copy of the provided array to avoid modifying the original.</li>
     *     <li>Records the start time using {@code System.nanoTime()}.</li>
     *     <li>Sorts the copied array using the specified sorting algorithm.</li>
     *     <li>Records the end time and calculates the duration in milliseconds.</li>
     *     <li>Prints the sorting algorithm's name and the time taken.</li>
     * </ol>
     * </p>
     * 
     * @param <T> The type of elements in the array, which must be comparable using the provided comparator.
     * @param array The array to be sorted (a copy is made to preserve the original order).
     * @param comparator The comparator used for sorting.
     * @param algorithm The sorting algorithm to use. Must be one of:
     *                 <ul>
     *                     <li>"bubble" - Bubble Sort</li>
     *                     <li>"selection" - Selection Sort</li>
     *                     <li>"insertion" - Insertion Sort</li>
     *                     <li>"merge" - Merge Sort</li>
     *                     <li>"quick" - Quick Sort</li>
     *                     <li>"heap" - Heap Sort</li>
     *                 </ul>
     * @throws IllegalArgumentException if an invalid sorting algorithm is provided.
     */
    public static <T> void benchmarkSort(T[] array, Comparator<T> comparator, String algorithm) {
        T[] tempArray = array.clone(); // Clone array to avoid modifying the original
        long startTime = System.nanoTime(); // Start time measurement

        // Select and run the sorting algorithm
        switch (algorithm) {
            case "bubble": BubbleSort.bubbleSort(tempArray, comparator); break;
            case "selection": SelectionSort.selectionSort(tempArray, comparator); break;
            case "insertion": InsertionSort.insertionSort(tempArray, comparator); break;
            case "merge": MergeSort.mergeSort(tempArray, comparator); break;
            case "quick": QuickSort.quickSort(tempArray, 0, tempArray.length - 1, comparator); break;
            case "heap": HeapSort.heapSort(tempArray, comparator); break;
            default: throw new IllegalArgumentException("Invalid sorting algorithm: " + algorithm);
        }

        long endTime = System.nanoTime(); // End time measurement
        double duration = (endTime - startTime) / 1e6; // Convert nanoseconds to milliseconds
        System.out.printf("%s Sort took %.3f ms\n", algorithm, duration);
    }
}
