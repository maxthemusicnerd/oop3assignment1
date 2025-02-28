package sorting;

import java.io.*;
import java.util.*;
import shapes.Cone;
import shapes.Cylinder;
import shapes.OctagonalPrism;
import shapes.PentagonalPrism;
import shapes.Pyramid;
import shapes.Shape;
import shapes.ShapeBaseAreaComparator;
import shapes.ShapeVolumeComparator;
import shapes.SquarePrism;
import shapes.TriangularPrism;



public class SortingApp {
    public static void main(String[] args) {
        // Parse command-line arguments
        String fileName = null;
        String sortType = null;
        String sortAlgorithm = null;
        
        for (String arg : args) {
            if (arg.startsWith("-f")) fileName = arg.substring(2);
            else if (arg.startsWith("-t")) sortType = arg.substring(2);
            else if (arg.startsWith("-s")) sortAlgorithm = arg.substring(2);
        }

        if (fileName == null || sortType == null || sortAlgorithm == null) {
            System.out.println("random null error");
            return;
        }
        
        // Read shapes from file
        Shape[] shapes = readShapesFromFile(fileName);
        if (shapes == null) return;
        
        // Select comparator
        Comparator<Shape> comparator;
        switch (sortType) {
            case "v": comparator = new ShapeVolumeComparator(); break;
            case "h": comparator = Comparator.naturalOrder(); break;
            case "a": comparator = new ShapeBaseAreaComparator(); break;
            default:
                System.out.println("Oops! Invalid sorting type.Please use: v (volume), h (height), or a (base area).");
                return;
        }
        
        // Sort using selected algorithm
        long startTime = System.nanoTime();
        switch (sortAlgorithm) {
            case "b": BubbleSort.sort(shapes, comparator); break;
            case "s": SelectionSort.sort(shapes, comparator); break;
            case "i": InsertionSort.sort(shapes, comparator); break;
            case "m": MergeSort.sort(shapes, comparator); break;
            case "q": QuickSort.quickSort(null, 0, 0, null); break;
            case "z": HeapSort.sort(shapes, comparator); break;
            default:
                System.out.println("Oopa! Invalid sorting algorithm.Please use these following Algorithm Options:  b, s, i, m, q, or z.");
                return;
        }
        long endTime = System.nanoTime();
        
        // Output results
        System.out.printf("Sorting only took %.3f milliseconds.%nA new record!%n", (endTime - startTime) / 1e6);
        printSortedShapes(shapes);
    }
    
    private static Shape[] readShapesFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int numShapes = Integer.parseInt(reader.readLine().trim());
            Shape[] shapes = new Shape[numShapes];
            
            for (int i = 0; i < numShapes; i++) {
                String[] parts = reader.readLine().split(" ");
                String type = parts[0];
                double h = Double.parseDouble(parts[1]);
                double rOrEdge = Double.parseDouble(parts[2]);
                
                switch (type) {
                    case "Cylinder": shapes[i] = new Cylinder(h, rOrEdge); break;
                    case "Cone": shapes[i] = new Cone(h, rOrEdge); break;
                    case "Pyramid": shapes[i] = new Pyramid(h, rOrEdge); break;
                    case "SquarePrism": shapes[i] = new SquarePrism(h, rOrEdge); break;
                    case "TriangularPrism": shapes[i] = new TriangularPrism(h, rOrEdge); break;
                    case "PentagonalPrism": shapes[i] = new PentagonalPrism(h, rOrEdge); break;
                    case "OctagonalPrism": shapes[i] = new OctagonalPrism(h, rOrEdge); break;
                    default:
                        System.out.println("Oops! Unknown shape type: " + type);
                        return null;
                }
            }
            return shapes;
        } catch (IOException | NumberFormatException e) {
            System.out.println("Oops! Error reading file: " + e.getMessage());
            return null;
        }
    }
    private static void printSortedShapes(Shape[] shapes) {
        System.out.println("First: " + shapes[0]);
        for (int i = 1000; i < shapes.length; i += 1000) {
            System.out.println("Every 1000th: " + shapes[i]);
        }
        System.out.println("Last: " + shapes[shapes.length - 1]);
    }
}