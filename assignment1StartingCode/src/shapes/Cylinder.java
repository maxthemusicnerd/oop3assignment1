package shapes;

public class Cylinder extends Shape
{
	private double radius;
	
	@Override
	public double calcBaseArea() {
		return Math.PI * (radius * radius);
	}
	
	@Override
	public double calcVolume() {
		return Math.PI * (radius*radius) * height;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public Cylinder(double height, double radius) {
		this.height = height;
		this.radius = radius;
	}
}
