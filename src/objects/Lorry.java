package objects;

public class Lorry extends Vehicle {
	private double loadingCapacity;

	public Lorry(int id, String model, int topSpeed, String registrationNumber, double dailyHireRate,
			double loadingCapacity) {
		super(id, model, topSpeed, registrationNumber, dailyHireRate);
		this.loadingCapacity = loadingCapacity;
	}

	public double getLoadingCapacity() {
		return loadingCapacity;
	}

	public void setLoadingCapacity(double loadingCapacity) {
		this.loadingCapacity = loadingCapacity;
	}
}
