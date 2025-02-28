package sorting;

import java.util.Comparator;

public class SortingAlgorithms {
	
    // Insertion Sort
    public static <T> void insertionSort(T[] array, Comparator<T> comparator) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            T key = array[i];
            int j = i - 1;
            while (j >= 0 && comparator.compare(array[j], key) < 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
    
    // Quick Sort
    public static <T> void quickSort(T[] array, int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pi = partition(array, low, high, comparator);
            quickSort(array, low, pi - 1, comparator);
            quickSort(array, pi + 1, high, comparator);
        }
    }

    private static <T> int partition(T[] array, int low, int high, Comparator<T> comparator) {
        T pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(array[j], pivot) >= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }
 

    // Swap utility
	private static <T> void swap(T[] array, int i, int j) {
	    T temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
	}
	
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
    
    public static <T> void bubbleSort(T[] array, Comparator<T> comparator) {
        BubbleSort.bubbleSort(array, comparator);
    }
    
    public static <T> void selectionSort(T[] array, Comparator<T> comparator) {
        SelectionSort.selectionSort(array, comparator);
    }
    
    public static <T> void mergeSort(T[] array, Comparator<T> comparator) {
        MergeSort.mergeSort(array, comparator);
    }
}

