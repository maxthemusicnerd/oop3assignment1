package shapes;

import java.util.Comparator;

public class ShapeBaseAreaComparator implements Comparator<Shape>{
	
	@Override
	public int compare(Shape s1, Shape s2) {
		return Double.compare(s1.calcBaseArea(), s2.calcBaseArea());
	}
	
}	
