package com.blz.invoicegenerator;

public class InvoiceService {

	private static final double Min_Cost_Per_KiloMeter = 10;
	private static final int Cost_per_Time = 1;
	private static final double Minimum_Fare = 5;
	private RideRepository rideRepository;

	public InvoiceService() {
		super();
		this.rideRepository = new RideRepository();
	}

	public double calculareFare(double distance, double time) {
		double cost = distance * Min_Cost_Per_KiloMeter + time * Cost_per_Time;
		if (cost < Minimum_Fare)
			return Minimum_Fare;
		return cost;
	}

	public double calculareFareForMultipleRides(Ride[] rides) {
		double cost = 0;
		for (Ride ride : rides) {
			cost = cost + this.calculareFare(ride.distance, ride.time);
		}
		return cost;
	}

	public Invoice_Summary calculareFareSummary(Ride[] rides) {
		double cost = 0;
		for (Ride ride : rides) {
			cost = cost + this.calculareFare(ride.distance, ride.time);
		}
		return new Invoice_Summary(rides.length, cost);
	}

	public Invoice_Summary getInvoiceSummary(String userId) {
		return this.calculareFareSummary(rideRepository.getRides(userId));
	}

	public void addRides(String userId, Ride[] rides) {
		rideRepository.addRides(userId, rides);
	}
}
