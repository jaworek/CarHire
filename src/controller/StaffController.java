package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import model.MainModel;
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
		String[] columnNames = { "Name", "Address", "Phone number", "Email", "Date of Birth" };

		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

		for (Customer customer : mainModel.getCustomers()) {
			String name = customer.getName();
			String address = customer.getAddress();
			String phoneNumber = customer.getPhoneNumber();
			String email = customer.getEmail();
			String dateOfBirth = customer.getDateOfBirth();

			Object[] data = { name, address, phoneNumber, email, dateOfBirth };

			tableModel.addRow(data);
		}

		return tableModel;
	}

	public DefaultTableModel generateAvailableVehiclesTable() {
		String[] columnNames = { "Model", "Top Speed", "Registration number", "Hire rate" };

		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

		for (Vehicle vehicle : mainModel.getVehicles()) {
			String model = vehicle.getModel();
			int topSpeed = vehicle.getTopSpeed();
			String registrationNumber = vehicle.getRegistrationNumber();
			double hireRate = vehicle.getDailyHireRate();

			Object[] data = { model, topSpeed, registrationNumber, hireRate };

			tableModel.addRow(data);
		}

		return tableModel;
	}

	public DefaultComboBoxModel generateListOfCustomers() {
		for (Customer customer : mainModel.getCustomers()) {

		}

		return new DefaultComboBoxModel();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String source = event.getActionCommand();

		System.out.println(source);

		if (source.equals("Add")) {
			if (staffView.getSelectedItem().equals("Car")) {
				System.out.println("bob");
				vehicleController.addVehicle("Tesla", 300, "XL456", 90.99, "Electric", 5);
			} else if (staffView.getSelectedItem().equals("Lorry")) {
				System.out.println("bob2");
			} else if (staffView.getSelectedItem().equals("MiniBus")) {
				System.out.println("bob3");
			}
		} else if (source.equals("comboBoxChanged")) {
			if (staffView.getSelectedItem().equals("Car")) {
				System.out.println("bob");
				// staffView.get
			} else if (staffView.getSelectedItem().equals("Lorry")) {
				System.out.println("bob2");
			} else if (staffView.getSelectedItem().equals("MiniBus")) {
				System.out.println("bob3");
			}
		} else if (source.equals("Select")) {
			System.out.println(staffView.getTableCustomers().getSelectedRow());
		} else if (source.equals("Remove")) {
			System.out.println("Car removed");
		}
	}

}
