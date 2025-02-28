package sorting;

import java.util.Comparator;

public class HeapSort {
    // Custom Sorting Algorithm - Heap Sort
    public static <T> void heapSort(T[] array, Comparator<T> comparator) {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i, comparator);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0, comparator);
        }
    }

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
    
    // Swap utility
	private static <T> void swap(T[] array, int i, int j) {
	    T temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
	}
}
	
	