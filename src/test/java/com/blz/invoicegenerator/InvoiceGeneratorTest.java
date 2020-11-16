package com.blz.invoicegenerator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class InvoiceGeneratorTest {

	private static InvoiceGenerator invoiceGenerator;
	private static final double DELTA = 1e-15;

	@BeforeClass
	public static void createInvoiceGeneratorObj() {
		invoiceGenerator = new InvoiceGenerator();
		System.out.println("Welcome to the Cab Invoice Generator Program.. ");
	}

	@Test
	public void givenDistanceAndTime_shouldReturn_CalculateFare() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculareFare(distance, time);
		Assert.assertEquals(25.0, fare, DELTA);
	}

	@Test
	public void givenLessDistanceAndTime_shouldReturn_MinimumCalculateFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculareFare(distance, time);
		Assert.assertEquals(5.0, fare, DELTA);
	}

	@Test
	public void givenMultipleRides_shouldReturn_invoiceCost() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		double fare = invoiceGenerator.calculareFareForMultipleRides(rides);
		Assert.assertEquals(30.0, fare, DELTA);
	}

	@Test
	public void givenMultipleRides_shouldReturn_invoiceSummary() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		Invoice_Summary actualSummary = invoiceGenerator.calculareFareSummary(rides);
		Invoice_Summary expectedSummary = new Invoice_Summary(2, 30.0);
		Assert.assertEquals(expectedSummary, actualSummary);
	}
}
