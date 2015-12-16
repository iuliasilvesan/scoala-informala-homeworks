package homework4;

/**
 * This class is created for testing.
 * 
 * @author iulia
 *
 */
public class CarApplication {

	public static void main(String[] args) {
	
		ValletParking<Car> carPark = new ValletParking<Car>();
		Car car = new Golf(35, "Golf chassis number");
		float amountOfFuelBeforeParking = car.getAvailableFuel();
		System.out.println("Fuel before parking: " +amountOfFuelBeforeParking );
		ParkingTicket<Integer,Car> ticket = carPark.parkVehicle(car);
		
		car = carPark.retrieveVehicle(ticket);
		float amountOfFuelAfterParking = car.getAvailableFuel();
		System.out.println("Fuel after parking: "+ amountOfFuelAfterParking);

		System.out.println("Testing Motorcycle");
		ValletParking<Motorcycle> motorPark = new ValletParking<Motorcycle>();
		Motorcycle motorcycle = new Shadow(20, "Honda chassis number");
		float amountOfFuelBeforeParkingMotor = motorcycle.getAvailableFuel();
		System.out.println("Fuel before parking motor: "+ amountOfFuelBeforeParkingMotor);
		ParkingTicket<Integer,Motorcycle> ticketForMotor = motorPark.parkVehicle(motorcycle);
	
		motorcycle = motorPark.retrieveVehicle(ticketForMotor);
		float amountOfFuelAfterParkingMotor = motorcycle.getAvailableFuel();
		System.out.println("Fuel after parking: "+amountOfFuelAfterParkingMotor);

	}

}
