package quiz;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DrawingToolTest {

	private DrawingTool engine = new DrawingTool();

	@Test
	public void calculateTotalPerimeterTest() {
		engine.addShape(new Square(4));
		engine.addShape(new Triangle(4, 5, 2));
		engine.addShape(new Rectangle(4, 2));
		engine.addShape(new Circle(3));
		assertEquals(57.84, engine.calculateTotalPerimeter(), 0.20);
	}

	@Test
	public void calculateTotalAreaTest() {
		engine.addShape(new Square(3));
		engine.addShape(new Triangle(1, 3, 2));
		engine.addShape(new Rectangle(1, 2));
		engine.addShape(new Circle(5));
		assertEquals(86.53, engine.calculateTotalArea(),0.20);
	}
}
