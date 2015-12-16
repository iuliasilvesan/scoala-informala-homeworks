package homework4;

/**
 * This class creates a ParkingTicket object which holds a pair representing the
 * parking spot ID (ticketID) and the vehicle that parks at that parking spot.
 * 
 * @author iulia
 *
 * @param <K>
 *            the parking spot ID
 * @param <T>
 *            the vehicle that parks at ticketID parking spot
 */

public class ParkingTicket<K, T extends Vehicle> {

	private K parkingSpotID;
	private T vehicle;

	/**
	 * Constructor
	 * 
	 * @param parkingSpotID
	 *            the parking spot ID
	 * @param vehicle
	 *            vehicle from the parking spot ID
	 */

	public ParkingTicket(K parkingSpotID, T vehicle) {
		this.parkingSpotID = parkingSpotID;
		this.vehicle = vehicle;
	}

	/**
	 * Returns the parking spot ID
	 * 
	 * @return generic type K
	 */
	public K getParkingSpotID() {
		return parkingSpotID;
	}

	/**
	 * Returns the vehicle
	 * 
	 * @return generic type T
	 */
	public T getVehicle() {
		return vehicle;
	}

	/**
	 * Prints the ParkingTicket object
	 */
	public String toString() {
		return "ParkingTicket [parkingSpotID=" + parkingSpotID + ", vehicle=" + vehicle + "]";
	}

}