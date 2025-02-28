package sorting;

import java.util.Comparator;

public class BubbleSort {
    public static <T> void bubbleSort(T[] array, Comparator<T> comparator) {
        int n = array.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(array[j], array[j + 1]) < 0) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
    
    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
	
	