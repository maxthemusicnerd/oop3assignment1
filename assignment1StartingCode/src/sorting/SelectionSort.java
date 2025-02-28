package sorting;

import java.util.Comparator;

public class SelectionSort {
    public static <T> void selectionSort(T[] array, Comparator<T> comparator) {
        int n = array.length;
        
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(array[j], array[maxIdx]) > 0) {
                    maxIdx = j;
                }
            }
            swap(array, i, maxIdx);
        }
    }
    
    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
	
	