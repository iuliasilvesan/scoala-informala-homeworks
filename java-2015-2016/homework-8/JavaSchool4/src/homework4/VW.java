package homework4;

/**
 * Intermediate between Car and Golf/Polo
 * 
 * @author iulia
 *
 */
public abstract class VW extends Car {

	VW(float availableFuel, String chassisNumber, float fuelTank, String fuelType, int numberOfGears,
			float fuelConsumptionPerHundredKm, float pollutionPerKm) {
		super(availableFuel, chassisNumber, fuelTank, fuelType, numberOfGears, fuelConsumptionPerHundredKm,
				pollutionPerKm);
	}

	abstract float calculateConsumption(float kilometersNumber, int gear);
}
