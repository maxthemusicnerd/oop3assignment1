package appDomain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import shapes.*;

public class AppDriver
{
	private static int MAX_SHAPES; 
	private static Shape[] shapes; 
	private static int shapeCount = 0;
	    
	
	public static void main( String[] args )
	{
		// TODO Auto-generated method stub

		// refer to demo001 BasicFileIO.java for a simple example on how to
		// read data from a text file
			
		
		// arg has to have 2 argumetns and start with -f - Max L
	    if (args.length < 2 || !args[0].equals("-f")) {
            return;
        };
	    
        String filename = args[1];
        File inputFile = new File(filename);

	        try (Scanner input = new Scanner(inputFile)) {
	        	if (input.hasNextLine()) {
        	        // uses first line of file as MAX_SHAPES - Max L
        	        AppDriver.MAX_SHAPES = Integer.parseInt(input.nextLine());
        	        shapes = new Shape[MAX_SHAPES];
        	    };
	        	
        	    // parses list line by line - Max L
	            while (input.hasNextLine() && shapeCount < MAX_SHAPES) {
	                String line = input.nextLine();
	                try {
	                    Shape shape = parseShape(line);
	                    shapes[shapeCount++] = shape;
	                } 
	                
	                catch (IllegalArgumentException e) {
	                    System.err.println("Skipping invalid shape: " + line);
	                };
	            };
	        }
	        
	        // if file isnt real and only a hallucination from lack of sleep - Max L
	        catch (FileNotFoundException e) {
	            System.err.println("File not found");
	            e.printStackTrace();                                                                                                                                                                                                                                                                                     
	        };
		
		// refer to demo01 Test.java for an example on how to parse command
		// line arguments and benchmarking tests

		
		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)

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
