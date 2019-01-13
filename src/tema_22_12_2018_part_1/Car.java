package tema_22_12_2018_part_1;

public abstract class Car implements Vehicle {

	protected static int fuelTankSize;
	
	protected static String fuelType;
	
	protected static int gears;
	
	protected static float consumptionPer100Km;
	
	protected float availableFuel;
	
	protected int tireSize;
	
	protected String chassisNumber;
	
	protected int gear;
	
	protected float consumption;
	
	protected float drivenDistance;
	
	public Car (float availableFuel, String chassisNumber) {
		this.availableFuel = availableFuel;
		this.chassisNumber = chassisNumber;
	}
	public int getGear() {
		return gear;
	}
	
	public void setGear(int gear) {
		this.gear = gear;
	}

	public float getAvailableFuel() {
		return availableFuel;
	}
	
	public void setAvailableFuel(float availableFuel) {
		this.availableFuel = availableFuel;
	}
	
	public int getTireSize() {
		return tireSize;
	}
	
	public void setTireSize(int tireSize) {
		this.tireSize = tireSize;
	}
	
	public String getChassisNumber() {
		return chassisNumber;
	}
	
	public void shiftGear (int gear) {

		this.setGear(gear);
	}
	
	public float getAverageFuelConsumption() {
		return (100 * consumption) / drivenDistance;
	}
	
	public void start () {
		consumption = 0;
		gear = 0;
	}
	public void stop () {
		gear = 0;
	}
}
