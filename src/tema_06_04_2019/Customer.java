package tema_06_04_2019;

public class Customer {

	private int cid;
	private String firstName;
	private String lastName;
	private int rentalPlan;
	private String login;
	
	public Customer(int cid, String firstName, String lastName, int rentalPlan, String login) {
		super();
		this.cid = cid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.rentalPlan = rentalPlan;
		this.login = login;
	}
	
	public int getCid() {
		return cid;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public int getRentalPlan() {
		return rentalPlan;
	}

	public String getLogin() {
		return login;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
	
	
}
