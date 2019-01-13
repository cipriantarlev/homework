package tema_22_12_2018_part_1;

public abstract class Subaru extends Car {
	
	public Subaru(float availableFuel, String chassisNumber) {
		super(availableFuel, chassisNumber);
		gears = 6;
	}
}
