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
	private JTable table;
	private JTable table_1;
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

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Customer details", null, panel_1, null);
		panel_1.setLayout(new MigLayout("", "[36px][grow]", "[16px][][][][]"));

		JLabel lblName = new JLabel("Name");
		panel_1.add(lblName, "cell 0 0,alignx trailing,aligny top");

		textName = new JTextField(customer.getName());
		textName.setEditable(false);
		panel_1.add(textName, "cell 1 0,growx");
		textName.setColumns(10);

		JLabel lblAddress = new JLabel("Address");
		panel_1.add(lblAddress, "cell 0 1,alignx trailing");

		textAddress = new JTextField(customer.getAddress());
		textAddress.setEditable(false);
		panel_1.add(textAddress, "cell 1 1,growx");
		textAddress.setColumns(10);

		JLabel lblPhoneNumber = new JLabel("Phone number");
		panel_1.add(lblPhoneNumber, "cell 0 2,alignx trailing");

		textPhoneNumber = new JTextField(customer.getPhoneNumber());
		textPhoneNumber.setEditable(false);
		panel_1.add(textPhoneNumber, "cell 1 2,growx");
		textPhoneNumber.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		panel_1.add(lblEmail, "cell 0 3,alignx trailing");

		textEmail = new JTextField(customer.getEmail());
		textEmail.setEditable(false);
		panel_1.add(textEmail, "cell 1 3,growx");
		textEmail.setColumns(10);

		JLabel lblDoB = new JLabel("Date of birth");
		panel_1.add(lblDoB, "cell 0 4,alignx trailing");

		textDoB = new JTextField(customer.getDateOfBirth());
		textDoB.setEditable(false);
		panel_1.add(textDoB, "cell 1 4,growx");
		textDoB.setColumns(10);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Available Vehicles", null, panel_3, null);
		panel_3.setLayout(new MigLayout("", "[454px,grow]", "[250.00px][60]"));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_3.add(scrollPane_1, "cell 0 0,alignx left,aligny top");

		table_1 = new JTable(customerController.generateHiredVehiclesTable());
		scrollPane_1.setViewportView(table_1);

		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, "cell 0 1,grow");

		JButton btnHireVehicle = new JButton("Hire");
		btnHireVehicle.addActionListener(customerController);
		panel_4.add(btnHireVehicle);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Hired vehicles", null, panel_2, null);

		panel_2.setLayout(new MigLayout("", "[454px,grow]", "[250.00px][60]"));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, "cell 0 0,alignx left,aligny top");

		table = new JTable(customerController.generateAvailableVehiclesTable());
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel_2.add(panel, "cell 0 1,grow");

		JButton btnReturnVehicle = new JButton("Return");
		btnReturnVehicle.addActionListener(customerController);
		panel.add(btnReturnVehicle);
	}

}
