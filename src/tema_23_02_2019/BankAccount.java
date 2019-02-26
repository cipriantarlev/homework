package tema_23_02_2019;

public class BankAccount {
	
	private int pin;
	private double sold;
	private String accountOwner;
	
	public BankAccount( String accountOwner, int pin, double sold) {
		super();
		this.pin = pin;
		this.sold = sold;
		this.accountOwner = accountOwner;
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
		return "BankAccount [pin=" + pin + ", sold=" + sold + ", accountOwner=" + accountOwner + "]";
	}
}
