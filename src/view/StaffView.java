package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.StaffController;
import net.miginfocom.swing.MigLayout;
import objects.Customer;
import objects.CustomerWrapper;
import objects.Vehicle;

public class StaffView extends AbstractView {
	private JTextField textCarModel;
	private JTextField textCarTopSpeed;
	private JTextField textCarRegistrationNumber;
	private JTextField textCarHireRate;
	private JTable tableCustomers;
	private JTextField textName;
	private JTextField textAddress;
	private JTextField textPhoneNumber;
	private JTextField textEmail;
	private JTextField textDateOfBirth;
	private JTextField textCarFuel;
	private JTextField textCarDoors;
	private JTextField textLorryModel;
	private JTextField textLorryTopSpeed;
	private JTextField textLorryRegistration;
	private JTextField textLorryHireRate;
	private JTextField textLorryLoadingCapacity;
	private JTable tableCars;
	private JTable tableHiredVehicles;
	private JTextField textMinibusModel;
	private JTextField textMinibusTopSpeed;
	private JTextField textMinibusRegistration;
	private JTextField textMinibusHireRate;
	private JTextField textMinibusSeating;
	private JTable tableMinibuses;
	private JTable tableLorries;
	private JComboBox comboBoxCars;
	private JComboBox comboBoxLorry;
	private JComboBox comboBoxMinibus;

	/**
	 * Create the panel.
	 */
	public StaffView(StaffController staffController) {
		super(staffController);
		setLayout(new MigLayout("", "[600.00,grow][grow]", "[21px,grow]"));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, "cell 0 0 2 1,grow");

		// Car panel
		JPanel panelCar = new JPanel();
		tabbedPane.addTab("Cars", null, panelCar, null);
		panelCar.setLayout(new MigLayout("", "[450.00][102px][]", "[][16px][][][][][][][][][][][][]"));

		JLabel lblAddNewCar = new JLabel("Add new car");
		panelCar.add(lblAddNewCar, "cell 1 0 2 1,alignx center,aligny top");

		JLabel lblCarModel = new JLabel("Model");
		panelCar.add(lblCarModel, "cell 1 2,alignx trailing");

		textCarModel = new JTextField();
		panelCar.add(textCarModel, "cell 2 2,growx");
		textCarModel.setColumns(10);

		JLabel lblTopSpeed = new JLabel("Top speed");
		panelCar.add(lblTopSpeed, "cell 1 3,alignx trailing");

		textCarTopSpeed = new JTextField();
		panelCar.add(textCarTopSpeed, "cell 2 3,growx");
		textCarTopSpeed.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Registration number");
		panelCar.add(lblNewLabel_1, "cell 1 4,alignx trailing");

		textCarRegistrationNumber = new JTextField();
		panelCar.add(textCarRegistrationNumber, "cell 2 4,growx");
		textCarRegistrationNumber.setColumns(10);

