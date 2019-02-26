package tema_23_02_2019;

import java.util.HashMap;
import java.util.Map;

public class Bank {
	
	protected Map<String, BankAccount> bankAccount = new HashMap<>();
	
	public void initiateBankAccounts () {
		bankAccount.put("1234 2345 3456 4567", new BankAccount("Tarlev Ciprian", 0000, 1458));
		bankAccount.put("4567 1234 2345 3456", new BankAccount("Alexuta Constantin", 1111, 2457));
		bankAccount.put("3456 1234 2345 4567", new BankAccount("Dragos Pirvu", 1234, 3547));
		bankAccount.put("2345 1234 3456 4567", new BankAccount("Andrei Gornoviceanu", 4321, 954));
		bankAccount.put("2345 3456 4567 1234", new BankAccount("Adi Tonita", 5678, 2847));
	}

}
