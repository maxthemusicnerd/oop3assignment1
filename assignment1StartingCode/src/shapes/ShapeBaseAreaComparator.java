package shapes;

import java.util.Comparator;

/**
 * The {@code ShapeBaseAreaComparator} class implements the {@code Comparator<Shape>} interface
 * to compare two {@code Shape} objects based on their base area.
 * <p>
 * This comparator allows sorting shapes in ascending order of their base area.
 * </p>
 * 
 * @version 1.8
 */
public class ShapeBaseAreaComparator implements Comparator<Shape> {

    /**
     * Compares two {@code Shape} objects based on their base area.
     * <p>
     * The comparison is performed using {@code Double.compare()}, which ensures proper ordering:
     * <ul>
     *     <li>Returns a negative integer if {@code s1} has a smaller base area than {@code s2}.</li>
     *     <li>Returns zero if both shapes have the same base area.</li>
     *     <li>Returns a positive integer if {@code s1} has a larger base area than {@code s2}.</li>
     * </ul>
     * </p>
     * 
     * @param s1 The first shape to compare.
     * @param s2 The second shape to compare.
     * @return A negative integer, zero, or a positive integer as the first shape's base area
     *         is less than, equal to, or greater than the second shape's base area.
     */
    @Override
    public int compare(Shape s1, Shape s2) {
        return Double.compare(s1.calcBaseArea(), s2.calcBaseArea());
    }
}
