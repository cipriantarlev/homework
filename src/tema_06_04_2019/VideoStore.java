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
	private Movie movie = new Movie();

	public Customer getCustomer() {
		return customer;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
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
				boolean again = true;
				while (again) {
					voidShowVideoStoreOptions();
					switch (scan.nextInt()) {
					case 1:
						System.out.println("Please enter a movie name: ");
						searchMovies(login);
						break;
					case 2:
						System.out.println("Please enter a new plan: ");
						changePlanID(login);
						break;
					case 3:
						System.out.println("Please find below the available plans: ");
						printAllPLans(getAllPlan());
						break;
					case 4:
						System.out.println("Please enter the movie that you want to rent: ");
						rentVideo(login, scan.next());
						break;
					case 5:
						quit(login);
						working = false;
						again = false;
						break;
					default:
						System.out.println("Please enter a valid command!");
						break;
					}
				}
			} else {
				System.out.println("Please enter a valid login:");
			}
		}

	}

	public void rentVideo (String login, String movieName) {
		insertRentalStatus(getCustomer(login).getCid(), getMovieByName(movieName).stream().map(a -> a.getId()).findFirst().get());
	}

	public void searchMovie(String login, String name) {
		printAllMovies(getMovieByName(name));
		printAllProducers(getProducerByMovieName(name));
		printAllActors(getActorByMovieName(name));
		System.out.println(getRentalStatusByMovieName(name));
	}

	
	public void printAllActors(List<Actor> actorList) {
		actorList.forEach(a -> System.out.println(a));
	}
	
	public void printAllProducers(List<Producer> producerList) {
		producerList.forEach(a -> System.out.println(a));
	}

	public void printAllPLans(List<Plan> planList) {
		planList.forEach(a -> System.out.println(a));
	}
	
	public void printAllMovies(List<Movie> movieList) {
		movieList.forEach(a -> System.out.println(a));
	}

	public void quit(String login) {
		System.out.println(
				"Have a good day Mr/Mrs " + getCustomer(login).getFirstName() + " " + getCustomer(login).getLastName());
	}
	
	private void searchMovies(String login) { 
		boolean again1 = true;
		while (again1) {
			String name = scan.next();
			if (getMovieByName(name).stream().anyMatch(a -> a.getName().equals(name))) {
				searchMovie(login, name);
				again1 = false;
			} else {
				System.out.println("You have entered a wrong movie name, please enter it again: ");
			}
		}
	}
	//check if Plan ID exist and modify it, 
		//if ID doesn't exist, it ask you to enter it again
	private void changePlanID(String login) { 
		boolean again1 = true;
		while (again1) {
			int planID = scan.nextInt();
			if (getAllPlan().stream().anyMatch(a -> a.getPlanId()==planID)) {
				changeClientPlanID(login, planID);
				again1 = false;
			} else {
				System.out.println("You have entered a wrong Plan ID, please enter it again: ");
			}
		}
	}
	
	private void insertRentalStatus(int cid, String movieId) {
		Rental ts = new Rental(cid, movieId, "closed", 2);
		try (Connection connection = getConnection()) {
			String update = "INSERT INTO rental (cid, movie_id, `status`,rented_times) SELECT * FROM (SELECT ?,?,?,?) AS tmp WHERE NOT EXISTS (SELECT movie_id FROM rental WHERE movie_id = ?) LIMIT 1";
			PreparedStatement ps = connection.prepareStatement(update);
			ps.setInt(1, ts.getCid());
			ps.setString(2, ts.getMovieID());
			ps.setString(3, ts.getStatus());
			ps.setInt(4, ts.getRentedTimes());
			ps.setString(5, movieId);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("There is no connection with DB");
			e.printStackTrace();
		}
	}
	
	private void changeClientPlanID(String login, int planID) {
		updateClientPlan(planID, getCustomer(login).getCid());
	}
	
	private Rental getRentalStatusByMovieName(String movieName) {
		Rental rental = new Rental();
		try (Connection connection = getConnection()) {
			String query = "SELECT rental.status FROM movie_info JOIN rental ON movie_info.movie_id=rental.movie_id WHERE movie_info.movie_name=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, movieName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				rental.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			System.out.println("There is no connection with DB");
		}
		return rental;
	}
	
	private List<Actor> getActorByMovieName(String movieName) {
		List<Actor> actorList = new ArrayList<>();
		try (Connection connection = getConnection()) {
			String query = "SELECT actor_ids.actor_name\r\n" + 
					"FROM movie_info\r\n" + 
					"JOIN actor_movies ON movie_info.movie_id=actor_movies.movie_id\r\n" + 
					"JOIN actor_ids ON actor_movies.actor_id=actor_ids.actor_id WHERE movie_info.movie_name=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, movieName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Actor actor = new Actor();
				actor.setName(rs.getString("actor_name"));
				actorList.add(actor);
			}
		} catch (SQLException e) {
			System.out.println("There is no connection with DB");
		}
		return actorList;
	}
	
	private List<Producer> getProducerByMovieName(String movieName) {
		List<Producer> producerList = new ArrayList<>();
		try (Connection connection = getConnection()) {
			String query = "SELECT producer_ids.producer_name FROM movie_info JOIN producer_movies ON movie_info.movie_id=producer_movies.movie_id JOIN producer_ids ON producer_movies.producer_id=producer_ids.producer_id WHERE movie_info.movie_name=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, movieName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Producer producer = new Producer();
				producer.setName(rs.getString("producer_name"));
				producerList.add(producer);
			}
		} catch (SQLException e) {
			System.out.println("There is no connection with DB");
		}
		return producerList;
	}

	private List<Movie> getMovieByName(String movieName) {
		List<Movie> movieList = new ArrayList<>();
		try (Connection connection = getConnection()) {
			String query = "select movie_id, movie_name from movie_info where movie_name= ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, movieName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				setMovie(new Movie(rs.getString(1), rs.getString(2)));
				movieList.add(getMovie());
			}
		} catch (SQLException e) {
			System.out.println("There is no connection with DB");
		}
		return movieList;
	}

	private void updateClientPlan(int planId, int cid) {
		try (Connection connection = getConnection()) {
			String update = "update customer set rental_plan = ? where cid = ?";
			PreparedStatement ps = connection.prepareStatement(update);
			ps.setInt(1, planId);
			ps.setInt(2, cid);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("There is no connection with DB");
		}

	}

	private List<Plan> getAllPlan() {
		List<Plan> planList = new ArrayList<>();
		try (Connection connection = getConnection()) {
			String query = "select * from plan";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Plan plan = new Plan();
				plan.setplanID(rs.getInt(1));
				plan.setName(rs.getString(2));
				plan.setMaxRentals(rs.getInt(3));
				plan.setMonthlyFee(rs.getInt(4));
				planList.add(plan);
			}
		} catch (SQLException e) {
			System.out.println("There is no connection with DB");
		}
		return planList;
	}

	private Customer getCustomer(String login) {
		try (Connection connection = getConnection()) {
			String query = "select * from customer where login= ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			rs.next();
			setCustomer(new Customer(rs.getInt(2), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(1)));
		} catch (SQLException e) {
			System.out.println("There is no connection with DB");
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
				+ "\n1) To find a movie\n2) To change a plan \n3) To show available plan \n4) To rent a movie \n5) To exit");
	}

	public static void main(String[] args) {
		new VideoStore().start();
	}
}
