package tema_24_11_2018;

public class Fourth_exercise {

	public static void main(String[] args) {
		int sum = 0;
		
		for (int i = 2; i <= 100; i++ ) {
			boolean ok = true;
			for (int j = 2; j <= i/2 && ok; j++) {
				if (i%j==0)
				{
					ok = false;
				}
			}
			if (ok) {
				System.out.println(i);
				sum += i;
			}
		}
		System.out.println(sum);
	}

}
