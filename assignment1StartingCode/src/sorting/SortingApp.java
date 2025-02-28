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
                System.out.println("Invalid sorting type. Use v (volume), h (height), or a (base area).");
                return;
        }
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
                        System.out.println("Unknown shape type: " + type);
                        return null;
                }
            }
            return shapes;
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
    }
}