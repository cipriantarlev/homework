package tema_22_12_2018_part_1;

public class Impreza extends Subaru {

	public Impreza(float availableFuel, String chassisNumber) {
		super(availableFuel, chassisNumber);
		fuelTankSize = 70;
		fuelType = "Petrol";
		consumptionPer100Km = 8.6f;
		tireSize = 18;
	}

	@Override
	public void drive(float distance) {
		drivenDistance += distance;
		float consumptionForCurrentDistance = (float)((consumptionPer100Km * distance * 0.01)*(1 + (gears-gear)* 0.1));
		availableFuel = availableFuel - consumptionForCurrentDistance;
		consumption += consumptionForCurrentDistance;
	}
}
