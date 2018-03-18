package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import controller.StaffController;
import net.miginfocom.swing.MigLayout;

public class StaffView extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public StaffView(StaffController staffController) {
		setLayout(new MigLayout("", "[450.00,grow][grow]", "[21px,grow]"));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, "cell 0 0,grow");

		JPanel panel = new JPanel();
		tabbedPane.addTab("Add vehicle", null, panel, null);
		panel.setLayout(new MigLayout("", "[102px][grow]", "[16px][][][][][]"));

		JLabel lblAddNewVehicle = new JLabel("Add new vehicle");
		panel.add(lblAddNewVehicle, "cell 0 0 2 1,alignx center,aligny top");

		JLabel lblNewLabel = new JLabel("Model");
		panel.add(lblNewLabel, "cell 0 1,alignx trailing");

		textField = new JTextField();
		panel.add(textField, "cell 1 1,growx");
		textField.setColumns(10);

		JLabel lblTopSpeed = new JLabel("Top speed");
		panel.add(lblTopSpeed, "cell 0 2,alignx trailing");

		textField_1 = new JTextField();
		panel.add(textField_1, "cell 1 2,growx");
		textField_1.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Registration number");
		panel.add(lblNewLabel_1, "cell 0 3,alignx trailing");

		textField_2 = new JTextField();
		panel.add(textField_2, "cell 1 3,growx");
		textField_2.setColumns(10);

		JLabel lblHireRate = new JLabel("Hire rate");
		panel.add(lblHireRate, "cell 0 4,alignx trailing");

		textField_3 = new JTextField();
		panel.add(textField_3, "cell 1 4,growx");
		textField_3.setColumns(10);

		JButton btnNewButton = new JButton("Add");
		panel.add(btnNewButton, "cell 0 5 2 1,alignx center");

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Hire vehicle", null, panel_3, null);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Remove vehicle", null, panel_2, null);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Customers", null, panel_4, null);

		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 1 0,grow");
	}

}
