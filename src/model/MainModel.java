package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainModel {
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

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

	// Saves vehicles and customers objects in the binary files
	public void writeFile() {
		try {
			ObjectOutputStream customersFile = new ObjectOutputStream(new FileOutputStream("customers.dat"));
			// customersFile.writeObject();
			customersFile.close();

			ObjectOutputStream vehiclesFile = new ObjectOutputStream(new FileOutputStream("vehicles.dat"));
			// vehiclesFile.writeObject();
			vehiclesFile.close();

		} catch (IOException io) {
			System.out.println(io);
		}
	}

	// Reads customers and vehicles object from the binary files
	public void loadFile() {
		try {
			ObjectInputStream customersFile = new ObjectInputStream(new FileInputStream("customers.dat"));
			ObjectInputStream vehiclesFile = new ObjectInputStream(new FileInputStream("vehicles.dat"));

			customers = (ArrayList<Customer>) customersFile.readObject();
			customersFile.close();

			vehicles = (ArrayList<Vehicle>) vehiclesFile.readObject();
			vehiclesFile.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}