package tema_23_02_2019;

import java.util.*;

public class ATM {

	private Map<String, BankAccount> bankAccount = new HashMap<>();
	private Scanner scan = new Scanner(System.in);

	public void bankAccountsDataBase() {
		
		bankAccount.put("1234 2345 3456 4567", new BankAccount("Tarlev Ciprian", 0000, 1458));
		bankAccount.put("4567 1234 2345 3456", new BankAccount("Alexuta Constantin", 1111, 2457));
		bankAccount.put("3456 1234 2345 4567", new BankAccount("Dragos Pirvu", 1234, 3547));
		bankAccount.put("2345 1234 3456 4567", new BankAccount("Andrei Gornoviceanu", 4321, 954));
		bankAccount.put("2345 3456 4567 1234", new BankAccount("Adi Tonita", 5678, 2847));
	}

	public void start() {
		this.bankAccountsDataBase();
		
		System.out.println("Good Day Sir, please enter you card number:");
		String cardNumber = scan.nextLine();
		if (bankAccount.containsKey(cardNumber)) {
			System.out.println("Good day Mr/Ms" + bankAccount.get(cardNumber).getAccountOwner()+ " \nWhat action would you like to perform?" );
			this.deposits(cardNumber);
			System.out.println("Good day Mr/Ms" + bankAccount.get(cardNumber));
			this.withdrawals(cardNumber);
			System.out.println("Good day Mr/Ms" + bankAccount.get(cardNumber));
			this.changePin(cardNumber);
			System.out.println("Good day Mr/Ms" + bankAccount.get(cardNumber));
			this.soldInterrogation(cardNumber);
			this.changeAccountInfo(cardNumber);
			System.out.println("Good day Mr/Ms" + bankAccount.get(cardNumber));
			this.quit(cardNumber);
		}else {
			System.out.println("Please enter a valid card number!");
		}
	}

	public void deposits(String cardNumber) {
		System.out.println("Please enter the sum that you would like to add: ");
		double money = scan.nextDouble();
		money = bankAccount.get(cardNumber).getSold() + money;
		bankAccount.get(cardNumber).setSold(money);
		
	}
	
	public void withdrawals(String cardNumber) {
		System.out.println("Please enter the sum that you would like to withdrawal: ");
		double money = scan.nextDouble();
		money = bankAccount.get(cardNumber).getSold() - money;
		bankAccount.get(cardNumber).setSold(money);
	}

	public void changePin(String cardNumber) {
		System.out.println("Please enter the PIN that you would like to set: ");
		int pin = scan.nextInt();
		bankAccount.get(cardNumber).setPin(pin);
	}

	public void soldInterrogation(String cardNumber) {
		System.out.println("Now your sold is: " + bankAccount.get(cardNumber).getSold());;
	}

	public void changeAccountInfo(String cardNumber) {
		System.out.println("Please enter the new account owner: ");
		String firstName = scan.next();
		String lastName = scan.next();
		bankAccount.get(cardNumber).setAccountOwner(firstName + " " + lastName);
	}

	public void quit(String cardNumber) {
		System.out.println("Have a good day Mr/Ms " + bankAccount.get(cardNumber).getAccountOwner() + "!");
	}

	public static void main(String[] args) {
		ATM atm = new ATM();

		atm.start();
	}
}
