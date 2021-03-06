package tema_23_02_2019;

import java.util.*;

public class ATM implements ATMInterface {
	// este ok sa creezi Scanner aici sau mai bine creez unul nou cand am nevoie?
	// R: e foarte bine
	private Scanner scan = new Scanner(System.in);
	private Bank bank = new Bank();

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public void start() {
		bank.initiateBankAccounts();
		System.out.println("Good Day Sir, please enter you card number:");

		boolean again1 = true;
		while (again1) {
			String cardNumber = scan.nextLine();

			if (bank.getBankAccounts().containsKey(cardNumber)) {
				System.out.println("Please enter your card pin: ");
				boolean again2 = true;
				while (again2) {
					if (getOwnerBankAccount(cardNumber).getPin() == scan.nextInt()) {

						System.out.print("Good day Mr/Mrs " + getOwnerBankAccount(cardNumber).getAccountOwner());
						boolean again = true;
						while (again) {
							// e mult text aici, ca sa tinem metoda start cat mai mica, il extragem si pe el
							// intr-o metoda separata
							showATMOptions();

							// String option = scan.next(); //TODO iti sugerez sa folosesti direct int pt
							// optiuni, e mai rapid decat String // Done!
							switch (scan.nextInt()) {
							case 1:
								System.out.println("Please enter the amount you want to deposit: ");
								// double moneyForDepost = scan.nextDouble();
								// TODO nu e nevoie de this neaparat, va spuneam ca il puteti omite cand nu
								// exista name clash // Done!
								deposit(cardNumber, scan.nextDouble());
								break;
							case 2:
								System.out.println("Please enter the amount you want to withdraw: ");
								// nu e necesara variabila moneyForWithdraw pt ca nu folosesti valoarea ei
								// decato singura data
								// iar in cazul asta poti pune direct apelul de metoda
								withdraw(cardNumber, scan.nextDouble());
								break;
							case 3:
								System.out.println("Please enter the PIN that you want to set: ");
								changePin(cardNumber, scan.nextInt());
								break;
							case 4:
								System.out.println("Your card balance is: " + soldInterrogation(cardNumber));

								break;
							case 5:
								System.out.println("Please enter the new account owner: ");
								editAccountInfo(cardNumber, scan.next(), scan.next());
								break;
							case 6:
								quit(cardNumber);
								again = false;
								again1 = false;
								again2 = false;
								break;
							default:
								System.out.println("Please enter a valid command!");
								break;
							}
						}
					} else {
						System.out.println("Please enter a valid pin!");
					}
				}
			} else {
				System.out.println("Please enter a valid card number!");
			}

		}
	}

	public void deposit(String cardNumber, double money) {
		// bank.getBankAccounts().get(cardNumber) apelul asta inlantuit se tot repeta in
		// mai multe metode, cand se intampla asta il poti extrage intr-o metoda
		// separata
		money = getOwnerBankAccount(cardNumber).getSold() + money;
		getOwnerBankAccount(cardNumber).setSold(money);
	}

	public void withdraw(String cardNumber, double moneyForWithdraw) {
		moneyForWithdraw = getOwnerBankAccount(cardNumber).getSold() - moneyForWithdraw;
		// TODO folosim getter pt getBankAccounts()
		getOwnerBankAccount(cardNumber).setSold(moneyForWithdraw);
	}

	public void changePin(String cardNumber, int pin) {
		getOwnerBankAccount(cardNumber).setPin(pin);
	}

	public double soldInterrogation(String cardNumber) {
		return getOwnerBankAccount(cardNumber).getSold();
	}

	public void editAccountInfo(String cardNumber, String firstName, String lastName) {
		getOwnerBankAccount(cardNumber).setAccountOwner(firstName + " " + lastName);
	}

	public void quit(String cardNumber) {
		System.out.println("Have a good day Mr/Mrs " + getOwnerBankAccount(cardNumber).getAccountOwner() + "!");
	}

	private void showATMOptions() {
		System.out.println(" \nWhat action would you like to perform?"
				+ "\n1) To deposit\n2) To withdraw\n3) To change pin \n4) To check your card balance"
				+ "\n5) To edit account information \n6) To exit");
	}

	private BankAccount getOwnerBankAccount(String cardNumber) {
		return bank.getBankAccounts().get(cardNumber);
	}

	public static void main(String[] args) {
		// ATM atm = new ATM();
		new ATM().start();
	}

}
