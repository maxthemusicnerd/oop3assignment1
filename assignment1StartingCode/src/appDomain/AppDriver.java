package appDomain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.Scanner;
import shapes.*;
import sorting.*;

public class AppDriver
{
	private static int MAX_SHAPES; 
	private static Shape[] shapes; 
	private static int shapeCount = 0;
	
	static String sortType = null;
    static String sortAlgorithm = null;
	    
	
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java -jar Sort.jar -f <filename> -T <sortType> -S <sortAlgorithm>");
            return;
        }

        String filename = null;

        // Parse arguments properly
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-f":
                    if (i + 1 < args.length) filename = args[++i];
                    break;
                case "-t":
                    if (i + 1 < args.length) sortType = args[++i].toLowerCase();
                    break;
                case "-s":
                    if (i + 1 < args.length) sortAlgorithm = args[++i].toLowerCase();
                    break;
                default:
                    System.out.println("Invalid argument: " + args[i]);
                    return;
            }
        }

        // Ensure all required arguments are provided
        if (filename == null || sortType == null || sortAlgorithm == null) {
            System.out.println("Missing required arguments. Usage: java -jar Sort.jar -f <filename> -T <sortType> -S <sortAlgorithm>");
            return;
        }
        
        File inputFile = new File("res/" + filename);
        if (!inputFile.exists()) {
            System.err.println("Error: File not found at " + inputFile.getAbsolutePath());
            return;
        }




        try (Scanner input = new Scanner(inputFile)) {
            if (input.hasNextLine()) {
                MAX_SHAPES = Integer.parseInt(input.nextLine());
                shapes = new Shape[MAX_SHAPES];
            }

            while (input.hasNextLine() && shapeCount < MAX_SHAPES) {
                String line = input.nextLine();
                try {
                    Shape shape = parseShape(line);
                    shapes[shapeCount++] = shape;
                } catch (IllegalArgumentException e) {
                    System.err.println("Skipping invalid shape: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
            return;
        }

        // Initialize Comparator
        Comparator<Shape> comparator;
        switch (sortType) {
            case "v": comparator = new ShapeVolumeComparator(); break;
            case "h": comparator = Comparator.naturalOrder(); break;
            case "a": comparator = new ShapeBaseAreaComparator(); break;
            default:
                System.out.println("Oops! Invalid sorting type. Use: v (volume), h (height), or a (base area).");
                return;
        }

        // Perform Sorting
        long startTime = System.nanoTime();
        switch (sortAlgorithm) {
            case "b": BubbleSort.bubbleSort(shapes, comparator); break;
            case "s": SelectionSort.selectionSort(shapes, comparator); break;
            case "i": InsertionSort.insertionSort(shapes, comparator); break;
            case "m": MergeSort.mergeSort(shapes, comparator); break;
            case "q": QuickSort.quickSort(shapes, 0, shapes.length - 1, comparator); break;
            case "z": HeapSort.heapSort(shapes, comparator); break;
            default:
                System.out.println("Oops! Invalid sorting algorithm. Use: b, s, i, m, q, or z.");
                return;
        }
        long endTime = System.nanoTime();

        System.out.printf("Sorting took %.3f milliseconds.%n", (endTime - startTime) / 1e6);
        printSortedShapes(shapes);
    }

	
    private static void printSortedShapes(Shape[] shapes) {
        System.out.println("Sorted Shapes:");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }


	
	// method to parse parts of each line, radius for cone/cylinder side for others - Max L
	 public static Shape parseShape(String line) {
        String[] parts = line.split(" ");
        String shapeType = parts[0];

        double height = Double.parseDouble(parts[1]);
	        
        switch (shapeType) {
        	case "Cylinder":
        		return new Cylinder(height, Double.parseDouble(parts[2]));
        		
        	case "Cone":
        		return new Cone(height, Double.parseDouble(parts[2]));
                
            case "Pyramid":
                return new Pyramid(height, Double.parseDouble(parts[2]));
                
            case "SquarePrism":
                return new SquarePrism(height, Double.parseDouble(parts[2]));
                
            case "TriangularPrism":
                return new TriangularPrism(height, Double.parseDouble(parts[2]));
                
            case "PentagonalPrism":
                return new PentagonalPrism(height, Double.parseDouble(parts[2]));
                
            case "OctagonalPrism":
                return new OctagonalPrism(height, Double.parseDouble(parts[2]));
                
            default:
                throw new IllegalArgumentException("invalid shape");
        }
    };
};