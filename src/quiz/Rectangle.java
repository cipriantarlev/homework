package quiz;

public class Rectangle implements Shape {
	
	private double width;
	private double height;
	private double area;
	private double perimeter;
	
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height; 
	}

	public double calculatePerimeter() {
		
		this.perimeter = 2 * (width + height);
		
		return perimeter;
	}

	public double calculateArea() {
		
		this.area = width * height;
				
		return area;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(area);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(height);
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
		if (!(obj instanceof Rectangle)) {
			return false;
		}
		Rectangle other = (Rectangle) obj;
		if (Double.doubleToLongBits(area) != Double.doubleToLongBits(other.area)) {
			return false;
		}
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height)) {
			return false;
		}
		return true;
	}

	
}
