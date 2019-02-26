package tema_23_02_2019;

public interface ATMInterface {
	
	public void start();
	public void deposit(String cardNumber);
	public void withdraw(String cardNumber);
	public void changePin(String cardNumber);
	public void soldInterrogation(String cardNumber);
	public void editAccountInfo(String cardNumber);
	public void quit(String cardNumber);
}
