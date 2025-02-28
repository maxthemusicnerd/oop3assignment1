package sorting;

import java.util.Comparator;

/**
 * QuickSort class provides a static method to perform the quick sort algorithm
 * on an array of objects using a specified comparator for comparison.
 * 
 * @param <T> the type of elements in the array to be sorted
 */
public class QuickSort {

    /**
     * Sorts the provided array using the quick sort algorithm.
     * This is a divide-and-conquer algorithm that selects a pivot element,
     * partitions the array into two subarrays based on the pivot, and recursively sorts
     * each subarray.
     *
     * @param <T> the type of elements in the array to be sorted
     * @param array the array to be sorted
     * @param low the starting index of the subarray to sort
     * @param high the ending index of the subarray to sort
     * @param comparator the comparator used to compare elements in the array
     */
    public static <T> void quickSort(T[] array, int low, int high, Comparator<T> comparator) {
        // Base case: if the subarray has more than one element, partition and sort
        if (low < high) {
            int pi = partition(array, low, high, comparator);

            // Recursively sort the subarrays on either side of the pivot
            quickSort(array, low, pi - 1, comparator);
            quickSort(array, pi + 1, high, comparator);
        }
    }

    /**
     * Partitions the array around a pivot element, such that elements greater than
     * the pivot are on one side and elements less than the pivot are on the other.
     *
     * @param <T> the type of elements in the array
     * @param array the array to partition
     * @param low the starting index of the subarray
     * @param high the ending index of the subarray
     * @param comparator the comparator used to compare elements in the array
     * @return the index of the pivot element after partitioning
     */
    private static <T> int partition(T[] array, int low, int high, Comparator<T> comparator) {
        // Select the pivot as the last element of the subarray
        T pivot = array[high];
        int i = low - 1;

        // Iterate through the subarray and reorder elements
        for (int j = low; j < high; j++) {
            if (comparator.compare(array[j], pivot) >= 0) {
                i++;
                swap(array, i, j);  // Swap if element is greater than or equal to pivot
            }
        }

        // Place the pivot in its correct position
        swap(array, i + 1, high);
        return i + 1;
    }

    /**
     * Swaps two elements in the array.
     *
     * @param <T> the type of elements in the array
     * @param array the array in which the elements will be swapped
     * @param i the index of the first element to swap
     * @param j the index of the second element to swap
     */
    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
