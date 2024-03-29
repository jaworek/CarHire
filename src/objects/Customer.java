package objects;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {
	private int id;
	private String name, address, phoneNumber, email, dateOfBirth, username, password;
	private ArrayList<Vehicle> hiredVehicles;

	public Customer(int id, String name, String address, String phoneNumber, String email, String dateOfBirth,
			String username, String password) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.username = username;
		this.password = password;
		this.hiredVehicles = new ArrayList<Vehicle>();
	}

	public Vehicle getVehicleById(int id) {
		for (Vehicle vehicle : this.getHiredVehicles()) {
			if (vehicle.getId() == id) {
				return vehicle;
			}
		}

		return null;
	}

	@Override
	public String toString() {
		return "Customer{" + "id=" + id + ", name='" + name + '\'' + '}';
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Vehicle> getHiredVehicles() {
		return hiredVehicles;
	}

	public void setHiredVehicles(ArrayList<Vehicle> hiredVehicles) {
		this.hiredVehicles = hiredVehicles;
	}

}
