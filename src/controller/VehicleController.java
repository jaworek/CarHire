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
	void addVehicle(int id, String model, int topSpeed, String registrationNumber, double dailyHireRate,
			String fuelType, int doors) {
		Car newCar = new Car(id, model, topSpeed, registrationNumber, dailyHireRate, fuelType, doors);
		mainModel.getCars().add(newCar);
	}

	void addVehicle(int id, String model, int topSpeed, String registrationNumber, double dailyHireRate,
			double loadingCapacity) {
		Lorry newLorry = new Lorry(id, model, topSpeed, registrationNumber, dailyHireRate, loadingCapacity);
		mainModel.getLorries().add(newLorry);
	}

	void addVehicle(int id, String model, int topSpeed, String registrationNumber, double dailyHireRate,
			int seatingCapacity) {
		MiniBus newMiniBus = new MiniBus(id, model, topSpeed, registrationNumber, dailyHireRate, seatingCapacity);
		mainModel.getMinibuses().add(newMiniBus);
	}

}
