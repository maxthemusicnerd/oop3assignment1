package shapes;

import java.util.Comparator;

/**
 * The {@code ShapeVolumeComparator} class implements the {@code Comparator<Shape>} interface
 * to compare two {@code Shape} objects based on their volume.
 * <p>
 * This comparator enables sorting shapes in ascending order of their volume.
 * </p>
 * 
 * @version 1.8
 */
public class ShapeVolumeComparator implements Comparator<Shape> {

    /**
     * Compares two {@code Shape} objects based on their volume.
     * <p>
     * The comparison is performed using {@code Double.compare()}, which ensures proper ordering:
     * <ul>
     *     <li>Returns a negative integer if {@code s1} has a smaller volume than {@code s2}.</li>
     *     <li>Returns zero if both shapes have the same volume.</li>
     *     <li>Returns a positive integer if {@code s1} has a larger volume than {@code s2}.</li>
     * </ul>
     * </p>
     * 
     * @param s1 The first shape to compare.
     * @param s2 The second shape to compare.
     * @return A negative integer, zero, or a positive integer as the first shape's volume
     *         is less than, equal to, or greater than the second shape's volume.
     */
    @Override
    public int compare(Shape s1, Shape s2) {
        return Double.compare(s1.calcVolume(), s2.calcVolume());
    }
}
