package shapes;

public class Pyramid extends Shape
{
	private double side; 
	
	public double getSide() {
		return side;
	}
	
	public double calcVolume() {
		return calcBaseArea() * height / 3;
	}
	
	public double calcBaseArea() {
		return side * side; 
	}
	
	public Pyramid(double height, double side) {
		this.height = height;
		this.side = side;
	}
}
