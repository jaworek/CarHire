package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.StaffController;
import net.miginfocom.swing.MigLayout;

public class StaffView extends AbstractView {
	private JTextField textModel;
	private JTextField textTopSpeed;
	private JTextField textRegistrationNumber;
	private JTextField textHireRate;
	private JTable tableCustomers;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textFuel;
	private JTextField textDoors;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTable table;
	private JTable table_1;
	private JTextField textField_10;

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
		panelCar.setLayout(new MigLayout("", "[415.00,grow][102px][]", "[][16px][][][][][][][][][][][][]"));

		JLabel lblAddNewVehicle = new JLabel("Add new car");
		panelCar.add(lblAddNewVehicle, "cell 1 0 2 1,alignx center,aligny top");

		JLabel lblNewLabel = new JLabel("Model");
		panelCar.add(lblNewLabel, "cell 1 2,alignx trailing");

		textModel = new JTextField();
		panelCar.add(textModel, "cell 2 2,growx");
		textModel.setColumns(10);

		JLabel lblTopSpeed = new JLabel("Top speed");
		panelCar.add(lblTopSpeed, "cell 1 3,alignx trailing");

		textTopSpeed = new JTextField();
		panelCar.add(textTopSpeed, "cell 2 3,growx");
		textTopSpeed.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Registration number");
		panelCar.add(lblNewLabel_1, "cell 1 4,alignx trailing");

		textRegistrationNumber = new JTextField();
		panelCar.add(textRegistrationNumber, "cell 2 4,growx");
		textRegistrationNumber.setColumns(10);

