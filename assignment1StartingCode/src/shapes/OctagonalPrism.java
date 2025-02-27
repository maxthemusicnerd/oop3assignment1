package shapes;

public class OctagonalPrism extends Prism
{
	
	public OctagonalPrism(double height, double side) {
		this.height = height;
		this.side = side;
	}
	
	public double calcBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * Math.pow(side, 2);
    }

    public double calcVolume() {
        return calcBaseArea() * height;
    }
}
