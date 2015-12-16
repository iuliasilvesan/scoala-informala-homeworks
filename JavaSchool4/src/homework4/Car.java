package homework4;

/**
 * Creates Car objects which have the following characteristics: A car has a
 * fuel tank of a predefined size. A car has a fuel type of a predefined type
 * (e.g PETROL, DIESEL, HYBRID, ELECTRIC). A car has a given number of gears.
 * The maximum is 6. A car has a predefined consumption of fuel per 100kms. A
 * car has a predefined pollution per km. The following values will be
 * configured from outside of the class: A car must be set up with a current
 * fuel amount. A car must be set up with a chassis number. Class Car implements
 * interface Vehicle and it adds to it behavior the following: The gear can be
 * changed. The consumption of fuel for a given number of kilometers in a given
 * gear will be implemented by all the children.
 */

abstract public class Car implements Vehicle {
	/** size of fuel tank */
	protected final float fuelTank;
	/** type of fuel */
	protected final String fuelType;
	/** number of gears */
	protected final int numberOfGears;
	/** fuel consumption in 100km */
	protected final float fuelConsumptionPerHundredKm;
	/** pollution per 1 km */
	protected final float pollutionPerKm;
	/** Maximum number of gears is a constant with the value 6 */
	protected final static int MAX_NUMBER_OF_GEAR = 6;

	private float availableFuel;
	private String chassisNumber;

	private float currentConsumption;
	private float pollution;

	private int currentGear;
	private float currentNoOfKm;

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
	Car(float availableFuel, String chassisNumber, float fuelTank, String fuelType, int numberOfGears,
			float fuelConsumptionPerHundredKm, float pollutionPerKm) throws IllegalArgumentException {
		this.availableFuel = availableFuel;
		this.chassisNumber = chassisNumber;
		this.fuelTank = fuelTank;
		this.fuelType = fuelType;
		this.numberOfGears = numberOfGears;
		this.fuelConsumptionPerHundredKm = fuelConsumptionPerHundredKm;
		this.pollutionPerKm = pollutionPerKm;

		if (this.availableFuel > this.fuelTank) {
			throw new IllegalArgumentException("Too much fuel, for the tank size!");
		}
	}

	/**
	 * Returns the available fuel
	 * 
	 * @return float
	 */
	public float getAvailableFuel() {
		return availableFuel;
	}

	/**
	 * Sets the available fuel
	 * 
	 * @param availableFuel
	 */
	public void setAvailableFuel(float availableFuel) {
		this.availableFuel = availableFuel;
	}

	/**
	 * Returns the current consumption
	 * 
	 * @return float
	 */
	public float getCurrentConsumption() {
		return currentConsumption;
	}

	private void setCurrentConsumption(float currentConsumption) {
		this.currentConsumption = currentConsumption;
	}

	/**
	 * Returns the current pollution
	 * 
	 * @return float
	 */
	public float getPollution() {
		return pollution;
	}

	private void setPollution(float pollution) {
		this.pollution = pollution;
	}

	/**
	 * Return the current gear
	 * 
	 * @return int
	 */
	public int getCurrentGear() {
		return currentGear;
	}

	/**
	 * Sets the current gear
	 * 
	 * @param currentGear
	 */
	public void setCurrentGear(int currentGear) {
		this.currentGear = currentGear;
	}

	/**
	 * Returns the current number of kilometers.
	 * 
	 * @return float
	 */
	public float getCurrentNoOfKm() {
		return currentNoOfKm;
	}

	private void setCurrentNoOfKm(float currentNoOfKm) {
		this.currentNoOfKm = currentNoOfKm;
	}

	// updates the value of available fuel by decreasing the current consumption
	private void updateAvailableFuelAmount() {
		float fuel = this.availableFuel - this.getCurrentConsumption();
		this.setAvailableFuel(fuel);
	}

	/**
	 * Method designed to start the car
	 */
	// Current consumption, pollution and current number of km are set to 0.
	public void start() throws IllegalArgumentException {
		System.out.println("Starting car with available fuel " + this.getAvailableFuel());
		this.setCurrentConsumption(0);
		this.setPollution(0);
		this.setCurrentNoOfKm(0);
		if (this.getCurrentGear() > 1) {
			throw new IllegalArgumentException("Bad gear for starting the car!");
		}
	}

	/**
	 * Method designed to change the gear with the value of @param gear.
	 * 
	 * @param gear
	 */
	public void shiftGear(int gear) throws IllegalArgumentException {
		this.currentGear = gear;
		if (gear > MAX_NUMBER_OF_GEAR) {
			throw new IllegalArgumentException("This gear is impossible!");
		}
	}

	/**
	 * Returns the average fuel consumption as a ratio between the current
	 * consumption and the current number of km.
	 * 
	 * @return float
	 */
	protected float getAverageFuelConsumption() {
		float averageFuelConsumption = this.getCurrentConsumption() / this.getCurrentNoOfKm() * 100;
		return averageFuelConsumption;
	}

	/**
	 * Method designed for stopping the car Will obtain the consumption and
	 * pollution when car is stopped.
	 */
	public void stop() {
		updateAvailableFuelAmount();
		this.setPollution(pollutionPerKm);
	}

	/**
	 * This method updates the level of consumption and the number of kilometers
	 * driven. These will then be used for computing average fuel consumption.
	 * 
	 * @param numberofKilometers
	 *            Number of kilometers
	 */
	public void drive(float numberOfKilometers) {
		float consumption = this.getCurrentConsumption()
				+ calculateConsumption(numberOfKilometers, this.getCurrentGear());
		this.setCurrentConsumption(consumption);
		float km = this.getCurrentNoOfKm() + numberOfKilometers;
		this.setCurrentNoOfKm(km);
	}

	/**
	 * Calculates the consumption based on number of kilometers and gear
	 * 
	 * @param kilometersNumber
	 * @param gear
	 * @return float
	 */
	abstract float calculateConsumption(float kilometersNumber, int gear);

}