package model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Model {
	ArrayList<Customer> customers = new ArrayList<>();
	ArrayList<Vehicle> vehicles = new ArrayList<>();

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	// Reads customers and vehicles object from the binary files
	void loadFile() {
		try {
			ObjectInputStream customersFile = new ObjectInputStream(new FileInputStream("customers.dat"));
			ObjectInputStream vehiclesFile = new ObjectInputStream(new FileInputStream("vehicles.dat"));

			customers = (ArrayList<Customer>) customersFile.readObject();
			customersFile.close();

			vehicles = (ArrayList<Vehicle>) vehiclesFile.readObject();
			vehiclesFile.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}