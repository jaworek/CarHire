package controller;

import model.Car;
import model.Lorry;
import model.MiniBus;
import view.MainView;

public class VehicleController {

	public VehicleController(MainView mainView) {
	}

	// Overloaded function used to add different types of vehicles
	void addVehicle(String model, int topSpeed, String registrationNumber, double dailyHireRate, String fuelType,
			int doors) {
		Car newCar = new Car(model, topSpeed, registrationNumber, dailyHireRate, fuelType, doors);
		// vehicles.add(newCar);
	}

	void addVehicle(String model, int topSpeed, String registrationNumber, double dailyHireRate,
			double loadingCapacity) {
		Lorry newLorry = new Lorry(model, topSpeed, registrationNumber, dailyHireRate, loadingCapacity);
		// vehicles.add(newLorry);
	}

	void addVehicle(String model, int topSpeed, String registrationNumber, double dailyHireRate, int seatingCapacity) {
		MiniBus newMiniBus = new MiniBus(model, topSpeed, registrationNumber, dailyHireRate, seatingCapacity);
		// vehicles.add(newMiniBus);
	}

}
