package tema_06_04_2019;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
				voidShowVideoStoreOptions();
				switch(scan.nextInt()) {
				case 1:
					System.out.println("Please enter a name of a movie: ");
					break;
				case 2:
					System.out.println("Please enter a new plan: ");
					getAllPlan();
					break;
				case 3:
					System.out.println("Please enter the movie that you want to rent: ");
					break;
				case 4:
					working = false;
					break;
				default:
					System.out.println("Please enter a valid command!");
					break;
				}
				
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

	private List<Plan> getAllPlan() {
		List<Plan> planList = new ArrayList<>();
		try (Connection connection = getConnection()){
			String query = "select * from plan";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Plan plan = new Plan();
				plan.setId(rs.getInt(1));
				plan.setName(rs.getString(2));	
				plan.setMaxRentals(3);
				plan.setMonthlyFee(4);
				planList.add(plan);
			}
		} catch (SQLException e) {
			System.out.println("This plan was not found!");
		}	
		showAllPlan(planList);
		return planList;
	}
	
	private void showAllPlan(List<Plan> planList) {
		planList.forEach(p -> System.out.println(p));
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
	
	private void voidShowVideoStoreOptions() {
		System.out.println(" \nWhat action would you like to perform?"
				+ "\n1) To find a movie\n2) To change a plan \n3) To rent a movie \n4) To exit");
	}

	public static void main(String[] args) {
		new VideoStore().start();
	}
}
