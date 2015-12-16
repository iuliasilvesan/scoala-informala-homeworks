package homework4;

/**
 * Intermediate between Motorcycle and Honda
 * 
 * @author iulia
 *
 */

public abstract class Honda extends Motorcycle {

	/**
	 * Constructor
	 * 
	 * @param availableFuel
	 *            is the available fuel
	 * @param chassisNumber
	 *            is the chassis number
	 * @param fuelTank
	 *            is the size of fuel tank
	 * @param fuelType
	 *            is the type of fuel
	 * @param numberOfGears
	 *            is the number of gears
	 * @param fuelConsumptionPerHundredKm
	 *            is the fuel consumption per 100 km
	 * @param pollutionPerKm
	 *            is the pollution per 1 km
	 */
	Honda(float availableFuel, String chassisNumber, float fuelTank, String fuelType, int numberOfGears,
			float fuelConsumptionPerHundredKm, float pollutionPerKm) {
		super(availableFuel, chassisNumber, fuelTank, fuelType, numberOfGears, fuelConsumptionPerHundredKm,
				pollutionPerKm);
	}

	abstract float calculateConsumption(float kilometersNumber, int gear);
}
