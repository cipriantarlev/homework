package tema_06_04_2019;

import lombok.Data;

@Data
public class Plan {

	private String id;
	private String name;
	private int maxRentals;
	private int monthlyFee;
	
	public String getId() {
		return id;
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
}
