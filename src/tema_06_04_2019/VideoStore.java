package tema_06_04_2019;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class VideoStore {

	private Scanner scan = new Scanner(System.in);
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void start() {
		System.out.println("Good Day Sir, please enter you login:");

		boolean working = true;
		while (working) {
			String login = scan.nextLine();
			if (getCustomer(login) != null) {
				System.out.println("Good day Mr/Mrs " + getCustomer(login).toString());
				
				
			}else {
				System.out.println("Please enter a valid login:");
			}
		}

	}

	public void search(String name) {

	}

	public void changeClientPlan(String planId) {

	}

	public void rentVideo() {

	}

	private Customer getCustomer(String login) {
		try (Connection connection = getConnection()) {
			String query = "select * from customer where login= ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			rs.next();
			setCustomer(new Customer(rs.getString(2), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(1)));
		} catch (SQLException e) {
			System.out.println("This login has been not found!");
		}
		return getCustomer(); 
	}

	private Connection getConnection() {
		DriverManager.setLoginTimeout(10);
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/movie?useSSL=false", "root", "password");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("There is not any database connected!");
			return null;
		}
	}

	public static void main(String[] args) {
		new VideoStore().start();
	}
}
