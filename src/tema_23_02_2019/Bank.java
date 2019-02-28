package tema_23_02_2019;

import java.util.HashMap;
import java.util.Map;

public class Bank {
	
	protected Map<String, BankAccount> bankAccounts = new HashMap<>();
	
	public void initiateBankAccounts () {
		bankAccounts.put("1234 2345 3456 4567", new BankAccount("Tarlev Ciprian", 0000, 1458));
		bankAccounts.put("4567 1234 2345 3456", new BankAccount("Alexuta Constantin", 1111, 2457));
		bankAccounts.put("3456 1234 2345 4567", new BankAccount("Dragos Pirvu", 1234, 3547));
		bankAccounts.put("2345 1234 3456 4567", new BankAccount("Andrei Gornoviceanu", 4321, 954));
		bankAccounts.put("2345 3456 4567 1234", new BankAccount("Adi Tonita", 5678, 2847));
	}

}
