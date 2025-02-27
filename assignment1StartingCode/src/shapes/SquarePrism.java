package shapes;

public class SquarePrism extends Prism
{
	public double calcVolume() {
		return calcBaseArea() * height;
	}
	
	public double calcBaseArea() {
		return side * side;
	}
	
	public SquarePrism(double height, double side) {
		this.height = height;
		this.side = side; 
	}
}
