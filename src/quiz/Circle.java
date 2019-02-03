package quiz;

public class Circle implements Shape {
	
	private double radius;
	private double area;
	private double perimeter;
	
	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double calculatePerimeter() {
		this.perimeter = 2 * radius * Math.PI;
		return perimeter;
	}

	@Override
	public double calculateArea() {
		this.area = Math.PI * radius * radius;
		return area;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(radius);
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
		if (!(obj instanceof Circle)) {
			return false;
		}
		Circle other = (Circle) obj;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius)) {
			return false;
		}
		return true;
	}
	
}
