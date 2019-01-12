package tema_24_11_2018;
import java.util.Scanner;

public class firstExercise {
	public static void main (String[] args) {
		int sum = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter a number: ");
		
		int n = scanner.nextInt();
		
		while (n != 0) {
			sum = sum + n%10;
			n = n/10;
		}
		System.out.println(sum);
	}
}
