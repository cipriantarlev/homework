package tema_02_03_2019.atm;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.util.stream.Collectors.joining;

public class BankFromFile {

	private static Map<String, BankAccountFromFile> bankAccounts = new HashMap<>();
	static {
		try {
			initiateBankAccountsWithLines();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	{
//	public void initiateBankAccounts() {
//		// cerinta pentru tema asta era ca datele astea sa le citesti din fisier
//		// apoi, dupa ce un client face o operatiune, rescrii fisierul astfel incat sa
//		// reflecte modificarile facute in timpul operatiunii
//		bankAccounts.put("1234 2345 3456 4567", new BankAccountFromFile("Tarlev Ciprian", 0000, 1458));
//		bankAccounts.put("4567 1234 2345 3456", new BankAccountFromFile("Alexuta Constantin", 1111, 2457));
//		bankAccounts.put("3456 1234 2345 4567", new BankAccountFromFile("Dragos Pirvu", 1234, 3547));
//		bankAccounts.put("2345 1234 3456 4567", new BankAccountFromFile("Andrei Gornoviceanu", 4321, 954));
//		bankAccounts.put("2345 3456 4567 1234", new BankAccountFromFile("Adi Tonita", 5678, 2847));
//	}
} // Varianta mea
	public Map<String, BankAccountFromFile> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(Map<String, BankAccountFromFile> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	{
//	public void initiateBankAccountsFromFile() {   Varianta mea
//		try {
//			List<String> intermediateList = readFromCSV();
//			addInHashMap(intermediateList);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
	} // Varianta mea
	public static void initiateBankAccountsWithLines() throws IOException {
		Files.lines(Paths.get("bank_db.csv")).forEach(line -> getAccountFromInfo(line));
	}

	private static void getAccountFromInfo(String line) {
		String[] details = line.split(",");
		BankAccountFromFile acc = new BankAccountFromFile(details[1], parseInt(details[2]), parseDouble(details[3]));
		bankAccounts.put(details[0], acc);
	}
	{ 
//	{private List<String> readFromCSV() throws FileNotFoundException, IOException {
//		List<String> intermediateList = new ArrayList<>();
//		BufferedReader reader = new BufferedReader(new FileReader("Bank_Data_Base_in.csv"));
//		String line = null;
//		while ((line = reader.readLine()) != null) {
//			intermediateList.add(line);
//		}
//		reader.close();
//		return intermediateList;                                              Varianta mea
//	}
//
//	private void addInHashMap(List<String> intermediateList) {
//		String stringCollect = intermediateList.stream().collect(joining());
//		String[] splitString = stringCollect.replaceAll("\"", "").split(",");
//		for (int k = 0, a = 1, p = 2, s = 3; s < splitString.length; k += 4, a += 4, p += 4, s += 4) {
//			getBankAccounts().put(splitString[k], new BankAccountFromFile(splitString[a],
//					Integer.parseInt(splitString[p]), Double.parseDouble(splitString[s])));
//		}
//	}}
	} //Varianta mea
	public static void main(String[] args) throws IOException {
		BankFromFile bank = new BankFromFile();
//		bank.initiateBankAccountsFromFile();
		initiateBankAccountsWithLines();
		bank.getBankAccounts().entrySet().stream().forEach(System.out::println);
	}
}
