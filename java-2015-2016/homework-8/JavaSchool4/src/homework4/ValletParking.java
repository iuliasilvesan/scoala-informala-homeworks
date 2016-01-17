package homework4;
/**
 * This class designs a vallet parking with a fixed size of 
 * 100 parking spots.
 * A vallet parking class should work only with classes that are 
 * of type Vehicle.
 * When vehicle goes in, the vallet gives you ticket and drives your car to an empty spot. 
 * That could be on the 5th floor of the parking lot.
 * When vehicle goes out, the vallet checks your ticket and finds your car according to it, and drives it back to you.
 */

import java.util.*;

public class ValletParking<T extends Vehicle> {

	private final static int PARKING_SIZE = 100;
	// creates the park as an array with a fixed dimension given by
	// the value of PARKING_SIZE
	private Vehicle park[] = new Vehicle[PARKING_SIZE];// TODO CODE REVIEW: Why not T park[]?

	/**
	 * This method is created to park the vehicle in an empty parking spot and
	 * return the ticket corresponding to this action. The vehicle will be
	 * parked in a random empty parking spot.
	 * 
	 * @param vehicle
	 *            vehicle to be parked
	 * @return ParkingTicket
	 */
	public ParkingTicket<Integer, T> parkVehicle(T vehicle) {

		boolean check = true;
		int parkingSpot = 0;

		while (check) {
			// find the next empty parking spot
			Random random = new Random();
			parkingSpot = random.nextInt(100);
			if ((park[parkingSpot]) == null) {

				park[parkingSpot] = vehicle;
				check = false;
			}
		}
		// Computes the kilometers a vehicle needs to drive to
		// parking spot as the parkingSpot divided by 10.
		float kilometersNumber = parkingSpot / 10;
		System.out.println("Until the parking spot " + parkingSpot + " the vallet needs to drive " + kilometersNumber
				+ " kilometers");
		vehicle.start();
		vehicle.drive(kilometersNumber);
		vehicle.stop();

		ParkingTicket<Integer, T> ticket = new ParkingTicket<Integer,T>(parkingSpot, vehicle);
		return ticket;

	}

	/**
	 * The method returns the vehicle that corresponds to a ticket given as
	 * input
	 * 
	 * @param ticket
	 * @return T
	 */
	public T retrieveVehicle(ParkingTicket<Integer, T> ticket) {
		Integer ticketIndex = ticket.getParkingSpotID();
		T vehicle = ticket.getVehicle();
		// Computes the kilometers a vehicle needs to drive from
		// parking spot as the parkingSpot divided by 10.
		float kilometersNumber = ticketIndex / 10;
		vehicle.start();
		vehicle.drive(kilometersNumber);
		vehicle.stop();
		park[ticketIndex]=null;  //empty the spot in the parking

		return vehicle;
	}

}