		JPanel panel_1 = new JPanel();
		panelCar.add(panel_1, "cell 0 0 1 14,grow");
		panel_1.setLayout(new MigLayout("", "[568.00px]", "[404px]"));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "cell 0 0,alignx left,aligny top");

		table = new JTable(staffController.generateAvailableCarsTable());
		scrollPane.setViewportView(table);

		JLabel lblHireRate = new JLabel("Hire rate");
		panelCar.add(lblHireRate, "cell 1 5,alignx trailing");

		textHireRate = new JTextField();
		panelCar.add(textHireRate, "cell 2 5,growx");
		textHireRate.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Fuel type");
		panelCar.add(lblNewLabel_3, "cell 1 6,alignx trailing");

		textFuel = new JTextField();
		panelCar.add(textFuel, "cell 2 6,growx");
		textFuel.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Number of doors");
		panelCar.add(lblNewLabel_4, "cell 1 7,alignx trailing");

		textDoors = new JTextField();
		panelCar.add(textDoors, "cell 2 7,growx");
		textDoors.setColumns(10);

		JButton btnNewButton = new JButton("Add car");
		btnNewButton.addActionListener(staffController);
		panelCar.add(btnNewButton, "cell 1 8 2 1,alignx center");

		JLabel label = new JLabel("Hire to customer:");
		panelCar.add(label, "cell 1 9 2 1,alignx center");

		JComboBox comboBox = new JComboBox();
		comboBox.setActionCommand("comboCustomers");
		panelCar.add(comboBox, "cell 1 10 2 1,growx");

		JButton button_1 = new JButton("Hire");
		panelCar.add(button_1, "cell 1 11 2 1,alignx center");

		JLabel label_1 = new JLabel("Remove selected vehicle:");
		panelCar.add(label_1, "cell 1 12 2 1,alignx center");

		JButton button = new JButton("Remove");
		panelCar.add(button, "cell 1 13 2 1,alignx center");

		// Lorry panel
		JPanel panelLorry = new JPanel();
		tabbedPane.addTab("Lorries", null, panelLorry, null);
		panelLorry.setLayout(new MigLayout("", "[112.00][grow]", "[][][][][][][]"));

		JLabel lblAddNewLorry = new JLabel("Add new lorry");
		panelLorry.add(lblAddNewLorry, "cell 0 0 2 1,alignx center");

		JLabel lblModel = new JLabel("Model");
		panelLorry.add(lblModel, "cell 0 1,alignx trailing");

		textField_5 = new JTextField();
		panelLorry.add(textField_5, "cell 1 1,growx");
		textField_5.setColumns(10);

		JLabel lblTopSpeed_1 = new JLabel("Top speed");
		panelLorry.add(lblTopSpeed_1, "cell 0 2,alignx trailing");

		textField_6 = new JTextField();
		panelLorry.add(textField_6, "cell 1 2,growx");
		textField_6.setColumns(10);

		JLabel lblRegistrationNumber = new JLabel("Registration number");
		panelLorry.add(lblRegistrationNumber, "cell 0 3,alignx trailing");

		textField_7 = new JTextField();
		panelLorry.add(textField_7, "cell 1 3,growx");
		textField_7.setColumns(10);

		JLabel lblHireRate_1 = new JLabel("Hire rate");
		panelLorry.add(lblHireRate_1, "cell 0 4,alignx trailing");

		textField_8 = new JTextField();
		panelLorry.add(textField_8, "cell 1 4,growx");
		textField_8.setColumns(10);

		JLabel lblLoadingCapacity = new JLabel("Loading capacity");
		panelLorry.add(lblLoadingCapacity, "cell 0 5,alignx trailing");

		textField_9 = new JTextField();
		panelLorry.add(textField_9, "cell 1 5,growx");
		textField_9.setColumns(10);

		JButton btnAddLorry = new JButton("Add lorry");
		panelLorry.add(btnAddLorry, "cell 0 6 2 1,alignx center");

		// Minibus panel
		JPanel panelMinibus = new JPanel();
		tabbedPane.addTab("Minibuses", null, panelMinibus, null);
		panelMinibus.setLayout(new MigLayout("", "[][grow]", "[][]"));

		JLabel lblAddNewMinibus = new JLabel("Add new minibus");
		panelMinibus.add(lblAddNewMinibus, "cell 0 0 2 1");

		JLabel lblModel_1 = new JLabel("Model");
		panelMinibus.add(lblModel_1, "cell 0 1,alignx trailing");

		textField_10 = new JTextField();
		panelMinibus.add(textField_10, "cell 1 1,growx");
		textField_10.setColumns(10);

		JPanel panelCustomers = new JPanel();
		tabbedPane.addTab("Customers", null, panelCustomers, null);
		panelCustomers.setLayout(new MigLayout("", "[265.00px][grow]", "[404px,grow][]"));

		JScrollPane scrollPane_1 = new JScrollPane();
		panelCustomers.add(scrollPane_1, "cell 0 0,alignx left,aligny top");

		tableCustomers = new JTable(staffController.generateCustomerTable());
		scrollPane_1.setViewportView(tableCustomers);

		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(staffController);

		JPanel panel = new JPanel();
		panelCustomers.add(panel, "cell 1 0,grow");
		panel.setLayout(new MigLayout("", "[107px,grow][grow]", "[16px][][][][][][][grow][grow][]"));

		JLabel lblCustomerDetails = new JLabel("Customer details");
		panel.add(lblCustomerDetails, "cell 0 0 2 1,alignx center,aligny top");

		JLabel lblName = new JLabel("Name");
		panel.add(lblName, "cell 0 1,alignx trailing");

		textField = new JTextField();
		textField.setEditable(false);
		panel.add(textField, "cell 1 1,growx");
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Address");
		panel.add(lblNewLabel_2, "cell 0 2,alignx trailing");

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		panel.add(textField_1, "cell 1 2,growx");
		textField_1.setColumns(10);

		JLabel lblPhoneNumber = new JLabel("Phone number");
		panel.add(lblPhoneNumber, "cell 0 3,alignx trailing");

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		panel.add(textField_2, "cell 1 3,growx");
		textField_2.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		panel.add(lblEmail, "cell 0 4,alignx trailing");

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		panel.add(textField_3, "cell 1 4,growx");
		textField_3.setColumns(10);

		JLabel lblDateOfBirth = new JLabel("Date of birth");
		panel.add(lblDateOfBirth, "cell 0 5,alignx trailing");

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		panel.add(textField_4, "cell 1 5,growx");
		textField_4.setColumns(10);

		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(staffController);

		JLabel lblHiredCars = new JLabel("Hired cars");
		panel.add(lblHiredCars, "cell 0 6 2 1,alignx center");

		JScrollPane scrollPane_3 = new JScrollPane();
		panel.add(scrollPane_3, "cell 0 7 2 1,grow");

		table_1 = new JTable();
		scrollPane_3.setViewportView(table_1);
		panel.add(btnReturn, "cell 0 9 2 1,alignx center");
		panelCustomers.add(btnSelect, "cell 0 1,alignx center");
	}

	public JTextField getTextModel() {
		return textModel;
	}

	public void setTextModel(JTextField textModel) {
		this.textModel = textModel;
	}

	public JTextField getTextTopSpeed() {
		return textTopSpeed;
	}

	public void setTextTopSpeed(JTextField textTopSpeed) {
		this.textTopSpeed = textTopSpeed;
	}

	public JTextField getTextRegistrationNumber() {
		return textRegistrationNumber;
	}

	public void setTextRegistrationNumber(JTextField textRegistrationNumber) {
		this.textRegistrationNumber = textRegistrationNumber;
	}

	public JTextField getTextHireRate() {
		return textHireRate;
	}

	public void setTextHireRate(JTextField textHireRate) {
		this.textHireRate = textHireRate;
	}

	public JTable getTableCustomers() {
		return tableCustomers;
	}

	public void setTableCustomers(JTable tableCustomers) {
		this.tableCustomers = tableCustomers;
	}

}
