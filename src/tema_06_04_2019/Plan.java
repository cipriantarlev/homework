package tema_06_04_2019;

public class Plan {

	private int planID;
	private String name;
	private int maxRentals;
	private int monthlyFee;
	
	public int getPlanId() {
		return planID;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMaxRentals() {
		return maxRentals;
	}
	public int getMonthlyFee() {
		return monthlyFee;
	}

	public void setplanID(int planID) {
		this.planID = planID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMaxRentals(int maxRentals) {
		this.maxRentals = maxRentals;
	}

	public void setMonthlyFee(int monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	@Override
	public String toString() {
		return "Plan name is " + name + ", you can rent a movie " + maxRentals + " times and the fee is " + monthlyFee;
	}
	
	
}