		JPanel panel_1 = new JPanel();
		panelCar.add(panel_1, "cell 0 0 1 14,grow");
		panel_1.setLayout(new MigLayout("", "[568.00px]", "[404px]"));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "cell 0 0,alignx left,aligny top");

		tableCars = new JTable(staffController.generateAvailableCarsTable());
		scrollPane.setViewportView(tableCars);

		JLabel lblHireRate = new JLabel("Hire rate");
		panelCar.add(lblHireRate, "cell 1 5,alignx trailing");

		textCarHireRate = new JTextField();
		panelCar.add(textCarHireRate, "cell 2 5,growx");
		textCarHireRate.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Fuel type");
		panelCar.add(lblNewLabel_3, "cell 1 6,alignx trailing");

		textCarFuel = new JTextField();
		panelCar.add(textCarFuel, "cell 2 6,growx");
		textCarFuel.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Number of doors");
		panelCar.add(lblNewLabel_4, "cell 1 7,alignx trailing");

		textCarDoors = new JTextField();
		panelCar.add(textCarDoors, "cell 2 7,growx");
		textCarDoors.setColumns(10);

		JButton btnNewButton = new JButton("Add car");
		btnNewButton.addActionListener(staffController);
		panelCar.add(btnNewButton, "cell 1 8 2 1,alignx center");

		JLabel label = new JLabel("Hire to customer:");
		panelCar.add(label, "cell 1 9 2 1,alignx center");

		comboBoxCars = new JComboBox();
		comboBoxCars.addActionListener(staffController);
		comboBoxCars.setActionCommand("comboCarCustomers");
		panelCar.add(comboBoxCars, "cell 1 10 2 1,growx");

		JButton buttonHireCar = new JButton("Hire car");
		buttonHireCar.addActionListener(staffController);
		panelCar.add(buttonHireCar, "cell 1 11 2 1,alignx center");

		JLabel label_1 = new JLabel("Remove selected vehicle:");
		panelCar.add(label_1, "cell 1 12 2 1,alignx center");

		JButton buttonRemoveCar = new JButton("Remove car");
		buttonRemoveCar.addActionListener(staffController);
		panelCar.add(buttonRemoveCar, "cell 1 13 2 1,alignx center");

		// Lorry panel
		JPanel panelLorry = new JPanel();
		tabbedPane.addTab("Lorries", null, panelLorry, null);
		panelLorry.setLayout(new MigLayout("", "[450][112.00,grow][grow]", "[][][][][][][][][][][][]"));

		JLabel lblAddNewLorry = new JLabel("Add new lorry");
		panelLorry.add(lblAddNewLorry, "cell 1 0 2 1,alignx center");

		JPanel panel_3 = new JPanel();
		panelLorry.add(panel_3, "cell 0 0 1 12,grow");
		panel_3.setLayout(new MigLayout("", "[454px]", "[404px]"));

		JScrollPane scrollPane_4 = new JScrollPane();
		panel_3.add(scrollPane_4, "cell 0 0,alignx left,aligny top");

		tableLorries = new JTable(staffController.generateAvailableLorriesTable());
		scrollPane_4.setViewportView(tableLorries);

		JLabel lblModel = new JLabel("Model");
		panelLorry.add(lblModel, "cell 1 1,alignx trailing");

		textLorryModel = new JTextField();
		panelLorry.add(textLorryModel, "cell 2 1,growx");
		textLorryModel.setColumns(10);

		JLabel lblTopSpeed_1 = new JLabel("Top speed");
		panelLorry.add(lblTopSpeed_1, "cell 1 2,alignx trailing");

		textLorryTopSpeed = new JTextField();
		panelLorry.add(textLorryTopSpeed, "cell 2 2,growx");
		textLorryTopSpeed.setColumns(10);

		JLabel lblRegistrationNumber = new JLabel("Registration number");
		panelLorry.add(lblRegistrationNumber, "cell 1 3,alignx trailing");

		textLorryRegistration = new JTextField();
		panelLorry.add(textLorryRegistration, "cell 2 3,growx");
		textLorryRegistration.setColumns(10);

		JLabel lblHireRate_1 = new JLabel("Hire rate");
		panelLorry.add(lblHireRate_1, "cell 1 4,alignx trailing");

		textLorryHireRate = new JTextField();
		panelLorry.add(textLorryHireRate, "cell 2 4,growx");
		textLorryHireRate.setColumns(10);

		JLabel lblLoadingCapacity = new JLabel("Loading capacity");
		panelLorry.add(lblLoadingCapacity, "cell 1 5,alignx trailing");

		textLorryLoadingCapacity = new JTextField();
		panelLorry.add(textLorryLoadingCapacity, "cell 2 5,growx");
		textLorryLoadingCapacity.setColumns(10);

		JButton buttonAddLorry = new JButton("Add lorry");
		buttonAddLorry.addActionListener(staffController);
		panelLorry.add(buttonAddLorry, "cell 1 6 2 1,alignx center");

		JLabel label_2 = new JLabel("Hire to customer:");
		panelLorry.add(label_2, "cell 1 7 2 1,alignx center");

		comboBoxLorry = new JComboBox();
		comboBoxLorry.addActionListener(staffController);
		comboBoxLorry.setActionCommand("comboLorryCustomers");
		panelLorry.add(comboBoxLorry, "cell 1 8 2 1,growx");

		JButton buttonHireLorry = new JButton("Hire lorry");
		buttonHireLorry.addActionListener(staffController);
		panelLorry.add(buttonHireLorry, "cell 1 9 2 1,alignx center");

		JLabel label_8 = new JLabel("Remove selected vehicle:");
		panelLorry.add(label_8, "cell 1 10 2 1,alignx center");

		JButton button = new JButton("Remove lorry");
		button.addActionListener(staffController);
		panelLorry.add(button, "cell 1 11 2 1,alignx center");

		// Minibus panel
		JPanel panelMinibus = new JPanel();
		tabbedPane.addTab("Minibuses", null, panelMinibus, null);
		panelMinibus.setLayout(new MigLayout("", "[450][grow][grow]", "[][][][][][][][][][][][43.00]"));

		JPanel panel_2 = new JPanel();
		panelMinibus.add(panel_2, "cell 0 0 1 12,grow");
		panel_2.setLayout(new MigLayout("", "[454px]", "[404px]"));

		JScrollPane scrollPane_2 = new JScrollPane();
		panel_2.add(scrollPane_2, "cell 0 0,alignx left,aligny top");

		tableMinibuses = new JTable(staffController.generateAvailableMinibusTable());
		scrollPane_2.setViewportView(tableMinibuses);

		JLabel labelAddMinibus = new JLabel("Add new minibus");
		panelMinibus.add(labelAddMinibus, "cell 1 0 2 1,alignx center");

		JLabel labelModel = new JLabel("Model");
		panelMinibus.add(labelModel, "cell 1 1,alignx trailing");

		textMinibusModel = new JTextField();
		textMinibusModel.setColumns(10);
		panelMinibus.add(textMinibusModel, "cell 2 1,growx");

		JLabel label_4 = new JLabel("Top speed");
		panelMinibus.add(label_4, "cell 1 2,alignx trailing");

		textMinibusTopSpeed = new JTextField();
		panelMinibus.add(textMinibusTopSpeed, "cell 2 2,growx");
		textMinibusTopSpeed.setColumns(10);

		JLabel label_5 = new JLabel("Registration number");
		panelMinibus.add(label_5, "cell 1 3,alignx trailing");

		textMinibusRegistration = new JTextField();
		panelMinibus.add(textMinibusRegistration, "cell 2 3,growx");
		textMinibusRegistration.setColumns(10);

		JLabel label_6 = new JLabel("Hire rate");
		panelMinibus.add(label_6, "cell 1 4,alignx trailing");

		textMinibusHireRate = new JTextField();
		panelMinibus.add(textMinibusHireRate, "cell 2 4,growx");
		textMinibusHireRate.setColumns(10);

		JLabel lblSeatingCapacity = new JLabel("Seating capacity");
		panelMinibus.add(lblSeatingCapacity, "cell 1 5,alignx trailing");

		textMinibusSeating = new JTextField();
		panelMinibus.add(textMinibusSeating, "cell 2 5,growx");
		textMinibusSeating.setColumns(10);

		JButton btnAddMinibus = new JButton("Add minibus");
		btnAddMinibus.addActionListener(staffController);
		panelMinibus.add(btnAddMinibus, "cell 1 6 2 1,alignx center");

		JLabel label_3 = new JLabel("Hire to customer:");
		panelMinibus.add(label_3, "cell 1 7 2 1,alignx center");

		comboBoxMinibus = new JComboBox();
		comboBoxMinibus.addActionListener(staffController);
		comboBoxMinibus.setActionCommand("comboMinibusCustomers");
		panelMinibus.add(comboBoxMinibus, "cell 1 8 2 1,growx");

		JButton buttonHireMinibus = new JButton("Hire minibus");
		buttonHireMinibus.addActionListener(staffController);
		panelMinibus.add(buttonHireMinibus, "cell 1 9 2 1,alignx center");

		JLabel label_7 = new JLabel("Remove selected vehicle:");
		panelMinibus.add(label_7, "cell 1 10 2 1,alignx center");

		JButton buttonMinibus = new JButton("Remove minibus");
		buttonMinibus.addActionListener(staffController);
		panelMinibus.add(buttonMinibus, "cell 1 11 2 1,alignx center");

		JPanel panelCustomers = new JPanel();
		tabbedPane.addTab("Customers", null, panelCustomers, null);
		panelCustomers.setLayout(new MigLayout("", "[265.00px][grow]", "[404px,grow][]"));

		JScrollPane scrollPaneCustomers = new JScrollPane();
		panelCustomers.add(scrollPaneCustomers, "cell 0 0,alignx left,aligny top");

		tableCustomers = new JTable(staffController.generateCustomerTable());
		scrollPaneCustomers.setViewportView(tableCustomers);

		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(staffController);

		JPanel panel = new JPanel();
		panelCustomers.add(panel, "cell 1 0,grow");
		panel.setLayout(new MigLayout("", "[107px,grow][grow]", "[16px][][][][][][][grow][grow][]"));

		JLabel lblCustomerDetails = new JLabel("Customer details");
		panel.add(lblCustomerDetails, "cell 0 0 2 1,alignx center,aligny top");

		JLabel lblName = new JLabel("Name");
		panel.add(lblName, "cell 0 1,alignx trailing");

		textName = new JTextField();
		textName.setEditable(false);
		panel.add(textName, "cell 1 1,growx");
		textName.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Address");
		panel.add(lblNewLabel_2, "cell 0 2,alignx trailing");

		textAddress = new JTextField();
		textAddress.setEditable(false);
		panel.add(textAddress, "cell 1 2,growx");
		textAddress.setColumns(10);

		JLabel lblPhoneNumber = new JLabel("Phone number");
		panel.add(lblPhoneNumber, "cell 0 3,alignx trailing");

		textPhoneNumber = new JTextField();
		textPhoneNumber.setEditable(false);
		panel.add(textPhoneNumber, "cell 1 3,growx");
		textPhoneNumber.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		panel.add(lblEmail, "cell 0 4,alignx trailing");

		textEmail = new JTextField();
		textEmail.setEditable(false);
		panel.add(textEmail, "cell 1 4,growx");
		textEmail.setColumns(10);

		JLabel lblDateOfBirth = new JLabel("Date of birth");
		panel.add(lblDateOfBirth, "cell 0 5,alignx trailing");

		textDateOfBirth = new JTextField();
		textDateOfBirth.setEditable(false);
		panel.add(textDateOfBirth, "cell 1 5,growx");
		textDateOfBirth.setColumns(10);

		JLabel lblHiredCars = new JLabel("Hired cars");
		panel.add(lblHiredCars, "cell 0 6 2 1,alignx center");

		JScrollPane scrollPaneCustomerCars = new JScrollPane();
		panel.add(scrollPaneCustomerCars, "cell 0 7 2 3,grow");

		tableHiredVehicles = new JTable();
		scrollPaneCustomerCars.setViewportView(tableHiredVehicles);
		panelCustomers.add(btnSelect, "cell 0 1,alignx center");

		JButton btnReturn = new JButton("Return");
		panelCustomers.add(btnReturn, "cell 1 1,alignx center");
		btnReturn.addActionListener(staffController);
	}

	public JTextField getTextCarModel() {
		return textCarModel;
	}

	public void setTextCarModel(JTextField textCarModel) {
		this.textCarModel = textCarModel;
	}

	public JTextField getTextCarTopSpeed() {
		return textCarTopSpeed;
	}

	public void setTextCarTopSpeed(JTextField textCarTopSpeed) {
		this.textCarTopSpeed = textCarTopSpeed;
	}

	public JTextField getTextCarRegistrationNumber() {
		return textCarRegistrationNumber;
	}

	public void setTextCarRegistrationNumber(JTextField textCarRegistrationNumber) {
		this.textCarRegistrationNumber = textCarRegistrationNumber;
	}

	public JTextField getTextCarHireRate() {
		return textCarHireRate;
	}

	public void setTextCarHireRate(JTextField textCarHireRate) {
		this.textCarHireRate = textCarHireRate;
	}

	public JTextField getTextName() {
		return textName;
	}

	public void setTextName(JTextField textName) {
		this.textName = textName;
	}

	public JTextField getTextAddress() {
		return textAddress;
	}

	public void setTextAddress(JTextField textAddress) {
		this.textAddress = textAddress;
	}

	public JTextField getTextPhoneNumber() {
		return textPhoneNumber;
	}

	public void setTextPhoneNumber(JTextField textPhoneNumber) {
		this.textPhoneNumber = textPhoneNumber;
	}

	public JTextField getTextEmail() {
		return textEmail;
	}

	public void setTextEmail(JTextField textEmail) {
		this.textEmail = textEmail;
	}

	public JTextField getTextDateOfBirth() {
		return textDateOfBirth;
	}

	public void setTextDateOfBirth(JTextField textDateOfBirth) {
		this.textDateOfBirth = textDateOfBirth;
	}

	public JTextField getTextCarFuel() {
		return textCarFuel;
	}

	public void setTextCarFuel(JTextField textCarFuel) {
		this.textCarFuel = textCarFuel;
	}

	public JTextField getTextCarDoors() {
		return textCarDoors;
	}

	public void setTextCarDoors(JTextField textCarDoors) {
		this.textCarDoors = textCarDoors;
	}

	public JTextField getTextLorryModel() {
		return textLorryModel;
	}

	public void setTextLorryModel(JTextField textLorryModel) {
		this.textLorryModel = textLorryModel;
	}

	public JTextField getTextLorryTopSpeed() {
		return textLorryTopSpeed;
	}

	public void setTextLorryTopSpeed(JTextField textLorryTopSpeed) {
		this.textLorryTopSpeed = textLorryTopSpeed;
	}

	public JTextField getTextLorryRegistration() {
		return textLorryRegistration;
	}

	public void setTextLorryRegistration(JTextField textLorryRegistration) {
		this.textLorryRegistration = textLorryRegistration;
	}

	public JTextField getTextLorryHireRate() {
		return textLorryHireRate;
	}

	public void setTextLorryHireRate(JTextField textLorryHireRate) {
		this.textLorryHireRate = textLorryHireRate;
	}

	public JTextField getTextLorryLoadingCapacity() {
		return textLorryLoadingCapacity;
	}

	public void setTextLorryLoadingCapacity(JTextField textLorryLoadingCapacity) {
		this.textLorryLoadingCapacity = textLorryLoadingCapacity;
	}

	public JTable getTableCars() {
		return tableCars;
	}

	public void setTableCars(JTable table) {
		this.tableCars = table;
	}

	public JTable getTableHiredVehicles() {
		return tableHiredVehicles;
	}

	public void setTableHiredVehicles(JTable tableHiredVehicles) {
		this.tableHiredVehicles = tableHiredVehicles;
	}

	public JTextField getTextMinibusModel() {
		return textMinibusModel;
	}

	public void setTextMinibusModel(JTextField textMinibusModel) {
		this.textMinibusModel = textMinibusModel;
	}

	public JTextField getTextMinibusTopSpeed() {
		return textMinibusTopSpeed;
	}

	public void setTextMinibusTopSpeed(JTextField textMinibusTopSpeed) {
		this.textMinibusTopSpeed = textMinibusTopSpeed;
	}

	public JTextField getTextMinibusRegistration() {
		return textMinibusRegistration;
	}

	public void setTextMinibusRegistration(JTextField textMinibusRegistration) {
		this.textMinibusRegistration = textMinibusRegistration;
	}

	public JTextField getTextMinibusHireRate() {
		return textMinibusHireRate;
	}

	public void setTextMinibusHireRate(JTextField textMinibusHireRate) {
		this.textMinibusHireRate = textMinibusHireRate;
	}

	public JTextField getTextMinibusSeating() {
		return textMinibusSeating;
	}

	public void setTextMinibusSeating(JTextField textMinibusSeating) {
		this.textMinibusSeating = textMinibusSeating;
	}

	public JTable getTableMinibuses() {
		return tableMinibuses;
	}

	public void setTableMinibuses(JTable tableMinibuses) {
		this.tableMinibuses = tableMinibuses;
	}

	public JTable getTableLorries() {
		return tableLorries;
	}

	public void setTableLorries(JTable tableLorries) {
		this.tableLorries = tableLorries;
	}

	public JTextField getTextModel() {
		return textCarModel;
	}

	public void setTextModel(JTextField textModel) {
		this.textCarModel = textModel;
	}

	public JTextField getTextTopSpeed() {
		return textCarTopSpeed;
	}

	public void setTextTopSpeed(JTextField textTopSpeed) {
		this.textCarTopSpeed = textTopSpeed;
	}

	public void setTextRegistrationNumber(JTextField textRegistrationNumber) {
		this.textCarRegistrationNumber = textRegistrationNumber;
	}

	public void setTextHireRate(JTextField textHireRate) {
		this.textCarHireRate = textHireRate;
	}

	public JTable getTableCustomers() {
		return tableCustomers;
	}

	public void setTableCustomers(JTable tableCustomers) {
		this.tableCustomers = tableCustomers;
	}

	public JComboBox getComboBoxCars() {
		return comboBoxCars;
	}

	public void setComboBoxCars(JComboBox comboBoxCars) {
		this.comboBoxCars = comboBoxCars;
	}

	public JComboBox getComboBoxLorry() {
		return comboBoxLorry;
	}

	public void setComboBoxLorry(JComboBox comboBoxLorry) {
		this.comboBoxLorry = comboBoxLorry;
	}

	public JComboBox getComboBoxMinibus() {
		return comboBoxMinibus;
	}

	public void setComboBoxMinibus(JComboBox comboBoxMinibus) {
		this.comboBoxMinibus = comboBoxMinibus;
	}

	public void fillCustomerDetails(Customer customer) {
		getTextName().setText(customer.getName());
		getTextAddress().setText(customer.getAddress());
		getTextPhoneNumber().setText(customer.getPhoneNumber());
		getTextEmail().setText(customer.getEmail());
		getTextDateOfBirth().setText(customer.getDateOfBirth());
	}

	public DefaultTableModel generateCustomerVehiclesTable(String[] columnNames, ArrayList<Vehicle> hiredCars) {
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

		for (Vehicle vehicle : hiredCars) {
			int id = vehicle.getId();
			String model = vehicle.getModel();
			String type = vehicle.getClass().getSimpleName();

			Object[] data = { id, model, type };

			tableModel.addRow(data);
		}

		return tableModel;
	}

	public void setHiredCarsModel(String[] columnNames, ArrayList<Vehicle> hiredCars) {
		getTableHiredVehicles().setModel(generateCustomerVehiclesTable(columnNames, hiredCars));
	}

	public void generateCustomerComboBox(List<Customer> customers) {
		for (Customer customer : customers) {
			comboBoxCars.addItem(new CustomerWrapper(customer));
			comboBoxLorry.addItem(new CustomerWrapper(customer));
			comboBoxMinibus.addItem(new CustomerWrapper(customer));
		}
	}

}
