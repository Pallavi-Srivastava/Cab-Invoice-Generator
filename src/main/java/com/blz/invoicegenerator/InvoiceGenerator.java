package com.blz.invoicegenerator;

public class InvoiceGenerator {

	private static final double Min_Cost_Per_KiloMeter = 10;
	private static final double Cost_per_Time = 1;
	private static final double Minimum_Fare = 5;

	public double calculareFare(double distance, double time) {
		double cost = distance * Min_Cost_Per_KiloMeter + time * Cost_per_Time;
		if (cost < Minimum_Fare)
			return Minimum_Fare;
		return cost;
	}
}
