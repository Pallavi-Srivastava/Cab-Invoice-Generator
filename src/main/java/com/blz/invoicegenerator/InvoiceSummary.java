package com.blz.invoicegenerator;

public class InvoiceSummary {

	@Override
	public String toString() {
		return "Invoice_Summary [totalNoOfRide=" + totalNoOfRide + ", fare=" + fare + ", avgFare=" + avgFare + "]";
	}

	public int totalNoOfRide;
	public double fare;
	public double avgFare;
	public boolean normalRide;

	public InvoiceSummary(int totalNoOfRide, double fare, boolean normalRide) {
		this.totalNoOfRide = totalNoOfRide;
		this.fare = fare;
		this.normalRide = normalRide;
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
		InvoiceSummary other = (InvoiceSummary) obj;
		if (Double.doubleToLongBits(fare) != Double.doubleToLongBits(other.fare))
			return false;
		if (totalNoOfRide != other.totalNoOfRide)
			return false;
		return true;
	}
}
