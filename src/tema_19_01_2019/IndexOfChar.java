package tema_19_01_2019;

public class IndexOfChar {
	
	boolean ok = false;
	int a = 0;
	
	String s = "AnaAreMere";
		
	public int returnIndexOfChar (char n) {
		int i = 0;
		while (ok == false & i < s.length()) {
			a = s.indexOf(n);	
			i++;
		}
		return a;
	}
	
	public static void main(String[] args) {
		IndexOfChar s = new IndexOfChar();
		
		System.out.println(s.returnIndexOfChar('e'));
	}
}
