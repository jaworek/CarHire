package view;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.LoginController;
import net.miginfocom.swing.MigLayout;

public class LoginView extends AbstractView {
	private JTextField textField;
	private JPasswordField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 * 
	 * @param loginController
	 */
	public LoginView(LoginController loginController) {
		super(loginController);
		setLayout(new MigLayout("", "[450px]", "[40][267px]"));

		JPanel panel_1 = new JPanel();
		this.add(panel_1, "cell 0 0,growx,aligny top");

		JRadioButton rdbtnCustomer = new JRadioButton("Customer");
		rdbtnCustomer.setSelected(true);
		buttonGroup.add(rdbtnCustomer);
		panel_1.add(rdbtnCustomer);

		JRadioButton rdbtnStaff = new JRadioButton("Staff");
		buttonGroup.add(rdbtnStaff);
		panel_1.add(rdbtnStaff);

		JPanel panel_2 = new JPanel();
		this.add(panel_2, "cell 0 1,grow");
		panel_2.setLayout(new MigLayout("", "[220px][220px]", "[45.00px][45.00px][45.00][grow]"));

		JLabel lblLogin = new JLabel("Login");
		panel_2.add(lblLogin, "cell 0 0,grow");

		textField = new JTextField();
		panel_2.add(textField, "cell 1 0,grow");
		textField.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		panel_2.add(lblPassword, "cell 0 1,grow");

		passwordField = new JPasswordField();
		panel_2.add(passwordField, "cell 1 1,grow");

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(loginController);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.RED);
		panel_2.add(lblNewLabel, "cell 0 2 2 1,alignx center");
		panel_2.add(btnLogin, "flowx,cell 0 3 2 1,alignx center");

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(loginController);
		panel_2.add(btnRegister, "cell 0 3 2 1");
	}

}
