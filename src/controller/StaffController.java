package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import model.MainModel;
import objects.Car;
import objects.Customer;
import objects.CustomerWrapper;
import objects.Lorry;
import objects.MiniBus;
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
		staffView.generateCustomerComboBox(mainModel.getCustomers());
		this.vehicleController = new VehicleController(mainController, mainModel);
	}

	public DefaultTableModel generateCustomerTable() {
		String[] columnNames = { "Id", "Name", "Username" };

		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

		for (Customer customer : mainModel.getCustomers()) {
			int id = customer.getId();
			String name = customer.getName();
			String username = customer.getUsername();

			Object[] data = { id, name, username };

			tableModel.addRow(data);
		}

		return tableModel;
	}

	public DefaultTableModel generateAvailableCarsTable() {
		String[] columnNames = { "Id", "Model", "Top speed", "Registration number", "Hire rate", "Number of doors" };

		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

		for (Car car : mainModel.getCars()) {
			if (car.getHiredBy() == -1) {
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
		}

		return tableModel;
	}

	public DefaultTableModel generateAvailableLorriesTable() {
		String[] columnNames = { "Id", "Model", "Top speed", "Registration number", "Hire rate", "Loading capacity" };

		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

		for (Lorry lorry : mainModel.getLorries()) {
			if (lorry.getHiredBy() == -1) {
				int id = lorry.getId();
				String model = lorry.getModel();
				int topSpeed = lorry.getTopSpeed();
				String registrationNumber = lorry.getRegistrationNumber();
				double hireRate = lorry.getDailyHireRate();
				double loadingCapacity = lorry.getLoadingCapacity();

				Object[] data = { id, model, topSpeed, registrationNumber, hireRate, loadingCapacity };

				tableModel.addRow(data);
			}
		}

		return tableModel;
	}

	public DefaultTableModel generateAvailableMinibusTable() {
		String[] columnNames = { "Id", "Model", "Top speed", "Registration number", "Seating capacity" };

		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

		for (MiniBus miniBus : mainModel.getMinibuses()) {
			if (miniBus.getHiredBy() == -1) {
				int id = miniBus.getId();
				String model = miniBus.getModel();
				int topSpeed = miniBus.getTopSpeed();
				String registrationNumber = miniBus.getRegistrationNumber();
				double hireRate = miniBus.getDailyHireRate();
				int seatingCapacity = miniBus.getSeatingCapacity();

				Object[] data = { id, model, topSpeed, registrationNumber, hireRate, seatingCapacity };

				tableModel.addRow(data);
			}
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
		Customer customer = mainModel.getCustomerById(staffView.getTableCustomers().getSelectedRow());
		staffView.fillCustomerDetails(customer);

		String[] columnNames = { "Id", "Model", "Type" };
		ArrayList<Vehicle> hiredCars = customer.getHiredVehicles();
		staffView.setHiredCarsModel(columnNames, hiredCars);
	}

	public void addCar() {
		int id = mainModel.generateId();
		String model = staffView.getTextCarModel().getText();
		int topSpeed = Integer.parseInt(staffView.getTextCarTopSpeed().getText());
		String registrationNumber = staffView.getTextCarRegistrationNumber().getText();
		double hireRate = Double.parseDouble(staffView.getTextCarHireRate().getText());
		String fuelType = staffView.getTextCarFuel().getText();
		int doors = Integer.parseInt(staffView.getTextCarDoors().getText());

		staffView.getTextCarModel().setText("");
		staffView.getTextCarTopSpeed().setText("");
		staffView.getTextCarRegistrationNumber().setText("");
		staffView.getTextCarHireRate().setText("");
		staffView.getTextCarFuel().setText("");
		staffView.getTextCarDoors().setText("");

		vehicleController.addCar(id, model, topSpeed, registrationNumber, hireRate, fuelType, doors);

		Object[] row = { id, model, topSpeed, registrationNumber, hireRate, fuelType, doors };
		DefaultTableModel tableModel = (DefaultTableModel) staffView.getTableCars().getModel();
		tableModel.addRow(row);
	}

	public void addLorry() {
		int id = mainModel.generateId();
		String model = staffView.getTextLorryModel().getText();
		int topSpeed = Integer.parseInt(staffView.getTextLorryTopSpeed().getText());
		String registrationNumber = staffView.getTextLorryRegistration().getText();
		double hireRate = Double.parseDouble(staffView.getTextLorryHireRate().getText());
		double loadingCapacity = Double.parseDouble(staffView.getTextLorryLoadingCapacity().getText());

		staffView.getTextLorryModel().setText("");
		staffView.getTextLorryTopSpeed().setText("");
		staffView.getTextLorryRegistration().setText("");
		staffView.getTextLorryHireRate().setText("");
		staffView.getTextLorryLoadingCapacity().setText("");

		vehicleController.addLorry(id, model, topSpeed, registrationNumber, hireRate, loadingCapacity);

		Object[] row = { id, model, topSpeed, registrationNumber, hireRate, loadingCapacity };
		DefaultTableModel tableModel = (DefaultTableModel) staffView.getTableLorries().getModel();
		tableModel.addRow(row);
	}

	public void addMinibus() {
		int id = mainModel.generateId();
		String model = staffView.getTextMinibusModel().getText();
		int topSpeed = Integer.parseInt(staffView.getTextMinibusTopSpeed().getText());
		String registrationNumber = staffView.getTextMinibusRegistration().getText();
		double hireRate = Double.parseDouble(staffView.getTextMinibusHireRate().getText());
		int seatingCapacity = Integer.parseInt(staffView.getTextMinibusSeating().getText());

		staffView.getTextMinibusModel().setText("");
		staffView.getTextMinibusTopSpeed().setText("");
		staffView.getTextMinibusRegistration().setText("");
		staffView.getTextMinibusHireRate().setText("");
		staffView.getTextMinibusSeating().setText("");

		vehicleController.addMinibus(id, model, topSpeed, registrationNumber, hireRate, seatingCapacity);

		Object[] row = { id, model, topSpeed, registrationNumber, hireRate, seatingCapacity };
		DefaultTableModel tableModel = (DefaultTableModel) staffView.getTableMinibuses().getModel();
		tableModel.addRow(row);
	}

	public void removeCarFromList() {
		int selectedRow = staffView.getTableCars().getSelectedRow();
		DefaultTableModel model = (DefaultTableModel) staffView.getTableCars().getModel();
		model.removeRow(selectedRow);
	}

	public void removeLorryFromList() {
		int selectedRow = staffView.getTableLorries().getSelectedRow();
		DefaultTableModel model = (DefaultTableModel) staffView.getTableLorries().getModel();
		model.removeRow(selectedRow);
	}

	public void removeMinibusFromList() {
		int selectedRow = staffView.getTableMinibuses().getSelectedRow();
		DefaultTableModel model = (DefaultTableModel) staffView.getTableMinibuses().getModel();
		model.removeRow(selectedRow);
	}

	public void hireCar() {
		int id = (int) staffView.getTableCars().getModel().getValueAt(staffView.getTableCars().getSelectedRow(), 0);
		Car car = mainModel.getCarById(id);
		CustomerWrapper customerWrapper = (CustomerWrapper) staffView.getComboBoxCars().getSelectedItem();
		customerWrapper.getCustomer().getHiredVehicles().add(car);
		car.setHiredBy(customerWrapper.getCustomer().getId());
		removeCarFromList();
	}

	public void hireLorry() {
		int id = (int) staffView.getTableLorries().getModel().getValueAt(staffView.getTableLorries().getSelectedRow(),
				0);
		Lorry lorry = mainModel.getLorryById(id);
		CustomerWrapper customerWrapper = (CustomerWrapper) staffView.getComboBoxLorry().getSelectedItem();
		customerWrapper.getCustomer().getHiredVehicles().add(lorry);
		lorry.setHiredBy(customerWrapper.getCustomer().getId());
		removeLorryFromList();
	}

	public void hireMinibus() {
		int id = (int) staffView.getTableMinibuses().getModel()
				.getValueAt(staffView.getTableMinibuses().getSelectedRow(), 0);
		MiniBus minibus = mainModel.getMinibusById(id);
		CustomerWrapper customerWrapper = (CustomerWrapper) staffView.getComboBoxMinibus().getSelectedItem();
		customerWrapper.getCustomer().getHiredVehicles().add(minibus);
		minibus.setHiredBy(customerWrapper.getCustomer().getId());
		removeMinibusFromList();
	}

	public void removeCar() {
		int id = (int) staffView.getTableCars().getModel().getValueAt(staffView.getTableCars().getSelectedRow(), 0);
		Car car = mainModel.getCarById(id);
		mainModel.getCars().remove(car);
		removeCarFromList();
	}

	public void removeLorry() {
		int id = (int) staffView.getTableLorries().getModel().getValueAt(staffView.getTableLorries().getSelectedRow(),
				0);
		Lorry lorry = mainModel.getLorryById(id);
		mainModel.getLorries().remove(lorry);
		removeLorryFromList();
	}

	public void removeMinibus() {
		int id = (int) staffView.getTableMinibuses().getModel()
				.getValueAt(staffView.getTableMinibuses().getSelectedRow(), 0);
		MiniBus miniBus = mainModel.getMinibusById(id);
		mainModel.getMinibuses().remove(miniBus);
		removeMinibusFromList();
	}

	public void returnVehicle() {
		int id = (int) staffView.getTableHiredVehicles().getModel()
				.getValueAt(staffView.getTableHiredVehicles().getSelectedRow(), 0);
		int customerId = (int) staffView.getTableCustomers().getModel()
				.getValueAt(staffView.getTableCustomers().getSelectedRow(), 0);
		String vehicleType = (String) staffView.getTableHiredVehicles().getModel()
				.getValueAt(staffView.getTableHiredVehicles().getSelectedRow(), 2);

		if (vehicleType.equals("Car")) {
			Car car = mainModel.getCarById(id);
			car.setHiredBy(-1);

			String model = car.getModel();
			int topSpeed = car.getTopSpeed();
			String registrationNumber = car.getRegistrationNumber();
			double hireRate = car.getDailyHireRate();
			String fuelType = car.getFuelType();
			int doors = car.getDoors();

			Object[] row = { id, model, topSpeed, registrationNumber, hireRate, fuelType, doors };
			DefaultTableModel tableModel = (DefaultTableModel) staffView.getTableCars().getModel();
			tableModel.addRow(row);
		} else if (vehicleType.equals("Lorry")) {
			Lorry lorry = mainModel.getLorryById(id);
			lorry.setHiredBy(-1);

			String model = lorry.getModel();
			int topSpeed = lorry.getTopSpeed();
			String registrationNumber = lorry.getRegistrationNumber();
			double hireRate = lorry.getDailyHireRate();
			double loadingCapacity = lorry.getLoadingCapacity();

			Object[] row = { id, model, topSpeed, registrationNumber, hireRate, loadingCapacity };
			DefaultTableModel tableModel = (DefaultTableModel) staffView.getTableLorries().getModel();
			tableModel.addRow(row);
		} else if (vehicleType.equals("MiniBus")) {
			MiniBus miniBus = mainModel.getMinibusById(id);
			miniBus.setHiredBy(-1);

			String model = miniBus.getModel();
			int topSpeed = miniBus.getTopSpeed();
			String registrationNumber = miniBus.getRegistrationNumber();
			double hireRate = miniBus.getDailyHireRate();
			int seatingCapacity = miniBus.getSeatingCapacity();

			Object[] row = { id, model, topSpeed, registrationNumber, hireRate, seatingCapacity };
			DefaultTableModel tableModel = (DefaultTableModel) staffView.getTableMinibuses().getModel();
			tableModel.addRow(row);
		}

		Customer customer = mainModel.getCustomerById(customerId);
		Vehicle vehicle = customer.getVehicleById(id);
		customer.getHiredVehicles().remove(vehicle);

		int selectedRow = staffView.getTableHiredVehicles().getSelectedRow();
		DefaultTableModel model = (DefaultTableModel) staffView.getTableHiredVehicles().getModel();
		model.removeRow(selectedRow);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String source = event.getActionCommand();

		System.out.println(source);

		if (source.equals("Add car")) {
			System.out.println("Car added");
			addCar();
		} else if (source.equals("Remove car")) {
			System.out.println("Car removed");
			removeCar();
		} else if (source.equals("Hire car")) {
			hireCar();
		} else if (source.equals("Add lorry")) {
			System.out.println("Lorry added");
			addLorry();
		} else if (source.equals("Hire lorry")) {
			System.out.println("Lorry hired");
			hireLorry();
		} else if (source.equals("Remove lorry")) {
			System.out.print("Lorry removed");
			removeLorry();
		} else if (source.equals("Add minibus")) {
			System.out.println("Minibus added");
			addMinibus();
		} else if (source.equals("Hire minibus")) {
			System.out.println("Minibus hired");
			hireMinibus();
		} else if (source.equals("Remove minibus")) {
			System.out.print("Minibus removed");
			removeMinibus();
		} else if (source.equals("Select")) {
			System.out.println("Customer selected");
			getCustomerDetails();
		} else if (source.equals("Return")) {
			System.out.println("Vehicle returned");
			returnVehicle();
		}
	}

}
