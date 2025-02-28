package appDomain;

import java.io.File;
import java.io.FileNotFoundException;
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
        System.out.println(" Program started...");

        if (args.length < 3) {
            System.out.println("Usage: java -jar Sort.jar -f <filename> -t <sortType> -s <sortAlgorithm>");
            return;
        }

        String filename = null;
        
        // Parse arguments properly
        System.out.println(" Parsing command-line arguments...");
        for (String arg : args) {
        	String lowerArg = arg.toLowerCase();
            if (lowerArg.startsWith("-f")) {
                filename = arg.substring(2);
            } else if (lowerArg.startsWith("-t")) {
                sortType = arg.substring(2);
            } else if (lowerArg.startsWith("-s")) {
                sortAlgorithm = arg.substring(2);
            } else {
                System.out.println(" Invalid argument: " + arg);
                return;
            }
        }

        System.out.println(" Filename: " + filename);
        System.out.println(" Sort Type: " + sortType);
        System.out.println(" Sort Algorithm: " + sortAlgorithm);

        // Ensure all required arguments are provided
        if (filename == null || sortType == null || sortAlgorithm == null) {
            System.out.println(" Missing required arguments. Usage: java -jar Sort.jar -f <filename> -t <sortType> -s <sortAlgorithm>");
            return;
        }

        System.out.println(" Attempting to open file: res/" + filename);
        File inputFile = new File("res/" + filename);
        if (!inputFile.exists()) {
            System.err.println(" Error: File not found at " + inputFile.getAbsolutePath());
            return;
        }
        System.out.println(" File found! Processing...");

        try (Scanner input = new Scanner(inputFile)) {
            if (input.hasNextLine()) {
                MAX_SHAPES = Integer.parseInt(input.nextLine());
                shapes = new Shape[MAX_SHAPES];
                System.out.println(" Max shapes: " + MAX_SHAPES);
            }

            while (input.hasNextLine() && shapeCount < MAX_SHAPES) {
                String line = input.nextLine();
                try {
                    Shape shape = parseShape(line);
                    shapes[shapeCount++] = shape;
                } catch (IllegalArgumentException e) {
                    System.err.println(" Skipping invalid shape: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(" File not found: " + filename);
            return;
        }

        System.out.println(" Successfully loaded " + shapeCount + " shapes.");
        
        // Initialize Comparator
        System.out.println(" Initializing sorting comparator...");
        Comparator<Shape> comparator;
        switch (sortType) {
            case "v": comparator = new ShapeVolumeComparator(); break;
            case "h": comparator = Comparator.naturalOrder(); break;
            case "a": comparator = new ShapeBaseAreaComparator(); break;
            default:
                System.out.println(" Oops! Invalid sorting type. Use: v (volume), h (height), or a (base area).");
                return;
        }
        System.out.println(" Comparator initialized for " + sortType);

        // Perform Sorting
        System.out.println(" Sorting started using " + sortAlgorithm + "...");
        long startTime = System.nanoTime();
        switch (sortAlgorithm) {
            case "b": BubbleSort.bubbleSort(shapes, comparator); break;
            case "s": SelectionSort.selectionSort(shapes, comparator); break;
            case "i": InsertionSort.insertionSort(shapes, comparator); break;
            case "m": MergeSort.mergeSort(shapes, comparator); break;
            case "q": QuickSort.quickSort(shapes, 0, shapes.length - 1, comparator); break;
            case "z": HeapSort.heapSort(shapes, comparator); break;
            default:
                System.out.println(" Oops! Invalid sorting algorithm. Use: b, s, i, m, q, or z.");
                return;
        }
        long endTime = System.nanoTime();
        
        

        // Print Sorted Shapes
        printSortedShapes(shapes);
        System.out.printf("Sorting completed in %.3f milliseconds.%n", (endTime - startTime) / 1e6);

    }


	
    private static void printSortedShapes(Shape[] shapes) {
        System.out.println("Sorted Shapes Summary:\n");

        // Print the first shape
        System.out.println("First: " + formatShape(shapes[0]));

        // Print every 1000th shape
        for (int i = 1000; i < shapes.length; i += 1000) {
            System.out.println(i + "th: " + formatShape(shapes[i]));
        }

        // Print the last shape
        System.out.println("Last: " + formatShape(shapes[shapes.length - 1]));
    }

    // Helper method to format the shape output based on sorting type
    private static String formatShape(Shape shape) {
        if (sortType.equals("v")) {
            return shape + " Volume: " + shape.calcVolume();
        } else if (sortType.equals("h")) {
            return shape + " Height: " + shape.getHeight();
        } else if (sortType.equals("a")) {
            return shape + " Base Area: " + shape.calcBaseArea();
        }
        return shape.toString(); // Default
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