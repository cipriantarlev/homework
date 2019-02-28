package tema_23_02_2019;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.*;

public class ATMTest {

	ATM engine = new ATM();
	Bank bank = new Bank();
	Map<String, BankAccount> bankAccounts = new HashMap<>();
	String cardNumber = "1234 2345 3456 4567";

	@Before
	public void startUp() {
		bank.bankAccounts.put(cardNumber, new BankAccount("Tarlev Ciprian", 0000, 1458));
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
		assertEquals(newPin, engine.getBank().bankAccounts.get(cardNumber).getPin());
	}

	@Test
	public void editAccountInfoTest() {
		String firstName = "Ion";
		String lastName = "Ionescu";
		engine.editAccountInfo(cardNumber, firstName, lastName);
		assertEquals("Ion Ionescu", engine.getBank().bankAccounts.get(cardNumber).getAccountOwner());
	}
}