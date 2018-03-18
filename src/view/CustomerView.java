package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import controller.CustomerController;
import net.miginfocom.swing.MigLayout;

public class CustomerView extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public CustomerView(CustomerController customerController) {
		setLayout(new MigLayout("", "[450.00,grow][grow]", "[grow]"));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, "cell 0 0,grow");

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Customer details", null, panel_1, null);
		panel_1.setLayout(new MigLayout("", "[36px]", "[16px][][][][]"));

		JLabel lblName = new JLabel("Name");
		panel_1.add(lblName, "cell 0 0,alignx left,aligny top");

		JLabel lblAddress = new JLabel("Address");
		panel_1.add(lblAddress, "cell 0 1");

		JLabel lblPhoneNumber = new JLabel("Phone number");
		panel_1.add(lblPhoneNumber, "cell 0 2");

		JLabel lblEmail = new JLabel("Email");
		panel_1.add(lblEmail, "cell 0 3");

		JLabel lblDateOfBirth = new JLabel("Date of birth");
		panel_1.add(lblDateOfBirth, "cell 0 4");

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Hire Vehicle", null, panel_3, null);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Hired vehicles", null, panel_2, null);

		table = new JTable();
		panel_2.add(table);
	}

}
