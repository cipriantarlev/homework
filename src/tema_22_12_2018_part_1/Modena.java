package tema_22_12_2018_part_1;

public class Modena extends Ferrari {

	public Modena (float availableFuel, String chassisNumber) {
		super(availableFuel, chassisNumber);
		fuelTankSize = 60;
		fuelType = "Petrol";
		consumptionPer100Km = 12.8f;
		tireSize = 20;
	}

	@Override
	public void drive(float distance) {
		drivenDistance += distance;
		float consumptionForCurrentDistance = (float)((consumptionPer100Km * distance * 0.01)*(1 + (gears-gear)* 0.24));
		availableFuel = availableFuel - consumptionForCurrentDistance;
		consumption += consumptionForCurrentDistance;
	}

}
