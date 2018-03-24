package objects;

public class MiniBus extends Vehicle {
	private int seatingCapacity;

	public MiniBus(String model, int topSpeed, String registrationNumber, double dailyHireRate, int seatingCapacity) {
		super(model, topSpeed, registrationNumber, dailyHireRate);
		this.seatingCapacity = seatingCapacity;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
}
