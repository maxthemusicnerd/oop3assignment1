package sorting;

import java.util.Comparator;

/**
 * The {@code BubbleSort} class provides an implementation of the Bubble Sort algorithm.
 * <p>
 * This sorting algorithm works by repeatedly swapping adjacent elements if they are in the wrong order.
 * The process continues until no more swaps are needed, meaning the array is sorted.
 * <br><br>
 * The algorithm runs in O(n²) time complexity in the worst and average cases, 
 * but it has an optimized version with an early exit when no swaps occur, improving efficiency on nearly sorted data.
 * </p>
 *
 * @author Your Name
 * @version 1.0
 */
public class BubbleSort {

    /**
     * Sorts an array using the Bubble Sort algorithm in descending order.
     * <p>
     * This method iterates through the array multiple times, swapping adjacent elements 
     * if they are in the wrong order according to the given comparator. The sorting is optimized 
     * with a flag to stop early if the array becomes sorted before completing all passes.
     * </p>
     *
     * @param <T> The type of elements in the array, which must be comparable using the given comparator.
     * @param array The array to be sorted.
     * @param comparator The comparator defining the sorting order.
     */
    public static <T> void bubbleSort(T[] array, Comparator<T> comparator) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(array[j], array[j + 1]) < 0) { // Descending order
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            // If no swaps occurred in this pass, the array is already sorted
            if (!swapped) break;
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
