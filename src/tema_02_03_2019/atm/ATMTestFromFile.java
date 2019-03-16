package tema_02_03_2019.atm;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.*;

public class ATMTestFromFile {

	ATMFromFile engine = new ATMFromFile();
	BankFromFile bank = new BankFromFile();
	Map<String, BankAccountFromFile> bankAccounts = new HashMap<>();
	String cardNumber = "1234 2345 3456 4567";

	@Before
	public void startUp() {
		bank.getBankAccounts().put(cardNumber, new BankAccountFromFile("Tarlev Ciprian", 0000, 1458));
		engine.setBank(bank);
	}

	@Test
	public void depostiTest() {
		double moneyForDeposit = 2;
		double soldMoney = 1458;
		engine.deposit(cardNumber, moneyForDeposit);
		assertEquals(soldMoney + moneyForDeposit, engine.soldInterrogation(cardNumber), 0.0);
	}

	@Test
	public void withdrawTest() {
		double moneyForDeposit = 2;
		double soldMoney = 1458;
		engine.withdraw(cardNumber, moneyForDeposit);
		assertEquals(soldMoney - moneyForDeposit, engine.soldInterrogation(cardNumber), 0.0);
	}

	@Test
	public void changePinTest() {
		int newPin = 1111;
		engine.changePin(cardNumber, newPin);
		assertEquals(newPin, engine.getBank().getBankAccounts().get(cardNumber).getPin());
	}

	@Test
	public void editAccountInfoTest() {
		String firstName = "Ion";
		String lastName = "Ionescu";
		engine.editAccountInfo(cardNumber, firstName, lastName);
		assertEquals("Ion Ionescu", engine.getBank().getBankAccounts().get(cardNumber).getAccountOwner());
	}
}