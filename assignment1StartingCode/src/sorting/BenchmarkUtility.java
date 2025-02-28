package sorting;

import java.util.Comparator;

public class BenchmarkUtility {
    public static <T> void benchmarkSort(T[] array, Comparator<T> comparator, String algorithm) {
        T[] tempArray = array.clone();
        long startTime = System.nanoTime();
        
        switch (algorithm) {
            case "bubble": BubbleSort.bubbleSort(tempArray, comparator); break;
            case "selection": SelectionSort.selectionSort(tempArray, comparator); break;
            case "insertion": InsertionSort.insertionSort(tempArray, comparator); break;
            case "merge": MergeSort.mergeSort(tempArray, comparator); break;
            case "quick": QuickSort.quickSort(tempArray, 0, tempArray.length - 1, comparator); break;
            case "heap": HeapSort.heapSort(tempArray, comparator); break;
            default: throw new IllegalArgumentException("Invalid sorting algorithm: " + algorithm);
        }
        
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1e6;
        System.out.printf("%s Sort took %.3f ms\n", algorithm, duration);
    }
}