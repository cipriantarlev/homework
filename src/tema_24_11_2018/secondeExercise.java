package tema_24_11_2018;
import java.util.Scanner;

public class secondeExercise {
	public static void main (String [] args0) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter a number: ");
		
		String n = scanner.next();
		boolean ok = true;

		
		for (int i = 0, j = n.length() - 1; i < n.length() / 2 + 1 && ok; i++, j--) {

			if (n.charAt(i) != n.charAt(j)) {
				ok = false;
			}
		}
		if (ok) {
			System.out.println("Acest numar este palindrom");
		} else {
			System.out.println("Acest numar nu este palindrom");
		}
	}
}
