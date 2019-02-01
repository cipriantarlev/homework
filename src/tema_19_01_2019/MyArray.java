/**
 * Unde e poza cu challenge-urile de pe Hackerrank?
 */
package tema_19_01_2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MyArray {

	int[][] myArray = new int[3][3];

	public int[][] randomArray() {

		Random rn = new Random();

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				myArray[i][j] = rn.nextInt(100);
				System.out.println("This is myArray: " + myArray[i][j]);
			}
		}
		return myArray;
	}

	public int[][] staticArray() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				myArray[i][j] = i + j;
				System.out.println("This is myArray: " + myArray[i][j]);
			}
		}
		return myArray;
	}

	public int[][] showFirstLine() {
		for (int i = 0; i < 3; i++) {
			System.out.println("This is first line of myArray: " + myArray[i][0]);
		}
		return myArray;
	}

	public int sumOfFirstDiagonal() {
		int sum = 0;
		int max = 0; // o metoda tb sa faca un singur lucru, ar fi tb sa faci o metoda pt sum si una
						// pt max
		List<Integer> myList = new ArrayList<>();
		for (int i = 0, j = 0; i < 3 && j < 3; i++, j++) {
			System.out.println("This is the first diagonal of myArray: " + myArray[i][j]);
			sum += myArray[i][j];
			max = myArray[i][j];
			myList.add(max);
		}
		return Collections.max(myList);
	}

	public int sumOfSecondDiagonal() {
		int sum = 0;
		int max = 0;
		List<Integer> myList = new ArrayList<>();
		for (int i = 0, j = 2; i < 3 && j >= 0; i++, j--) {
			System.out.println("This is the second diagonal of myArray: " + myArray[i][j]);
			sum += myArray[i][j];
			max = myArray[i][j];
			myList.add(max);
		}
		return sum;

	}

	public static void main(String[] args) {
		MyArray a = new MyArray();

		a.staticArray();
		a.showFirstLine();
		a.sumOfFirstDiagonal();
	}
}