package homework4;

/**
 * This is an interface which defines the expected behavior of any class which
 * implements it: - a vehicle can be started - a vehicle can be driven for a
 * given number of kilometers - a vehicle can be stopped
 * 
 * @author iulia
 */

public interface Vehicle {
	/*
	 * A car has to start.
	 */
	public void start();

	/*
	 * A car has to be driven for a number @param kilometersNumber number of
	 * kilometers.
	 */
	public void drive(float kilometersNumber);

	/*
	 * A car has to stop.
	 */
	public void stop();

}
