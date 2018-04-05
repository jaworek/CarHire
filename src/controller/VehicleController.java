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
	public void addCar(int id, String model, int topSpeed, String registrationNumber, double dailyHireRate,
			String fuelType, int doors) {
		Car newCar = new Car(id, model, topSpeed, registrationNumber, dailyHireRate, fuelType, doors);
		mainModel.getCars().add(newCar);
	}

	public void addLorry(int id, String model, int topSpeed, String registrationNumber, double dailyHireRate,
			double loadingCapacity) {
		Lorry newLorry = new Lorry(id, model, topSpeed, registrationNumber, dailyHireRate, loadingCapacity);
		mainModel.getLorries().add(newLorry);
	}

	public void addMinibus(int id, String model, int topSpeed, String registrationNumber, double dailyHireRate,
			int seatingCapacity) {
		MiniBus newMiniBus = new MiniBus(id, model, topSpeed, registrationNumber, dailyHireRate, seatingCapacity);
		mainModel.getMinibuses().add(newMiniBus);
	}

	public void removeCar(int id) {
		mainModel.getCars().remove(id);
	}

	public void removeLorry(int id) {
		mainModel.getLorries().remove(id);
	}

	public void removeMinibus(int id) {
		mainModel.getMinibuses().remove(id);
	}

}
