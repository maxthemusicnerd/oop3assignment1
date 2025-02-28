package sorting;

import java.util.Comparator;

public class MergeSort {
    public static <T> void sort(T[] array, Comparator<T> comparator) {
        if (array.length < 2) return;
        int mid = array.length / 2;
        T[] left = (T[]) new Object[mid];
        T[] right = (T[]) new Object[array.length - mid];
        
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);
        
        sort(left, comparator);
        sort(right, comparator);
        
        merge(array, left, right, comparator);
    }
    
    private static <T> void merge(T[] array, T[] left, T[] right, Comparator<T> comparator) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (comparator.compare(left[i], right[j]) >= 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
}