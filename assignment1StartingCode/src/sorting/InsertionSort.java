package sorting;

import java.util.Comparator;

public class InsertionSort {
	
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
}
    