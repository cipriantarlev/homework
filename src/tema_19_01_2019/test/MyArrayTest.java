package tema_19_01_2019.test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import tema_19_01_2019.MyArray;

public class MyArrayTest {

	private MyArray engine = new MyArray();
	
	
	
	@Before
	public void setUp() {
		engine.staticArray();
	}
	
	@Test 
	public void staticArrayTest() {
		assertEquals(engine.staticArray()[1][1], 2);
	}
	
	@Test 
	public void staticArrayTest1() {
		assertEquals(engine.staticArray()[0][0], 0);
	}
	@Test 
	public void staticArrayTest2() {
		assertEquals(engine.staticArray()[2][1], 3);
	}
	
	@Test
	public void sumOfFirstDiagonalTest() {
		assertEquals(4,engine.sumOfFirstDiagonal());
	}
	
	@Test
	public void sumOfSecondtDiagonalTest() {
		assertEquals(6,engine.sumOfSecondDiagonal());
	}
}

