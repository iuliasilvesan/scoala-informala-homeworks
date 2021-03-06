package homework4;

/**
 * This class creates a Shadow type of object, with a fuel tank size of 30 ,
 * fuel type diesel,6 gears, consumption per 100 km of 3 and pollution per km of
 * 100.
 * 
 * @author iulia
 */

public class Shadow extends Honda {

	private final static float FUEL_TANK_SIZE = 30;
	private final static String FUEL_TYPE = "DIESEL";
	private final static int NUMBER_OF_GEARS = 6;
	private final static float CONSUMPTION_PER_HUNDRED_KM = 3;
	private final static float POLLUTION_PER_KM = 100;

	/**
	 * Constructor
	 * 
	 * @param availableFuel
	 *            available Fuel
	 * @param chassisNumber
	 *            chassis number
	 */
	public Shadow(float availableFuel, String chassisNumber) {
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
			fuelValue = 8.3f;
			break;
		case 3:
			fuelValue = 6.3f;
			break;
		case 4:
			fuelValue = 4.12f;
			break;
		case 5:
			fuelValue = 3.8f;
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
