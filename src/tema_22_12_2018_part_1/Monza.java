package tema_22_12_2018_part_1;

public class Monza extends Ferrari {

	public Monza (float availableFuel, String chassisNumber) {
		super(availableFuel, chassisNumber);
		fuelTankSize = 50;
		fuelType = "Petrol";
		consumptionPer100Km = 11.7f;
		tireSize = 19;
	}

	@Override
	public void drive(float distance) {
		drivenDistance += distance;
		float consumptionForCurrentDistance = (float)((consumptionPer100Km * distance * 0.01)*(1 + (gears-gear)* 0.19));
		availableFuel = availableFuel - consumptionForCurrentDistance;
		consumption += consumptionForCurrentDistance;
	}

}
