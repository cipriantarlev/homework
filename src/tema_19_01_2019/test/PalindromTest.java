package tema_19_01_2019.test;

import tema_19_01_2019.Palindrom;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromTest {
	
	private Palindrom engine = new Palindrom();
	
	@Test
	public void isThisNumberPalindromTest() {
		assertEquals("Acest String nu este palindrom", engine.isThisNumberPalindrom("tata"));
	}
	
	@Test
	public void isThisNumberPalindromTest1() {
		assertEquals("Acest String este palindrom", engine.isThisNumberPalindrom("123321"));
	}
	
	@Test
	public void isThisNumberPalindromTest2() {
		assertEquals("Acest String este palindrom", engine.isThisNumberPalindrom("cojoc"));
	}
	
	//si s-ar fi testat astfel
	@Test
	public void isThisNumberPalindromTestBoolean() {
		assertFalse(engine.isThisNumberPalindromBoolean("tata"));
	}
	
	@Test
	public void isThisNumberPalindromTestBoolean1() {
		assertTrue(engine.isThisNumberPalindromBoolean("123321"));
	}
	
	@Test
	public void isThisNumberPalindromTestBoolean2() {
		assertTrue(engine.isThisNumberPalindromBoolean("cojoc"));
	}

}