package shapes;

public class PentagonalPrism extends Prism
{
	public PentagonalPrism(double height, double side) {
		this.height = height;
		this.side = side; 
	}
	
	public double calcVolume() {
		return calcBaseArea() * height;
	}
	
	public double calcBaseArea() {
		return (1.0 / 4) * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * Math.pow(side, 2);
	}
}
