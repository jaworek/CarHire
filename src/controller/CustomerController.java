package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import model.CustomerModel;
import model.MainModel;
import objects.Customer;
import objects.Vehicle;
import view.CustomerView;

public class CustomerController extends AbstractController implements ActionListener {
	private MainController mainController;
	private MainModel mainModel;
	private CustomerModel customerModel;
	private CustomerView customerView;

	public CustomerController(MainController mainController, MainModel mainModel, CustomerModel customerModel) {
		this.mainController = mainController;
		this.mainModel = mainModel;
		this.customerModel = customerModel;
		this.customerView = new CustomerView(this);
	}

	public DefaultTableModel generateAvailableVehiclesTable() {
		String[] columnNames = { "Model", "Top Speed", "Registration number", "Hire rate" };

		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

		// for (Vehicle vehicle : mainModel.getVehicles()) {
		// String model = vehicle.getModel();
		// int topSpeed = vehicle.getTopSpeed();
		// String registrationNumber = vehicle.getRegistrationNumber();
		// double hireRate = vehicle.getDailyHireRate();
		//
		// Object[] data = { model, topSpeed, registrationNumber, hireRate };
		//
		// tableModel.addRow(data);
		// }

		return tableModel;
	}

	public DefaultTableModel generateHiredVehiclesTable() {
		String[] columnNames = { "Model", "Top Speed", "Registration number", "Hire rate" };

		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

		for (Vehicle vehicle : this.getCustomer().getHiredVehicles()) {
			String model = vehicle.getModel();
			int topSpeed = vehicle.getTopSpeed();
			String registrationNumber = vehicle.getRegistrationNumber();
			double hireRate = vehicle.getDailyHireRate();

			Object[] data = { model, topSpeed, registrationNumber, hireRate };

			tableModel.addRow(data);
		}

		return tableModel;
	}

	public Customer getCustomer() {
		return customerModel.getCustomer();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String source = event.getActionCommand();

		if (source.equals("Hire")) {
			System.out.println("Car hired");
		} else if (source.equals("Return")) {
			System.out.println("Car returned");
		}
	}

}
