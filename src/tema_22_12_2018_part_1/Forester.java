package tema_22_12_2018_part_1;

public class Forester extends Subaru {

	public Forester(float availableFuel, String chassisNumber) {
		super(availableFuel, chassisNumber);
		fuelTankSize = 80;
		fuelType = "Diesel";
		consumptionPer100Km = 7.4f;
		tireSize = 17;
	}

	@Override
	public void drive(float distance) {
		drivenDistance += distance;
		float consumptionForCurrentDistance = (float)((consumptionPer100Km * distance * 0.01)*(1 + (gears-gear)* 0.15));
		availableFuel = availableFuel - consumptionForCurrentDistance;
		consumption += consumptionForCurrentDistance;
	}
}
