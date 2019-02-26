package tema_23_02_2019;

import java.util.*;

public class ATM implements ATMInterface {

	private Scanner scan = new Scanner(System.in);    // este ok sa creezi Scanner aici sau mai bine creez unul nou cand am nevoie?
	private Bank bank = new Bank();											 //Eu am creat aici unul si dupa il folosesc in metode.
													//
	public void start() {
		bank.initiateBankAccounts();

		System.out.println("Good Day Sir, please enter you card number:");

		boolean again1 = true;
		while (again1) {
			String cardNumber = scan.nextLine();
			if (bank.bankAccount.containsKey(cardNumber)) {
				System.out.print("Good day Mr/Mrs " + bank.bankAccount.get(cardNumber).getAccountOwner());

				boolean again = true;
				while (again) {
					System.out.println(" \nWhat action would you like to perform?"
							+ "\n1) To deposit\n2) To withdraw\n3) To change pin \n4) To check your card balance"
							+ "\n5) To edit account information \n6) To exit");
				
					String option = scan.next();
					switch (option) {
					case "1":
						this.deposit(cardNumber);
						break;
					case "2":
						this.withdraw(cardNumber);
						break;
					case "3":
						this.changePin(cardNumber);
						break;
					case "4":
						this.soldInterrogation(cardNumber);
						break;
					case "5":
						this.editAccountInfo(cardNumber);
						break;
					case "6":
						this.quit(cardNumber);
						again = false;
						again1 = false;
						break;
					default:
						System.out.println("Please enter a valid command!");
						break;
					}
				}
			} else {
				System.out.println("Please enter a valid card number!");
			}

		}
	}

	public void deposit(String cardNumber) {
		System.out.println("Please enter the amount you want to deposit: ");
		double money = scan.nextDouble();
		money = bank.bankAccount.get(cardNumber).getSold() + money;
		bank.bankAccount.get(cardNumber).setSold(money);
	}

	public void withdraw(String cardNumber) {
		System.out.println("Please enter the amount you want to withdraw: ");
		double money = scan.nextDouble();
		money = bank.bankAccount.get(cardNumber).getSold() - money;
		bank.bankAccount.get(cardNumber).setSold(money);
	}

	public void changePin(String cardNumber) {
		System.out.println("Please enter the PIN that you want to set: ");
		int pin = scan.nextInt();
		bank.bankAccount.get(cardNumber).setPin(pin);
	}

	public void soldInterrogation(String cardNumber) {
		System.out.println("Your card balance is: " + bank.bankAccount.get(cardNumber).getSold());
	}

	public void editAccountInfo(String cardNumber) {
		System.out.println("Please enter the new account owner: ");
		String firstName = scan.next();
		String lastName = scan.next();
		bank.bankAccount.get(cardNumber).setAccountOwner(firstName + " " + lastName);
	}

	public void quit(String cardNumber) {
		System.out.println("Have a good day Mr/Mrs " + bank.bankAccount.get(cardNumber).getAccountOwner() + "!");
	}

	public static void main(String[] args) {
		ATM atm = new ATM();

		atm.start();
	}
}
