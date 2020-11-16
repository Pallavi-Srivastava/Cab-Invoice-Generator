package com.blz.invoicegenerator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class InvoiceGeneratorTest {

	private static InvoiceGenerator invoiceGenerator;
	private static final double DELTA = 1e-15;

	@BeforeClass
	public static void createinvoiceGeneratorObj() {
		invoiceGenerator = new InvoiceGenerator();
		System.out.println("Welcome to the Cab Invoice Generator Program.. ");
	}

	@Test
	public void givenDistanceAndTime_shouldReturnCalculateFareForNormalRide() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculareFareForRideType(distance, time, true);
		Assert.assertEquals(25.0, fare, DELTA);
	}

	@Test
	public void givenDistanceAndTime_shouldReturnCalculatefalseFareForPremiumRide() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculareFareForRideType(distance, time, false);
		Assert.assertEquals(40.0, fare, DELTA);
	}

	@Test
	public void givenRides_shouldReturnInvoiceCostForNormalRide() {

		Ride[] rides = { new Ride(2.0, 5, true), new Ride(0.1, 1, true) };
		double fare = invoiceGenerator.calculareFareForMultipleRides(rides, true);
		Assert.assertEquals(30.0, fare, DELTA);
	}

	@Test
	public void givenRides_shouldReturnInvoiceCostForPremiumRide() {

		Ride[] rides = { new Ride(2.0, 5, false), new Ride(0.1, 1, false) };
		double fare = invoiceGenerator.calculareFareForMultipleRides(rides, false);
		Assert.assertEquals(60.0, fare, DELTA);
	}

	@Test
	public void givenMultipleRides_shouldReturnInvoiceSummaryForNormalRide() {
		Ride[] rides = { new Ride(2.0, 5, true), new Ride(0.1, 1, true) };
		InvoiceSummary actualSummary = invoiceGenerator.calculareFareSummary(rides, true);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0, true);
		Assert.assertEquals(expectedSummary, actualSummary);
	}

	@Test
	public void givenMultipleRides_shouldReturnInvoiceSummaryForPremiumRide() {
		Ride[] rides = { new Ride(2.0, 5, false), new Ride(0.1, 1, false) };
		InvoiceSummary actualSummary = invoiceGenerator.calculareFareSummary(rides, false);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 60.0, false);
		Assert.assertEquals(expectedSummary, actualSummary);
	}

	@Test
	public void givenUserId_shouldReturninvoiceSummaryListForNormalRide() {
		String userId = "abc@gmail.com";
		Ride[] rides = { new Ride(2.0, 5, true), new Ride(0.1, 1, true) };
		invoiceGenerator.addRides(userId, rides, true);
		Ride[] rides1 = { new Ride(2.0, 5, true), new Ride(0.1, 1, true) };
		invoiceGenerator.addRides(userId, rides1, true);
		InvoiceSummary actualSummary = invoiceGenerator.getInvoiceSummary(userId, true);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0, true);
		Assert.assertEquals(expectedSummary, actualSummary);
	}
}
