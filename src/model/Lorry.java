package model;

public class Lorry extends Vehicle {
	private double loadingCapacity;

	public Lorry(String model, int topSpeed, String registrationNumber, double dailyHireRate, double loadingCapacity) {
		super(model, topSpeed, registrationNumber, dailyHireRate);
		this.loadingCapacity = loadingCapacity;
	}

	public double getLoadingCapacity() {
		return loadingCapacity;
	}

	public void setLoadingCapacity(double loadingCapacity) {
		this.loadingCapacity = loadingCapacity;
	}
}