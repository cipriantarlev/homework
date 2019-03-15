package tema_02_03_2019;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

public class IOHomework {

	public static void main(String[] args) {

		extractWordFromAFile();
	}

	public static void getListOfAllFile() {
		Path path = Paths.get("D:\\Eclipse\\Homework\\src\\");
		File file = path.toFile();
		String[] list = file.list();
		for (String string : list) {
			System.out.println(string);
		}
	}

	public static void getAFileByExtenstion() {

		Path path = Paths.get("D:\\Eclipse\\Homework\\src\\");
		File file = path.toFile();
		String[] list = file.list();
		for (String file1 : list) {
			if (file1.endsWith(".txt")) {
				System.out.println(file1);
			}
		}
	}

	public static void checkIfFileExist() {

		Path path = Paths.get("D:\\Eclipse\\Homework\\src\\");
		File file = path.toFile();
		String[] list = file.list();
		for (String file1 : list) {
			if (file1.contains("quiz")) {
				System.out.println(file1);
			}
		}
	}

	public static void checkPermision() {

		Path path = Paths.get("D:\\Eclipse\\Homework\\src\\");
		File file = path.toFile();
		File[] list = file.listFiles();

		for (File file1 : list) {
			if (file1.canWrite()) {
				System.out.println("The file: " + file1.getName() + " has write permision");
			} else {
				System.out.println("The file: " + file1.getName() + " has read permision");
			}
		}
	}

	public static void isFileOrDirectory() {

		Path path = Paths.get("D:\\Eclipse\\Homework\\src\\");
		File file = path.toFile();
		File[] list = file.listFiles();

		for (File file1 : list) {
			if (file1.isDirectory()) {
				System.out.println("The file: " + file1.getName() + " is Directory");
			} else {
				System.out.println("The file: " + file1.getName() + " is File");
			}
		}
	}

	public static void compareLexicographicallyTwoFiles() {

		try (BufferedReader reader1 = new BufferedReader(new FileReader("in1.txt"));
				BufferedReader reader2 = new BufferedReader(new FileReader("in2.txt"))) {
			String line1 = reader1.readLine();
			String line2 = reader2.readLine();
			while (line1 != null && line2 != null) {
				if (line1.equalsIgnoreCase(line2)) {
					System.out.println("These files are equals");
				} else {
					System.out.println("These files aren't equals");
				}
				break;
			}
		} catch (IOException ex) {
			System.out.println("I can't find the file, where it is????");
		}

	}

	public static void getLastModifiedTimeOfFile() {

		Path path = Paths.get("in1.txt");
		File file = path.toFile();

		Date date = new Date(file.lastModified());

		System.out.println(date);
	}

	public static void readInputFromConsole() {
		Scanner scan = new Scanner(System.in);

		String input = scan.nextLine();

		System.out.println(input);

		scan.close();
	}

	public static void getFileSize() {

		File file = new File("in2.txt");

		double size = file.length();

		System.out.println(
				"The file size is: " + size + " Bytes and " + size * 0.001 + " KB and " + size / (1024 * 1024) + " MB");
	}

	public static void readContentsFromFileIntoByteArray() {

		try (BufferedReader reader2 = new BufferedReader(new FileReader("in2.txt"))) {
			String line2 = reader2.readLine();
			while (line2 != null) {
				byte[] byteArray = line2.getBytes();
				for (byte b : byteArray) {
					System.out.println(b);
				}
				break;
			}
		} catch (IOException ex) {
			System.out.println("I can't find the file, where it is????");
		}
	}

	public static void readLineByLine() {

		try (BufferedReader reader = new BufferedReader(new FileReader("in2.txt"))) {
			Stream<String> streamOfLines = reader.lines();
			streamOfLines.forEach(line -> System.out.println(line));

		} catch (IOException ex) {
			System.out.println("I can't find the file, where it is????");
		}

	}

	public static void readPlainTextFile() {

		try (BufferedReader reader = new BufferedReader(new FileReader("in2.txt"))) {
			Stream<String> streamOfLines = reader.lines();
			streamOfLines.forEach(line -> System.out.println("With lines: --> " + line));

		} catch (IOException ex) {
			System.out.println("I can't find the file, where it is????");
		}
	}

	public static void readAFileAndStoreItIntoVariable() {

		try (BufferedReader reader = new BufferedReader(new FileReader("in2.txt"))) {
			String first = "";
			String seconde = reader.readLine();
			while (seconde != null) {
				first += seconde;
				seconde = reader.readLine();
			}
			System.out.println(first);
		} catch (IOException ex) {
			System.out.println("I can't find the file, where it is????");
		}
	}

	public static void storeIntoArray() {

		try (BufferedReader reader = new BufferedReader(new FileReader("in2.txt"))) {
			String first = "";
			String seconde = reader.readLine();
			while (seconde != null) {
				first += seconde;
				seconde = reader.readLine();
			}
			char[] charArray = first.toCharArray();
			for (char c : charArray) {
				System.out.println(c);
			}

		} catch (IOException ex) {
			System.out.println("I can't find the file, where it is????");
		}
	}

	public static void writeAndReadAFile() {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("in1.txt", true));
				BufferedReader reader = new BufferedReader(new FileReader("in1.txt"))) {

			writer.write(" Hey, salutare! Ce facet?");
			System.out.println(reader.readLine());

		} catch (IOException e) {
			System.out.println("I can't find the file, where it is????");
		}
	}

	public static void appendAFile() {

		try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("in1.txt", true)));
				BufferedReader reader = new BufferedReader(new FileReader("in1.txt"))) {

			writer.append("How are you gays?");
			System.out.println(reader.readLine());

		} catch (IOException e) {
			System.out.println("I can't find the file, where it is????");
		}
	}

	public static void readFirst3Lines() {

		try (BufferedReader reader = new BufferedReader(new FileReader("in1.txt"))) {

			String line = "";
			int i = 0;
			while ((line = reader.readLine()) != null && i < 3) {
				System.err.println(line);
				i++;
			}

		} catch (IOException e) {
			System.out.println("I can't find the file, where it is????");
		}
	}

	public static void findTheLargestWord() {
		try (Scanner scan = new Scanner(new File("in1.txt"))) {

			String largestWord = "";
			String current = "";

			while (scan.hasNext()) {
				current = scan.next();
				if (current.length() > largestWord.length()) {
					largestWord = current;
				}
			}
			System.out.println(largestWord);

		} catch (IOException e) {
			System.out.println("I can't find the file, where it is????");
		}

	}

	public static void extractWordFromAFile() {

		try {
			Scanner scaner = new Scanner(new FileReader("D:\\Eclipse\\Homework\\in1.txt"));
			while (scaner.hasNextLine()) {
				String line = scaner.nextLine();
				String[] words = line.split("\\s");
				Arrays.sort(words);
				for (String string : words) {
					System.out.println(string);
				}
			}
		} catch (FileNotFoundException e) {

			System.out.println("I can't find the file, where it is????");
		}

	}
}