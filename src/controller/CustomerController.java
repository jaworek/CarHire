package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import model.CustomerModel;
import model.MainModel;
import objects.Car;
import objects.Customer;
import objects.Lorry;
import objects.MiniBus;
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
		String[] columnNames = { "Id", "Model", "Top Speed", "Registration number", "Hire rate", "Type" };

		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

		for (Car car : mainModel.getCars()) {
			if (car.getHiredBy() == -1) {
				int id = car.getId();
				String model = car.getModel();
				int topSpeed = car.getTopSpeed();
				String registrationNumber = car.getRegistrationNumber();
				double hireRate = car.getDailyHireRate();
				String type = car.getClass().getSimpleName();

				Object[] data = { id, model, topSpeed, registrationNumber, hireRate, type };

				tableModel.addRow(data);
			}
		}

		for (Lorry lorry : mainModel.getLorries()) {
			if (lorry.getHiredBy() == -1) {
				int id = lorry.getId();
				String model = lorry.getModel();
				int topSpeed = lorry.getTopSpeed();
				String registrationNumber = lorry.getRegistrationNumber();
				double hireRate = lorry.getDailyHireRate();
				String type = lorry.getClass().getSimpleName();

				Object[] data = { id, model, topSpeed, registrationNumber, hireRate, type };

				tableModel.addRow(data);
			}
		}

		for (MiniBus miniBus : mainModel.getMinibuses()) {
			if (miniBus.getHiredBy() == -1) {
				int id = miniBus.getId();
				String model = miniBus.getModel();
				int topSpeed = miniBus.getTopSpeed();
				String registrationNumber = miniBus.getRegistrationNumber();
				double hireRate = miniBus.getDailyHireRate();
				String type = miniBus.getClass().getSimpleName();

				Object[] data = { id, model, topSpeed, registrationNumber, hireRate, type };

				tableModel.addRow(data);
			}
		}

		return tableModel;
	}

	public DefaultTableModel generateHiredVehiclesTable() {
		String[] columnNames = { "Id", "Model", "Top Speed", "Registration number", "Hire rate", "Type" };

		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

		for (Vehicle vehicle : this.getCustomer().getHiredVehicles()) {
			int id = vehicle.getId();
			String model = vehicle.getModel();
			int topSpeed = vehicle.getTopSpeed();
			String registrationNumber = vehicle.getRegistrationNumber();
			double hireRate = vehicle.getDailyHireRate();
			String type = vehicle.getClass().getSimpleName();

			Object[] data = { id, model, topSpeed, registrationNumber, hireRate, type };

			tableModel.addRow(data);
		}

		return tableModel;
	}

	public void removeVehicleFromList() {
		int selectedRow = customerView.getTableAvailableVehicles().getSelectedRow();
		DefaultTableModel model = (DefaultTableModel) customerView.getTableAvailableVehicles().getModel();
		model.removeRow(selectedRow);
	}

	public void hireCar() {
		int id = (int) customerView.getTableAvailableVehicles().getModel()
				.getValueAt(customerView.getTableAvailableVehicles().getSelectedRow(), 0);
		Car car = mainModel.getCarById(id);
		customerModel.getCustomer().getHiredVehicles().add(car);
		car.setHiredBy(customerModel.getCustomer().getId());
		removeVehicleFromList();

		String model = car.getModel();
		int topSpeed = car.getTopSpeed();
		String registrationNumber = car.getRegistrationNumber();
		double hireRate = car.getDailyHireRate();
		String type = car.getClass().getSimpleName();
		Object[] row = { id, model, topSpeed, registrationNumber, hireRate, type };
		DefaultTableModel tableModel = (DefaultTableModel) customerView.getTableHiredVehicles().getModel();
		tableModel.addRow(row);
	}

	public void hireLorry() {
		int id = (int) customerView.getTableAvailableVehicles().getModel()
				.getValueAt(customerView.getTableAvailableVehicles().getSelectedRow(), 0);
		Lorry lorry = mainModel.getLorryById(id);
		customerModel.getCustomer().getHiredVehicles().add(lorry);
		lorry.setHiredBy(customerModel.getCustomer().getId());
		removeVehicleFromList();

		String model = lorry.getModel();
		int topSpeed = lorry.getTopSpeed();
		String registrationNumber = lorry.getRegistrationNumber();
		double hireRate = lorry.getDailyHireRate();
		String type = lorry.getClass().getSimpleName();
		Object[] row = { id, model, topSpeed, registrationNumber, hireRate, type };
		DefaultTableModel tableModel = (DefaultTableModel) customerView.getTableHiredVehicles().getModel();
		tableModel.addRow(row);
	}

	public void hireMinibus() {
		int id = (int) customerView.getTableAvailableVehicles().getModel()
				.getValueAt(customerView.getTableAvailableVehicles().getSelectedRow(), 0);
		MiniBus minibus = mainModel.getMinibusById(id);
		customerModel.getCustomer().getHiredVehicles().add(minibus);
		minibus.setHiredBy(customerModel.getCustomer().getId());
		removeVehicleFromList();

		String model = minibus.getModel();
		int topSpeed = minibus.getTopSpeed();
		String registrationNumber = minibus.getRegistrationNumber();
		double hireRate = minibus.getDailyHireRate();
		String type = minibus.getClass().getSimpleName();
		Object[] row = { id, model, topSpeed, registrationNumber, hireRate, type };
		DefaultTableModel tableModel = (DefaultTableModel) customerView.getTableHiredVehicles().getModel();
		tableModel.addRow(row);
	}

	public void hireVehicle() {
		int id = (int) customerView.getTableAvailableVehicles().getModel()
				.getValueAt(customerView.getTableAvailableVehicles().getSelectedRow(), 0);
		String type = (String) customerView.getTableAvailableVehicles().getModel()
				.getValueAt(customerView.getTableAvailableVehicles().getSelectedRow(), 5);

		switch (type) {
		case "Car":
			System.out.println("Hired car");
			hireCar();
			break;
		case "Lorry":
			System.out.println("Hired lorry");
			hireLorry();
			break;
		case "MiniBus":
			System.out.println("Hired minibus");
			hireMinibus();
			break;
		default:
			break;
		}
	}

	public void returnVehicle() {
		int id = (int) customerView.getTableHiredVehicles().getModel()
				.getValueAt(customerView.getTableHiredVehicles().getSelectedRow(), 0);
		Vehicle vehicle = this.getCustomer().getVehicleById(id);

		String vehicleType = (String) customerView.getTableHiredVehicles().getModel()
				.getValueAt(customerView.getTableHiredVehicles().getSelectedRow(), 5);

		String model = vehicle.getModel();
		int topSpeed = vehicle.getTopSpeed();
		String registrationNumber = vehicle.getRegistrationNumber();
		double hireRate = vehicle.getDailyHireRate();
		DefaultTableModel tableModel = (DefaultTableModel) customerView.getTableAvailableVehicles().getModel();

		if (vehicleType.equals("Car")) {
			Car car = mainModel.getCarById(id);
			car.setHiredBy(-1);

			String type = car.getClass().getSimpleName();
			Object[] row = { id, model, topSpeed, registrationNumber, hireRate, type };

			type = car.getClass().getSimpleName();

			tableModel.addRow(row);
		} else if (vehicleType.equals("Lorry")) {
			Lorry lorry = mainModel.getLorryById(id);
			lorry.setHiredBy(-1);

			String type = lorry.getClass().getSimpleName();
			Object[] row = { id, model, topSpeed, registrationNumber, hireRate, type };

			type = lorry.getClass().getSimpleName();

			tableModel.addRow(row);
		} else if (vehicleType.equals("MiniBus")) {
			MiniBus miniBus = mainModel.getMinibusById(id);
			miniBus.setHiredBy(-1);

			String type = miniBus.getClass().getSimpleName();
			Object[] row = { id, model, topSpeed, registrationNumber, hireRate, type };

			type = miniBus.getClass().getSimpleName();

			tableModel.addRow(row);
		}

		Customer customer = customerModel.getCustomer();
		customer.getHiredVehicles().remove(vehicle);

		DefaultTableModel tableHiredModel = (DefaultTableModel) customerView.getTableHiredVehicles().getModel();
		int selectedRow = customerView.getTableHiredVehicles().getSelectedRow();
		tableHiredModel.removeRow(selectedRow);
	}

	public Customer getCustomer() {
		return customerModel.getCustomer();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String source = event.getActionCommand();

		if (source.equals("Hire")) {
			System.out.println("Vehicle hired");
			hireVehicle();
		} else if (source.equals("Return")) {
			System.out.println("Vehicle returned");
			returnVehicle();
		}
	}

}
