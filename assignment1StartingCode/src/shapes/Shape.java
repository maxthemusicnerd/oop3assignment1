package shapes;

public abstract class Shape implements Comparable<Shape>{
	protected double height;
	
	public double getHeight() {
		return height; 
	}
	
	
	public abstract double calcVolume();
	public abstract double calcBaseArea();
	
	public int compareTo(Shape that) {
		return Double.compare(this.height, that.height);
	}
	
	//In all of the classes that inherit from this, in the constructor, the first parameter is always height, and the second one is the other value -Max O
}
