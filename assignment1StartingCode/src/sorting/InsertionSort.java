package sorting;

import java.util.Comparator;

/**
 * The {@code InsertionSort} class implements the Insertion Sort algorithm.
 * <p>
 * Insertion Sort is a simple, comparison-based sorting algorithm that builds the sorted array
 * one element at a time by inserting each new element into its correct position.
 * <br><br>
 * Time Complexity:
 * <ul>
 *   <li>Best case: O(n) (when the array is already sorted)</li>
 *   <li>Average case: O(n²)</li>
 *   <li>Worst case: O(n²) (when the array is sorted in reverse order)</li>
 * </ul>
 * </p>
 *
 * @author Your Name
 * @version 1.0
 */
public class InsertionSort {

    /**
     * Sorts an array using the Insertion Sort algorithm in descending order.
     * <p>
     * The algorithm iterates through the array and inserts each element into its correct position
     * relative to the sorted portion of the array.
     * </p>
     *
     * @param <T> The type of elements in the array, which must be comparable using the given comparator.
     * @param array The array to be sorted.
     * @param comparator The comparator defining the sorting order.
     */
    public static <T> void insertionSort(T[] array, Comparator<T> comparator) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            T key = array[i];
            int j = i - 1;

            // Move elements that are smaller than key to the right
            while (j >= 0 && comparator.compare(array[j], key) < 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
