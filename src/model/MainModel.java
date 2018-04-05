package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import objects.Car;
import objects.Customer;
import objects.Lorry;
import objects.MiniBus;

public class MainModel {
	private List<Customer> customers = new ArrayList<Customer>();
	private List<Car> cars = new ArrayList<Car>();
	private List<Lorry> lorries = new ArrayList<Lorry>();
	private List<MiniBus> minibuses = new ArrayList<MiniBus>();
	private int maxId = -1;

	public Customer getCustomerById(int id) {
		for (Customer customer : customers) {
			if (customer.getId() == id) {
				return customer;
			}
		}

		return null;
	}

	public Car getCarById(int id) {
		for (Car car : cars) {
			if (car.getId() == id) {
				return car;
			}
		}

		return null;
	}

	public Lorry getLorryById(int id) {
		for (Lorry lorry : lorries) {
			if (lorry.getId() == id) {
				return lorry;
			}
		}

		return null;
	}

	public MiniBus getMinibusById(int id) {
		for (MiniBus minibus : minibuses) {
			if (minibus.getId() == id) {
				return minibus;
			}
		}

		return null;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}

	public List<Lorry> getLorries() {
		return lorries;
	}

	public void setLorries(ArrayList<Lorry> lorries) {
		this.lorries = lorries;
	}

	public List<MiniBus> getMinibuses() {
		return minibuses;
	}

	public void setMinibuses(ArrayList<MiniBus> minibuses) {
		this.minibuses = minibuses;
	}

	public int generateId() {
		if (maxId != -1) {
			return ++maxId;
		}
		for (Car car : getCars()) {
			if (car.getId() > maxId) {
				maxId = car.getId();
			}
		}

		for (Lorry lorry : getLorries()) {
			if (lorry.getId() > maxId) {
				maxId = lorry.getId();
			}
		}

		for (MiniBus minibus : getMinibuses()) {
			if (minibus.getId() > maxId) {
				maxId = minibus.getId();
			}
		}

		return ++maxId;
	}

	// Saves vehicles and customers objects in the binary files
	public void writeFile() {
		try {
			ObjectOutputStream customersFile = new ObjectOutputStream(new FileOutputStream("customers.dat"));
			customersFile.writeObject(customers);
			customersFile.close();

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
			ObjectInputStream carsFile = new ObjectInputStream(new FileInputStream("cars.dat"));
			ObjectInputStream lorriesFile = new ObjectInputStream(new FileInputStream("lorries.dat"));
			ObjectInputStream minibusesFile = new ObjectInputStream(new FileInputStream("minibuses.dat"));

			customers = (List<Customer>) customersFile.readObject();
			customersFile.close();

			cars = (List<Car>) carsFile.readObject();
			carsFile.close();

			lorries = (List<Lorry>) lorriesFile.readObject();
			lorriesFile.close();

			minibuses = (List<MiniBus>) minibusesFile.readObject();
			minibusesFile.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}