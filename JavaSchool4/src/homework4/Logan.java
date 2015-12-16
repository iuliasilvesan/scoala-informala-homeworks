package homework4;

/**
 * This class creates a Logan type of object, with a fuel tank size of 45, fuel
 * type petrol, 4 gears, consumption per 100 km of 3.5 and pollution per km of
 * 132.
 * 
 * @author iulia
 *
 */

public class Logan extends Dacia {
	private final static float FUEL_TANK_SIZE = 45;
	private final static String FUEL_TYPE = "PETROL";
	private final static int NUMBER_OF_GEARS = 4;
	private final static float CONSUMPTION_PER_HUNDRED_KM = 3.50f;
	private final static float POLLUTION_PER_KM = 132;

	/**
	 * Constructor
	 * 
	 * @param availableFuel
	 *            available Fuel
	 * @param chassisNumber
	 *            chassis number
	 */
	public Logan(float availableFuel, String chassisNumber) {
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
			fuelValue = 0.3f;
			break;
		case 1:
			fuelValue = 9.74f;
			break;
		case 2:
			fuelValue = 8.12f;
			break;
		case 3:
			fuelValue = 6.78f;
			break;
		case 4:
			fuelValue = 5.64f;
			break;
		case 5:
			fuelValue = 4.7f;
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
