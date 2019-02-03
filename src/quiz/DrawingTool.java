package quiz;

import java.util.ArrayList;
import java.util.List;

public class DrawingTool {

	List<Shape> myList = new ArrayList<>();

	public void addShape(Shape shape) {
		boolean ok = false;
		for (Shape interShape : myList) {
			if (interShape instanceof Square) {
				if (shape.equals(interShape)) {
					ok = true;
				}
			}
			if (interShape instanceof Rectangle) {
				if (shape.equals(interShape)) {
					ok = true;
				}
			}
			if (interShape instanceof Circle) {
				if (shape.equals(interShape)) {
					ok = true;
				}
			}
			if (interShape instanceof Triangle) {
				if (shape.equals(interShape)) {
					ok = true;
				}
			}
		}

		if (ok == true) {
			System.out.println("Please enter another shape");
		} else {
			myList.add(shape);
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
}
