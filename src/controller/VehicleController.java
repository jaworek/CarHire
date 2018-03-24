package controller;

import model.MainModel;
import objects.Car;
import objects.Lorry;
import objects.MiniBus;

public class VehicleController {
	private MainController mainController;
	private MainModel mainModel;

	public VehicleController(MainController mainController, MainModel mainModel) {
		this.mainController = mainController;
		this.mainModel = mainModel;
	}

	// Overloaded function used to add different types of vehicles
	void addVehicle(String model, int topSpeed, String registrationNumber, double dailyHireRate, String fuelType,
			int doors) {
		Car newCar = new Car(model, topSpeed, registrationNumber, dailyHireRate, fuelType, doors);
		mainModel.getVehicles().add(newCar);
	}

	void addVehicle(String model, int topSpeed, String registrationNumber, double dailyHireRate,
			double loadingCapacity) {
		Lorry newLorry = new Lorry(model, topSpeed, registrationNumber, dailyHireRate, loadingCapacity);
		mainModel.getVehicles().add(newLorry);
	}

	void addVehicle(String model, int topSpeed, String registrationNumber, double dailyHireRate, int seatingCapacity) {
		MiniBus newMiniBus = new MiniBus(model, topSpeed, registrationNumber, dailyHireRate, seatingCapacity);
		mainModel.getVehicles().add(newMiniBus);
	}

}
