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
		double time = 5.0;
		double fare = invoiceGenerator.calculareFare(distance, time);
		Assert.assertEquals(25.0, fare, DELTA);
	}

	@Test
	public void givenLessDistanceAndTime_shouldReturn_MinimumCalculateFare() {
		double distance = 0.1;
		double time = 1;
		double fare = invoiceGenerator.calculareFare(distance, time);
		Assert.assertEquals(5, fare, DELTA);
	}
}
