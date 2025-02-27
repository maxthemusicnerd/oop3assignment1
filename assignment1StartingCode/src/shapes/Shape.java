package shapes;

public abstract class Shape {
	protected double height;
	
	public double getHeight() {
		return height; 
	}
	
	
	public abstract double calcVolume();
	public abstract double calcBaseArea();
	
	//In all of the classes that inherit from this, in the constructor, the first parameter is always height, and the second one is the other value -Max O
}
