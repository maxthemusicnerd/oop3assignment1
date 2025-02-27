package shapes;

public class Cone extends Shape 
{
	private double radius;
	
	@Override
	public double calcBaseArea() {
		return Math.PI * (radius * radius);
	}
	
	@Override
	public double calcVolume() {
		return Math.PI / 3 * (radius * radius) * height;
	}
	
	public Cone(double height, double radius) {
		this.height = height;
		this.radius = radius;
		
	}
	
	public double getRadius() {
		return radius;
	}
}
