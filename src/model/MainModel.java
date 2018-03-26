package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import objects.Car;
import objects.Customer;
import objects.Lorry;
import objects.MiniBus;

public class MainModel {
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	// private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	private ArrayList<Car> cars = new ArrayList<Car>();
	private ArrayList<Lorry> lorries = new ArrayList<Lorry>();
	private ArrayList<MiniBus> minibuses = new ArrayList<MiniBus>();

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	// public ArrayList<Vehicle> getVehicles() {
	// return vehicles;
	// }
	//
	// public void setVehicles(ArrayList<Vehicle> vehicles) {
	// this.vehicles = vehicles;
	// }

	public ArrayList<Car> getCars() {
		return cars;
	}

	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}

	public ArrayList<Lorry> getLorries() {
		return lorries;
	}

	public void setLorries(ArrayList<Lorry> lorries) {
		this.lorries = lorries;
	}

	public ArrayList<MiniBus> getMinibuses() {
		return minibuses;
	}

	public void setMinibuses(ArrayList<MiniBus> minibuses) {
		this.minibuses = minibuses;
	}

	// Saves vehicles and customers objects in the binary files
	public void writeFile() {
		try {
			ObjectOutputStream customersFile = new ObjectOutputStream(new FileOutputStream("customers.dat"));
			customersFile.writeObject(customers);
			customersFile.close();

			// ObjectOutputStream vehiclesFile = new ObjectOutputStream(new
			// FileOutputStream("vehicles.dat"));
			// vehiclesFile.writeObject(vehicles);
			// vehiclesFile.close();

			ObjectOutputStream carsFile = new ObjectOutputStream(new FileOutputStream("cars.dat"));
			carsFile.writeObject(cars);
			carsFile.close();

			ObjectOutputStream lorriesFile = new ObjectOutputStream(new FileOutputStream("lorries.dat"));
			lorriesFile.writeObject(lorries);
			lorriesFile.close();

			ObjectOutputStream minibusesFile = new ObjectOutputStream(new FileOutputStream("minibuses.dat"));
			minibusesFile.writeObject(minibuses);
			minibusesFile.close();

		} catch (IOException io) {
			System.out.println(io);
		}
	}

	// Reads customers and vehicles object from the binary files
	public void loadFile() {
		try {
			ObjectInputStream customersFile = new ObjectInputStream(new FileInputStream("customers.dat"));
			// ObjectInputStream vehiclesFile = new ObjectInputStream(new
			// FileInputStream("vehicles.dat"));
			ObjectInputStream carsFile = new ObjectInputStream(new FileInputStream("cars.dat"));
			ObjectInputStream lorriesFile = new ObjectInputStream(new FileInputStream("lorries.dat"));
			ObjectInputStream minibusesFile = new ObjectInputStream(new FileInputStream("minibuses.dat"));

			customers = (ArrayList<Customer>) customersFile.readObject();
			customersFile.close();

			// vehicles = (ArrayList<Vehicle>) vehiclesFile.readObject();
			// vehiclesFile.close();

			cars = (ArrayList<Car>) carsFile.readObject();
			carsFile.close();

			lorries = (ArrayList<Lorry>) lorriesFile.readObject();
			lorriesFile.close();

			minibuses = (ArrayList<MiniBus>) minibusesFile.readObject();
			minibusesFile.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}