package sorting;

import java.util.Comparator;

/**
 * The {@code HeapSort} class implements the Heap Sort algorithm for sorting an array.
 * <p>
 * Heap Sort is a comparison-based sorting algorithm that uses a binary heap data structure
 * to build a max heap and then sorts the array by repeatedly extracting the largest element.
 * <br><br>
 * Time Complexity:
 * <ul>
 *   <li>Best case: O(n log n)</li>
 *   <li>Average case: O(n log n)</li>
 *   <li>Worst case: O(n log n)</li>
 * </ul>
 * </p>
 *
 * @author Your Name
 * @version 1.0
 */
public class HeapSort {

    /**
     * Sorts an array using the Heap Sort algorithm in descending order.
     * <p>
     * The method first builds a max heap from the array and then extracts the largest element
     * one by one, placing it at the end of the array.
     * </p>
     *
     * @param <T> The type of elements in the array, which must be comparable using the given comparator.
     * @param array The array to be sorted.
     * @param comparator The comparator defining the sorting order.
     */
    public static <T> void heapSort(T[] array, Comparator<T> comparator) {
        int n = array.length;

        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i, comparator);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0, comparator);
        }
    }

    /**
     * Heapifies a subtree rooted at the given index in an array.
     * <p>
     * This method ensures that the subtree follows the max heap property.
     * </p>
     *
     * @param <T> The type of elements in the array.
     * @param array The array representing the heap.
     * @param n The size of the heap.
     * @param i The index of the root node in the subtree.
     * @param comparator The comparator defining the sorting order.
     */
    private static <T> void heapify(T[] array, int n, int i, Comparator<T> comparator) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && comparator.compare(array[left], array[largest]) > 0) {
            largest = left;
        }

        if (right < n && comparator.compare(array[right], array[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            swap(array, i, largest);
            heapify(array, n, largest, comparator);
        }
    }

    /**
     * Swaps two elements in an array.
     *
     * @param <T> The type of elements in the array.
     * @param array The array in which the swap will occur.
     * @param i The index of the first element to swap.
     * @param j The index of the second element to swap.
     */
    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
