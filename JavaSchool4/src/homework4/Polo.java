package homework4;

/**
 * This class creates a Polo type of object, with a fuel tank size of 40, fuel
 * type diesel, 5 gears, consumption per 100 km of 5.3 and pollution per km of
 * 120.
 * 
 * @author iulia
 */

public class Polo extends VW {

	private final static float FUEL_TANK_SIZE = 40;
	private final static String FUEL_TYPE = "DIESEL";
	private final static int NUMBER_OF_GEARS = 5;
	private final static float CONSUMPTION_PER_HUNDRED_KM = 5.3f;
	private final static float POLLUTION_PER_KM = 120;

	/**
	 * Constructor
	 * 
	 * @param availableFuel
	 *            available Fuel
	 * @param chassisNumber
	 *            chassis number
	 */
	public Polo(float availableFuel, String chassisNumber) {
		super(availableFuel, chassisNumber, FUEL_TANK_SIZE, FUEL_TYPE, NUMBER_OF_GEARS, CONSUMPTION_PER_HUNDRED_KM,
				POLLUTION_PER_KM);
	}

	/**
	 * Algorithm for computing fuel per 100 km depending on gear
	 * 
	 * @param gear
	 * @return float
	 */
	float calculateFuelPerHundredKm(int gear) {

		float fuelValue;
		switch (gear) {
		case 0:
			fuelValue = 0.25f;
			break;
		case 1:
			fuelValue = 12f;
			break;
		case 2:
			fuelValue = 8;
			break;
		case 3:
			fuelValue = 6.5f;
			break;
		case 4:
			fuelValue = 6;
			break;
		case 5:
			fuelValue = 5;
			break;
		default:
			fuelValue = 1;
			break;
		}
		return fuelValue;
	}

	/**
	 * Calculates consumption as a formula between the consumption per 100km in
	 * the current gear and the number of km
	 * 
	 * @param kilometersNumber
	 * @param gear
	 */
	public float calculateConsumption(float kilometersNumber, int gear) {
		float consumption = calculateFuelPerHundredKm(this.getCurrentGear()) * kilometersNumber / 100;
		return consumption;
	}

}
