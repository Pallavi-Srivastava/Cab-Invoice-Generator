package com.blz.invoicegenerator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class InvoiceServiceTest {

	private static InvoiceService invoiceService;
	private static final double DELTA = 1e-15;

	@BeforeClass
	public static void createinvoiceServiceObj() {
		invoiceService = new InvoiceService();
		System.out.println("Welcome to the Cab Invoice Generator Program.. ");
	}

	@Test
	public void givenDistanceAndTime_shouldReturn_CalculateFare() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceService.calculareFare(distance, time);
		Assert.assertEquals(25.0, fare, DELTA);
	}

	@Test
	public void givenLessDistanceAndTime_shouldReturn_MinimumCalculateFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceService.calculareFare(distance, time);
		Assert.assertEquals(5.0, fare, DELTA);
	}

	@Test
	public void givenMultipleRides_shouldReturn_invoiceCost() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		double fare = invoiceService.calculareFareForMultipleRides(rides);
		Assert.assertEquals(30.0, fare, DELTA);
	}

	@Test
	public void givenMultipleRides_shouldReturn_invoiceSummary() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		Invoice_Summary actualSummary = invoiceService.calculareFareSummary(rides);
		Invoice_Summary expectedSummary = new Invoice_Summary(2, 30.0);
		Assert.assertEquals(expectedSummary, actualSummary);
	}

	@Test
	public void givenUserId_shouldReturn_invoiceSummaryList() {
		String userId = "abc@gmail.com";
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		invoiceService.addRides(userId, rides);
		Invoice_Summary actualSummary = invoiceService.getInvoiceSummary(userId);
		Invoice_Summary expectedSummary = new Invoice_Summary(2, 30.0);
		Assert.assertEquals(expectedSummary, actualSummary);
	}
}
