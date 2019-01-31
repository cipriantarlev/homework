package tema_19_01_2019.test;

import tema_19_01_2019.IndexOfChar;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IndexOfCharTest {

	private IndexOfChar engine = new IndexOfChar();
	
	@Test
	public void returnIndexOfCharTest() {
		assertEquals(5, engine.returnIndexOfChar('e'));
	}
	@Test
	public void returnIndexOfCharTest1() {
		assertEquals(-1, engine.returnIndexOfChar('x'));
	}
	@Test
	public void returnIndexOfCharTest2() {
		assertEquals(0, engine.returnIndexOfChar('a'));
	}
	
}
