package view;

import javax.swing.DefaultComboBoxModel;
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
	private JTable tableVehicles;
	private JTable tableCustomers;
	private JComboBox comboBoxVehicles;
	private JComboBox comboBoxCustomers;
	private JTable tableAvailableVehicles;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the panel.
	 */
	public StaffView(StaffController staffController) {
		super(staffController);
		setLayout(new MigLayout("", "[450.00,grow][grow]", "[21px,grow]"));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, "cell 0 0 2 1,grow");

		JPanel panelAddCar = new JPanel();
		tabbedPane.addTab("Add vehicle", null, panelAddCar, null);
		panelAddCar.setLayout(new MigLayout("", "[102px][grow]", "[][16px][][][][][][][]"));

		comboBoxVehicles = new JComboBox();
		comboBoxVehicles.addActionListener(staffController);
		comboBoxVehicles.setModel(new DefaultComboBoxModel(new String[] { "Car", "Lorry", "MiniBus" }));
		panelAddCar.add(comboBoxVehicles, "cell 0 0 2 1,growx");

		JLabel lblAddNewVehicle = new JLabel("Add new vehicle");
		panelAddCar.add(lblAddNewVehicle, "cell 0 1 2 1,alignx center,aligny top");

		JLabel lblNewLabel = new JLabel("Model");
		panelAddCar.add(lblNewLabel, "cell 0 2,alignx trailing");

		textModel = new JTextField();
		panelAddCar.add(textModel, "cell 1 2,growx");
		textModel.setColumns(10);

		JLabel lblTopSpeed = new JLabel("Top speed");
		panelAddCar.add(lblTopSpeed, "cell 0 3,alignx trailing");

		textTopSpeed = new JTextField();
		panelAddCar.add(textTopSpeed, "cell 1 3,growx");
		textTopSpeed.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Registration number");
		panelAddCar.add(lblNewLabel_1, "cell 0 4,alignx trailing");

		textRegistrationNumber = new JTextField();
		panelAddCar.add(textRegistrationNumber, "cell 1 4,growx");
		textRegistrationNumber.setColumns(10);

		JLabel lblHireRate = new JLabel("Hire rate");
		panelAddCar.add(lblHireRate, "cell 0 5,alignx trailing");

		textHireRate = new JTextField();
		panelAddCar.add(textHireRate, "cell 1 5,growx");
		textHireRate.setColumns(10);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(staffController);

		JLabel lblNewLabel_3 = new JLabel("Fuel type");
		panelAddCar.add(lblNewLabel_3, "cell 0 6,alignx trailing");

		textField_5 = new JTextField();
		panelAddCar.add(textField_5, "cell 1 6,growx");
		textField_5.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Number of doors");
		panelAddCar.add(lblNewLabel_4, "cell 0 7,alignx trailing");

		textField_6 = new JTextField();
		panelAddCar.add(textField_6, "cell 1 7,growx");
		textField_6.setColumns(10);
		panelAddCar.add(btnNewButton, "cell 0 8 2 1,alignx center");

		JPanel panelHireCar = new JPanel();
		tabbedPane.addTab("Hire vehicle", null, panelHireCar, null);
		panelHireCar.setLayout(new MigLayout("", "[150.00px][grow]", "[][404px]"));

		JLabel lblCustomer = new JLabel("Customer:");
		panelHireCar.add(lblCustomer, "cell 0 0,alignx trailing");

		comboBoxCustomers = new JComboBox();
		comboBoxCustomers.addActionListener(staffController);
		comboBoxCustomers.setModel(new DefaultComboBoxModel(new String[] { "Car", "Lorry", "MiniBus" }));
		panelHireCar.add(comboBoxCustomers, "cell 1 0,growx");

		JScrollPane scrollPane_2 = new JScrollPane();
		panelHireCar.add(scrollPane_2, "cell 0 1 2 1,alignx left,aligny top");

		tableAvailableVehicles = new JTable();
		scrollPane_2.setViewportView(tableAvailableVehicles);

		JPanel panelRemoveCar = new JPanel();
		tabbedPane.addTab("Remove vehicle", null, panelRemoveCar, null);
		panelRemoveCar.setLayout(new MigLayout("", "[454px]", "[404px]"));

		JScrollPane scrollPane = new JScrollPane();
		panelRemoveCar.add(scrollPane, "flowy,cell 0 0,alignx left,aligny top");

		tableVehicles = new JTable(staffController.generateAvailableVehiclesTable());
		scrollPane.setViewportView(tableVehicles);

		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(staffController);
		panelRemoveCar.add(btnRemove, "cell 0 0,alignx center");

		JPanel panelCustomers = new JPanel();
		tabbedPane.addTab("Customers", null, panelCustomers, null);
		panelCustomers.setLayout(new MigLayout("", "[454px][grow]", "[404px,grow][]"));

		JScrollPane scrollPane_1 = new JScrollPane();
		panelCustomers.add(scrollPane_1, "cell 0 0,alignx left,aligny top");

		tableCustomers = new JTable(staffController.generateCustomerTable());
		scrollPane_1.setViewportView(tableCustomers);

		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(staffController);

		JPanel panel = new JPanel();
		panelCustomers.add(panel, "cell 1 0,grow");
		panel.setLayout(new MigLayout("", "[107px][grow]", "[16px][][][][][]"));

		JLabel lblCustomerDetails = new JLabel("Customer details");
		panel.add(lblCustomerDetails, "cell 0 0 2 1,alignx center,aligny top");

		JLabel lblName = new JLabel("Name");
		panel.add(lblName, "cell 0 1,alignx trailing");

		textField = new JTextField();
		panel.add(textField, "cell 1 1,growx");
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Address");
		panel.add(lblNewLabel_2, "cell 0 2,alignx trailing");

		textField_1 = new JTextField();
		panel.add(textField_1, "cell 1 2,growx");
		textField_1.setColumns(10);

		JLabel lblPhoneNumber = new JLabel("Phone number");
		panel.add(lblPhoneNumber, "cell 0 3,alignx trailing");

		textField_2 = new JTextField();
		panel.add(textField_2, "cell 1 3,growx");
		textField_2.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		panel.add(lblEmail, "cell 0 4,alignx trailing");

		textField_3 = new JTextField();
		panel.add(textField_3, "cell 1 4,growx");
		textField_3.setColumns(10);

		JLabel lblDateOfBirth = new JLabel("Date of birth");
		panel.add(lblDateOfBirth, "cell 0 5,alignx trailing");

		textField_4 = new JTextField();
		panel.add(textField_4, "cell 1 5,growx");
		textField_4.setColumns(10);
		panelCustomers.add(btnSelect, "cell 0 1,alignx center");
	}

	public String getSelectedItem() {
		return (String) comboBoxVehicles.getSelectedItem();
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

	public JTable getTableVehicles() {
		return tableVehicles;
	}

	public void setTableVehicles(JTable tableVehicles) {
		this.tableVehicles = tableVehicles;
	}

	public JTable getTableCustomers() {
		return tableCustomers;
	}

	public void setTableCustomers(JTable tableCustomers) {
		this.tableCustomers = tableCustomers;
	}

}
