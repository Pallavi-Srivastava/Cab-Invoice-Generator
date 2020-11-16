package com.blz.invoicegenerator;

public class Invoice_Summary {

	public int totalNoOfRide;
	public double fare;
	public double avgFare;

	public Invoice_Summary(int totalNoOfRide, double fare) {
		this.totalNoOfRide = totalNoOfRide;
		this.fare = fare;
		this.avgFare = this.totalNoOfRide / this.fare;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice_Summary other = (Invoice_Summary) obj;
		if (Double.doubleToLongBits(fare) != Double.doubleToLongBits(other.fare))
			return false;
		if (totalNoOfRide != other.totalNoOfRide)
			return false;
		return true;
	}
}
