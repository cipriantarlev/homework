package tema_19_01_2019;

public class IndexOfChar {
	
	boolean ok = false;
	int a = 0;
	
	String s = "AnaAreMere";
	
	//e ok implementarea, as fi preferat totusi ca stringul s sa fie dat ca parametru 
	//pt a respecta generalitatea algoritmului (vezi primul curs ;)
	public int returnIndexOfChar (char n) {
		int i = 0;
		while (ok == false && i < s.length()) { //folositi mereu && la comparatiile intre variabile boolene
			a = s.indexOf(n);	
			i++;
		}
		return a;
	}
	//nu mai ai nevoie de main, acum avem teste :) 
//	public static void main(String[] args) {
//		IndexOfChar s = new IndexOfChar();
//		
//		System.out.println(s.returnIndexOfChar('e'));
//	}
}
