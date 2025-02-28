package shapes;

/**
 * The {@code Shape} class is an abstract base class for all 3D geometric shapes.
 * It defines a common structure for shape objects, including height as a fundamental attribute.
 * <p>
 * This class implements the {@code Comparable<Shape>} interface, allowing shapes
 * to be compared based on their height.
 * </p>
 * 
 * <p>All subclasses must implement methods to calculate volume and base area.</p>
 * 
 * <p><b>Constructor Requirements for Subclasses:</b></p>
 * <ul>
 *     <li>The first parameter must always be the height.</li>
 *     <li>The second parameter must be the other relevant dimension (e.g., radius, side length).</li>
 * </ul>
 * 
 * @version 1.8
 */
public abstract class Shape implements Comparable<Shape> {
    
    /** The height of the shape. */
    protected double height;

    /**
     * Returns the height of the shape.
     * 
     * @return The height of the shape.
     */
    public double getHeight() {
        return height; 
    }

    /**
     * Calculates and returns the volume of the shape.
     * This method must be implemented by subclasses.
     * 
     * @return The volume of the shape.
     */
    public abstract double calcVolume();

    /**
     * Calculates and returns the base area of the shape.
     * This method must be implemented by subclasses.
     * 
     * @return The base area of the shape.
     */
    public abstract double calcBaseArea();

    /**
     * Compares this shape to another shape based on height.
     * This allows shapes to be sorted in ascending order of height.
     * 
     * @param that The other shape to compare to.
     * @return A negative integer if this shape is shorter, zero if heights are equal,
     *         or a positive integer if this shape is taller.
     */
    @Override
    public int compareTo(Shape that) {
        return Double.compare(this.height, that.height);
    }
}
