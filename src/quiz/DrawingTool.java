package quiz;

import java.util.ArrayList;
import java.util.List;

public class DrawingTool {

	List<Shape> myList = new ArrayList<>();

	public void addShape(Shape shape) {
		if (myList.isEmpty()) {
			myList.add(shape);
		}
		if (shape instanceof Square) {
			for (Shape interShape : myList) {
				if (interShape.equals(shape)) {
					System.out.println("Please enter another shape");
				} else {
					myList.add(shape);
				}
			}
		}
	}

	public double calculateTotalPerimeter() {
		double totalPerimeter = 0;
		for (Shape shape : myList) {
			totalPerimeter += shape.calculatePerimeter();
		}
		System.out.println(totalPerimeter);
		return totalPerimeter;
	}

	public double calculateTotalArea() {
		double totalArea = 0;
		for (Shape shape : myList) {
			totalArea += shape.calculateArea();
		}
		System.out.println(totalArea);
		return totalArea;
	}

	public void showAllShapes() {
		for (Shape shape : myList) {
			System.out.println(shape);
		}
	}

	public static void main(String[] args) {
		DrawingTool s = new DrawingTool();

		s.addShape(new Rectangle(4, 5));
		s.addShape(new Square(2));
		s.addShape(new Square(2));
		s.showAllShapes();
		s.calculateTotalPerimeter();
		s.calculateTotalArea();
	}
}
