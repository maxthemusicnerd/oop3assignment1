package sorting;

import java.util.Comparator;

/**
 * MergeSort class provides a static method to perform the merge sort algorithm
 * on an array of objects using a specified comparator for comparison.
 * 
 * @param <T> the type of elements in the array to be sorted
 */
public class MergeSort {

    /**
     * Sorts the provided array using the merge sort algorithm.
     * This is a divide-and-conquer algorithm that recursively splits the array into
     * subarrays and merges them in sorted order.
     *
     * @param <T> the type of elements in the array to be sorted
     * @param array the array to be sorted
     * @param comparator the comparator used to compare elements in the array
     */
    public static <T> void mergeSort(T[] array, Comparator<T> comparator) {
        // Base case: if the array has fewer than 2 elements, it's already sorted
        if (array.length < 2) return;

        // Find the midpoint of the array
        int mid = array.length / 2;

        // Create two subarrays
        T[] left = (T[]) new Object[mid];
        T[] right = (T[]) new Object[array.length - mid];

        // Copy the data into the left and right subarrays
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        // Recursively sort both subarrays
        mergeSort(left, comparator);
        mergeSort(right, comparator);

        // Merge the sorted subarrays back into the original array
        merge(array, left, right, comparator);
    }

    /**
     * Merges two sorted subarrays into a single sorted array.
     * 
     * @param <T> the type of elements in the array
     * @param array the original array to store the sorted result
     * @param left the left subarray to merge
     * @param right the right subarray to merge
     * @param comparator the comparator used to compare elements in the arrays
     */
    private static <T> void merge(T[] array, T[] left, T[] right, Comparator<T> comparator) {
        int i = 0, j = 0, k = 0;

        // Merge elements from left and right subarrays in sorted order
        while (i < left.length && j < right.length) {
            if (comparator.compare(left[i], right[j]) >= 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copy any remaining elements from the left subarray
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Copy any remaining elements from the right subarray
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
}
