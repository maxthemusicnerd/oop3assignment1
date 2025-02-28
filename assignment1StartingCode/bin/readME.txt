Part A: Create a Sorting Application (90 marks) 
Using the specifications below, create an application to sort any object according to a specific 
property. You’ll then implement and perform experimental analysis (benchmarking) on six 
sorting algorithms: 
• Bubble 
• Insertion 
• Selection 
• Merge 
• Quick  
• A sorting algorithm of your choice  
You must research the sorting algorithm of your choice and ensure that it’s significantly 
different from the other five. This must be an algorithm that does complete sorting the test files 
within a reasonable amount of time! (e.g. no bogosort!) Include a detailed description of this 
sort’s algorithm and a complexity analysis outlined in the Submission Deliverables section of 
this document.  
Note: If you’re unsure of the algorithm you’re allowed to choose, please discuss it with your 
instructor! 
1 
© 2024, Southern Alberta Institute of Technology 
Part B: Complete an Application Evaluation as a Group (5 marks) 
After completing your sorting application, check your work against the provided marking criteria. 
Your instructor will refer to your group’s self-evaluation when grading the assignment and will 
provide further feedback and grade adjustments as needed. Your instructor is responsible for 
awarding the group’s final grade. 
1. Open the Marking Criteria document (MarkingCriteria_Assignment1.docx) and save a 
copy with your group’s name. 
2. As a group, discuss how well you met each criterion and assign yourselves a mark for 
each row in the table. You may include a short, point form, explanation for your mark in 
the Notes column. 
Note: This is an opportunity for you to identify any missing pieces according to the 
marking criteria, make sure you do this step diligently to avoid losing any marks that is 
clearly stated in this document. 
3. Save this file for submission to Brightspace along with your completed code. 
Part C: Complete a Peer Assessment (5 marks) 
Each student must also complete a peer assessment of their group members. Your instructor 
will provide further submission details. 
Assignment Specifications 
Important: Read the specifications very carefully. If you are uncertain about any of the 
requirements, discuss it with your instructor. 
4. Import the assignment1StartingCode project into Eclipse. 
5. Create an abstract class in Java that represents a three-dimensional geometric shape. 
Using the Strategy pattern discussed in class: 
• Implement the compareTo() method of the Comparable interface to compare two 
shapes by their height, and the compare() method of the Comparator interface to 
compare two shapes by their base area and volume. 
o Your implementations of these interfaces MUST adhere to the contract! (i.e. 
return values as specified: negative, positive or zero) 
• The compare type will be provided as input from the command line to your program: 
h for height, v for volume, and a for base area via the -t option. 
6. Write a testing program that will read a text file (entered at the command line via the -f 
option) of random shapes that adds them to an array (not ArrayList).  
2 
© 2024, Southern Alberta Institute of Technology 
Notes:  
• All shapes must be manipulated as elements of the corresponding collection.  
• The value in the first line of the data file contains the number of shapes in that file.  
• Each subsequent line in the data file will contain the values for each shape that you 
will need to generate the corresponding object. 
• A shape in the file is represented as follows on each line (the values are separated by 
spaces): 
o One of: Cylinder, Cone, Prism or Pyramid 
o Cylinders and Cones are followed by a double value representing the height 
and another double value representing radius. 
e.g., Cylinder 9431.453 4450.123 or Cone 674.2435 652.1534 
o Pyramids are followed by a double value representing the height and another 
double value representing edge length. 
e.g., Pyramid 6247.53 2923.456 
o Prisms are specified by the type of base polygon (SquarePrism, TrianglarPrism, 
PentagonalPrism, OctagonalPrism), a double value representing the height and 
another double value representing edge length.  
e.g., SquarePrism 8945.234 3745.334 
• See the formulas at the end of this document for information on how to calculate the 
base area and volume for each type of shape. 
7. Your testing application should then invoke the utility methods to re-arrange the shape 
objects according to the compare type from the largest to smallest (descending order). 
Note: Sorting in ascending order and then reversing the array is NOT acceptable! Your 
sorting algorithm must use the comparable and comparators correctly to re-arrange the 
objects. 
8. Your testing program should print the time that it took to sort the collection of objects for 
each of the six sorting algorithms, including a measurement unit (e.g., milliseconds). This 
should ONLY include the time for the sorting algorithm to run – not including the time to 
read the input file, generate the objects, or display the objects’ data to the screen. 
Note: Have this benchmarking done outside of the sorting algorithms such that the sorting 
code can be executed without this explicit output.  
9. The program should also display to the console – the first sorted value and last sorted 
value, and every thousandth value in between, for example: 
3 
© 2024, Southern Alberta Institute of Technology 
4 
© 2024, Southern Alberta Institute of Technology 
Note: The above does not show the output from the test files provided, it is simply to give you 
an example of what the output would look like – your results will vary depending on the file 
being parsed. Your program output should be similar but does NOT have to match the exact 
formatting as long as the relevant information are shown. Your instructor will use a different test 
data file to evaluate your application. 
10. To run the executable (jar) program, the user should be able to enter the following via the 
command prompt using the following case insensitive format: 
java -jar Sort.jar -ffile_name -tv -sb 
• -f or -F followed by file_name (the file name and path) with no spaces 
• -t or -T followed by v (volume), h (height) or a (base area) with no spaces 
• -s or -S followed by b (bubble), s (selection), i (insertion), m (merge), q (quick) or z 
(your choice of sorting algorithm) with no spaces 
The program must be able to handle these command line arguments no matter the order 
(order insensitive). The following are some examples of valid inputs: 
• java -jar Sort.jar -fshapes1.txt -Tv -Sb 
5 
© 2024, Southern Alberta Institute of Technology 
• java -jar Sort.jar -ta -sQ -f"res\shapes1".txt 
• java -jar Sort.jar -tH -F"C:\temp\shapes1.txt" –sB 
Note: You can assume the user will provide the correct absolute or relative path to the 
required file as shown in the examples above. 
You can test this command input in Eclipse using the “Run Configurations” tool under the 
“Arguments” tab: 
11. If the user enters an incorrect command line argument according to the rules above, the 
program should display a meaningful message to help the user in correcting the error. 
12. You will want to first test your sorting algorithms starting with the smallest data set 
(shapes1.txt) to check the results.  
13. Make sure your code works with the other test data! (i.e., shapes2.txt and shapes3.txt)