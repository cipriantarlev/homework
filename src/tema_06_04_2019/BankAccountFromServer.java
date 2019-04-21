package tema_06_04_2019;

public class BankAccountFromServer {
	
	private int ID;
	private String cardNumber;
	private int pin;
	private double sold;
	private String accountOwner;
	
	public BankAccountFromServer(int ID, String cardNumber, String accountOwner, int pin, double sold) {
		super();
		this.ID = ID;
		this.cardNumber = cardNumber;
		this.pin = pin;
		this.sold = sold;
		this.accountOwner = accountOwner;
	}
	
	public int getID() {
		return ID;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public double getSold() {
		return sold;
	}

	public void setSold(double sold) {
		this.sold = sold;
	}

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	@Override
	public String toString() {
		return "BankAccountFromMYSQLServer [ID=" + ID + ", cardNumber=" + cardNumber + ", pin=" + pin + ", sold=" + sold
				+ ", accountOwner=" + accountOwner + "]";
	}
}
