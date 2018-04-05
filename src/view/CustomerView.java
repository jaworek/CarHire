package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.CustomerController;
import net.miginfocom.swing.MigLayout;
import objects.Customer;

public class CustomerView extends AbstractView {
	private JTable tableHiredVehicles;
	private JTable tableAvailableVehicles;
	private JTextField textName;
	private JTextField textAddress;
	private JTextField textPhoneNumber;
	private JTextField textEmail;
	private JTextField textDoB;

	/**
	 * Create the panel.
	 */
	public CustomerView(CustomerController customerController) {
		super(customerController);

		Customer customer = customerController.getCustomer();

		setLayout(new MigLayout("", "[450.00,grow][grow]", "[362.00]"));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, "cell 0 0,grow");

		JPanel panelCustomerDetails = new JPanel();
		tabbedPane.addTab("Customer details", null, panelCustomerDetails, null);
		panelCustomerDetails.setLayout(new MigLayout("", "[36px][grow]", "[16px][][][][]"));

		JLabel lblName = new JLabel("Name");
		panelCustomerDetails.add(lblName, "cell 0 0,alignx trailing,aligny top");

		textName = new JTextField(customer.getName());
		textName.setEditable(false);
		panelCustomerDetails.add(textName, "cell 1 0,growx");
		textName.setColumns(10);

		JLabel lblAddress = new JLabel("Address");
		panelCustomerDetails.add(lblAddress, "cell 0 1,alignx trailing");

		textAddress = new JTextField(customer.getAddress());
		textAddress.setEditable(false);
		panelCustomerDetails.add(textAddress, "cell 1 1,growx");
		textAddress.setColumns(10);

		JLabel lblPhoneNumber = new JLabel("Phone number");
		panelCustomerDetails.add(lblPhoneNumber, "cell 0 2,alignx trailing");

		textPhoneNumber = new JTextField(customer.getPhoneNumber());
		textPhoneNumber.setEditable(false);
		panelCustomerDetails.add(textPhoneNumber, "cell 1 2,growx");
		textPhoneNumber.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		panelCustomerDetails.add(lblEmail, "cell 0 3,alignx trailing");

		textEmail = new JTextField(customer.getEmail());
		textEmail.setEditable(false);
		panelCustomerDetails.add(textEmail, "cell 1 3,growx");
		textEmail.setColumns(10);

		JLabel lblDoB = new JLabel("Date of birth");
		panelCustomerDetails.add(lblDoB, "cell 0 4,alignx trailing");

		textDoB = new JTextField(customer.getDateOfBirth());
		textDoB.setEditable(false);
		panelCustomerDetails.add(textDoB, "cell 1 4,growx");
		textDoB.setColumns(10);

		JPanel panelAvailableVehicles = new JPanel();
		tabbedPane.addTab("Available Vehicles", null, panelAvailableVehicles, null);
		panelAvailableVehicles.setLayout(new MigLayout("", "[454px,grow]", "[250.00px][60]"));

		JScrollPane scrollPane_1 = new JScrollPane();
		panelAvailableVehicles.add(scrollPane_1, "cell 0 0,alignx left,aligny top");

		tableAvailableVehicles = new JTable(customerController.generateAvailableVehiclesTable());
		scrollPane_1.setViewportView(tableAvailableVehicles);

		JPanel panel_4 = new JPanel();
		panelAvailableVehicles.add(panel_4, "cell 0 1,grow");

		JButton btnHireVehicle = new JButton("Hire");
		btnHireVehicle.addActionListener(customerController);
		panel_4.add(btnHireVehicle);

		JPanel panelHiredVehicles = new JPanel();
		tabbedPane.addTab("Hired vehicles", null, panelHiredVehicles, null);

		panelHiredVehicles.setLayout(new MigLayout("", "[454px,grow]", "[250.00px][60]"));

		JScrollPane scrollPane = new JScrollPane();
		panelHiredVehicles.add(scrollPane, "cell 0 0,alignx left,aligny top");

		tableHiredVehicles = new JTable(customerController.generateHiredVehiclesTable());
		scrollPane.setViewportView(tableHiredVehicles);

		JPanel panel = new JPanel();
		panelHiredVehicles.add(panel, "cell 0 1,grow");

		JButton btnReturnVehicle = new JButton("Return");
		btnReturnVehicle.addActionListener(customerController);
		panel.add(btnReturnVehicle);
	}

	public JTable getTableHiredVehicles() {
		return tableHiredVehicles;
	}

	public void setTableHiredVehicles(JTable tableHiredVehicles) {
		this.tableHiredVehicles = tableHiredVehicles;
	}

	public JTable getTableAvailableVehicles() {
		return tableAvailableVehicles;
	}

	public void setTableAvailableVehicles(JTable tableAvailableVehicles) {
		this.tableAvailableVehicles = tableAvailableVehicles;
	}

}
