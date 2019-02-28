package tema_23_02_2019;

public interface ATMInterface {
	
	public void start();
	public void deposit(String cardNumber, double money);
	public void withdraw(String cardNumber, double money);
	public void changePin(String cardNumber, int pin);
	public double soldInterrogation(String cardNumber);
	public void editAccountInfo(String cardNumber, String firstName, String lastName);
	public void quit(String cardNumber);
}
