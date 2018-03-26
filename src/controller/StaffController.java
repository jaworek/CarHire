package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import model.MainModel;
import objects.Car;
import objects.Customer;
import objects.Vehicle;
import view.StaffView;

public class StaffController extends AbstractController implements ActionListener {
	private MainController mainController;
	private VehicleController vehicleController;
	private MainModel mainModel;
	private StaffView staffView;

	public StaffController(MainController mainController, MainModel mainModel) {
		this.mainController = mainController;
		this.mainModel = mainModel;
		this.staffView = new StaffView(this);
		this.vehicleController = new VehicleController(mainController, mainModel);
	}

	public DefaultTableModel generateCustomerTable() {
		String[] columnNames = { "Name", "Username" };

		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

		for (Customer customer : mainModel.getCustomers()) {
			String name = customer.getName();
			String username = customer.getUsername();

			Object[] data = { name, username };

			tableModel.addRow(data);
		}

		return tableModel;
	}

	public DefaultTableModel generateAvailableCarsTable() {
		String[] columnNames = { "Id", "Model", "Top speed", "Registration number", "Hire rate", "Number of doors" };

		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

		for (Car car : mainModel.getCars()) {
			int id = car.getId();
			String model = car.getModel();
			int topSpeed = car.getTopSpeed();
			String registrationNumber = car.getRegistrationNumber();
			double hireRate = car.getDailyHireRate();
			String fuelType = car.getFuelType();
			int numberOfDoors = car.getDoors();

			Object[] data = { id, model, topSpeed, registrationNumber, hireRate, fuelType, numberOfDoors };

			tableModel.addRow(data);
		}

		return tableModel;
	}

	public DefaultTableModel generateCustomerVehiclesTable(Customer customer) {
		String[] columnNames = { "Id", "Model" };

		ArrayList<Vehicle> hiredCars = customer.getHiredVehicles();

		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

		for (Vehicle vehicle : hiredCars) {
			int id = vehicle.getId();
			String model = vehicle.getModel();

			Object[] data = { id, model };

			tableModel.addRow(data);
		}

		return tableModel;
	}

	public DefaultComboBoxModel generateListOfCustomers() {
		ArrayList<String> customers = new ArrayList<String>();
		for (Customer customer : mainModel.getCustomers()) {
			customers.add(customer.getUsername());
		}

		String[] customerList = new String[customers.size()];
		customerList = customers.toArray(customerList);

		return new DefaultComboBoxModel(customerList);
	}

	public void getCustomerDetails() {
		System.out.println(staffView.getTableCustomers().getSelectedRow());
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String source = event.getActionCommand();

		System.out.println(source);

		if (source.equals("Add car")) {
			// int id = mainModel.getVehicles().size();
			// vehicleController.addVehicle(id, "Tesla", 300, "XL456", 90.99, "Electric",
			// 5);
		} else if (source.equals("Select")) {
			getCustomerDetails();
		} else if (source.equals("Remove")) {
			System.out.println("Car removed");
		} else if (source.equals("Hire")) {
			System.out.println("Car hired");
		} else if (source.equals("Return")) {
			System.out.println("Car returned");
		}
	}

}
