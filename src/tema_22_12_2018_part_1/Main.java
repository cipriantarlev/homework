package tema_22_12_2018_part_1;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Car impreza = new Impreza(27, "oiqe0924hkkadsn"); 
		Car forester = new Forester(35, "oiqe0934hkkadsn"); 
		Car modena = new Modena(40, "oiqe0994hkkadsn"); 
		Car monza = new Monza(41, "oiqe0734hkkadsn"); 

		List <Car> cars = new ArrayList<>();
		
		cars.add(impreza);
		cars.add(forester);
		cars.add(modena);
		cars.add(monza);
		
		for (Car car : cars) {
			car.start();

			car.shiftGear(1);

			car.drive(10.0f);

			car.shiftGear(2);

			car.drive(20.0f);

			car.shiftGear(3);

			car.drive(0.5f);

			car.shiftGear(4);

			car.drive(0.5f);

			car.shiftGear(5);

			car.drive(0.5f);

			car.shiftGear(8);

			car.drive(10f);

			car.shiftGear(4);

			car.drive(0.5f);

			car.shiftGear(3);

			car.drive(0.1f);

			car.stop();

			float availableFuel = car.getAvailableFuel();

			float fuleConsumedPer100Km = car.getAverageFuelConsumption();
			
			System.out.println(car.getClass().getName().split("\\.")[1]);
			System.out.println("Available fuel is: " + availableFuel);
			System.out.println("Average fuel is: " + fuleConsumedPer100Km);
			
		}	
	}

}
