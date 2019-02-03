package quiz;

public class Triangle implements Shape {

	private double firstSide;
	private double secondeSide;
	private double thirdSide;
	private double area;
	private double perimeter;

	public Triangle(double firstSide, double secondeSide, double thirdSide) {
		this.firstSide = firstSide;
		this.secondeSide = secondeSide;
		this.thirdSide = thirdSide;
	}

	@Override
	public double calculatePerimeter() {
		this.perimeter = firstSide + secondeSide + thirdSide;
		return perimeter;
	}

	@Override
	public double calculateArea() {
		double p = (firstSide + secondeSide + thirdSide) / 2;
		this.area = Math.sqrt(p * (p - firstSide) * (p - secondeSide) * (p - thirdSide));
		return area;
	}

	@Override
	public String toString() {
		return "Triangle [firstSide=" + firstSide + ", secondeSide=" + secondeSide + ", thirdSide=" + thirdSide + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(firstSide);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(secondeSide);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(thirdSide);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Triangle)) {
			return false;
		}
		Triangle other = (Triangle) obj;
		if (Double.doubleToLongBits(firstSide) != Double.doubleToLongBits(other.firstSide)) {
			return false;
		}
		if (Double.doubleToLongBits(secondeSide) != Double.doubleToLongBits(other.secondeSide)) {
			return false;
		}
		if (Double.doubleToLongBits(thirdSide) != Double.doubleToLongBits(other.thirdSide)) {
			return false;
		}
		return true;
	}
	
	
}
