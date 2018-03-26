package objects;

public class Car extends Vehicle {
	private String fuelType;
	private int doors;

	public Car(int id, String model, int topSpeed, String registrationNumber, double dailyHireRate, String fuelType,
			int doors) {
		super(id, model, topSpeed, registrationNumber, dailyHireRate);
		this.fuelType = fuelType;
		this.doors = doors;
	}

	public String getFuelType() {
		return fuelType;
	}

	public int getDoors() {
		return doors;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}
}
