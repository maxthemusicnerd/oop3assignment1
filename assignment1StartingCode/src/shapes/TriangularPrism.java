package shapes;

public class TriangularPrism extends Prism
{
	
	public double calcVolume() {
		return calcBaseArea() * height;
	}
	
	public double calcBaseArea() {
		return (Math.sqrt(3) / 4) * Math.pow(side, 2);
	}
	
	public TriangularPrism(double height, double side) {
		this.height = height;
		this.side = side;
	}
}
