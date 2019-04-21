package tema_06_04_2019;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ATMFromServer implements ATMInterfaceFromServer  {
	
	private Scanner scan = new Scanner(System.in);
	private BankAccountFromServer bankAccountFromServer;
	private double sold;
	private int id;
	
	public BankAccountFromServer getBankAccountFromServer() {
		return bankAccountFromServer;
	}
	
	public void setBankAccountFromServer(BankAccountFromServer bankAccountFromServer) {
		this.bankAccountFromServer = bankAccountFromServer;
	}
	
	public void start() {
		System.out.println("Good Day Sir, please enter you card number:");

		boolean again1 = true;
		while (again1) {
			String cardNumber = scan.nextLine();
			sold = getRecordFromDB(cardNumber).getSold();
			id = getRecordFromDB(cardNumber).getID();
			if (getRecordFromDB(cardNumber) != null) {
				System.out.println("Please enter your card pin: ");
				
				boolean again2 = true;
				while (again2) {
					if (getRecordFromDB(cardNumber).getPin() == scan.nextInt()) {

						System.out.print("Good day Mr/Mrs " + getRecordFromDB(cardNumber).getAccountOwner());
						boolean again = true;
						while (again) {
							showATMOptions();
							switch (scan.nextInt()) {
							case 1:
								System.out.println("Please enter the amount you want to deposit: ");
								deposit(cardNumber, scan.nextDouble());
								break;
							case 2:
								System.out.println("Please enter the amount you want to withdraw: ");
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
		sold = sold + money;
		getRecordFromDB(cardNumber).setSold(money);
		updateSold(sold, id);
	}

	public void withdraw(String cardNumber, double moneyForWithdraw) {
		sold = sold - moneyForWithdraw;
		getRecordFromDB(cardNumber).setSold(moneyForWithdraw);
		updateSold(sold,id);
	}

	public void changePin(String cardNumber, int pin) {
		getRecordFromDB(cardNumber).setPin(pin);
		updatePin(pin, id);
	}

	public double soldInterrogation(String cardNumber) {
		return getRecordFromDB(cardNumber).getSold();
	}

	public void editAccountInfo(String cardNumber, String firstName, String lastName) {
		getRecordFromDB(cardNumber).setAccountOwner(firstName + " " + lastName);
		updateAccountOwner(firstName + " " + lastName, id);
	}

	public void quit(String cardNumber) {
		System.out.println("Have a good day Mr/Mrs " + getRecordFromDB(cardNumber).getAccountOwner() + "!");
	}
	
	private void updateSold(double sold, int ID) {
		try(Connection connection = getConnection()){
			String update = "update bank_database set sold = ? where ID = ?";
			PreparedStatement ps = connection.prepareStatement(update);
			ps.setDouble(1, sold);
			ps.setInt(2, ID);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("There is not any database connected!");
		}
	}
	
	private void updateAccountOwner(String accountOwner, int ID) {
		try(Connection connection = getConnection()){
			String update = "update bank_database set accountOwner = ? where ID = ?";
			PreparedStatement ps = connection.prepareStatement(update);
			ps.setString(1, accountOwner);
			ps.setInt(2, ID);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("There is not any database connected!");
		}
	}
	
	private void updatePin(int pin, int ID) {
		try(Connection connection = getConnection()){
			String update = "update bank_database set pin = ? where ID = ?";
			PreparedStatement ps = connection.prepareStatement(update);
			ps.setInt(1, pin);
			ps.setInt(2, ID);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("There is not any database connected!");
		}
	}

	private BankAccountFromServer getRecordFromDB(String cardNumber) {
		try (Connection connection = getConnection()){
			String query = "select * from bank_database where cardNumber = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, cardNumber);
			ResultSet rs = ps.executeQuery();
			rs.next();
			setBankAccountFromServer(new BankAccountFromServer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5)));
		} catch (SQLException e) {
			System.out.println("This card number has been not found in our data base!");
		}
		return getBankAccountFromServer();
	}
	
	private void showATMOptions() {
		System.out.println(" \nWhat action would you like to perform?"
				+ "\n1) To deposit\n2) To withdraw\n3) To change pin \n4) To check your card balance"
				+ "\n5) To edit account information \n6) To exit");
	}

	private static Connection getConnection() {
		try {
			DriverManager.setLoginTimeout(10);
			return DriverManager.getConnection("jdbc:mysql://localhost/bank_db?useSSL=false", "root", "password");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("There is not any database connected!");
			return null;
		}
	}
	
	public static void main(String[] args) {
		// ATM atm = new ATM();
		new ATMFromServer().start();
	}
}
