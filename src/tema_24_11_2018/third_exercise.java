package tema_24_11_2018;

public class third_exercise {
	public static void main (String [] args0) {
		
		for (int i = 1; i <= 100; i++) {
			System.out.println(i);
			if (i%3==0) {
				if (i%5==0) {
					System.out.println("TresCinco");
				}
				else {
					System.out.println("Tres");
				}
			}
			else if (i%5==0) {
				System.out.println("Cinco");
			}
		
		}

	}
}
