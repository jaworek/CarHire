package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.RegisterController;
import net.miginfocom.swing.MigLayout;

public class RegisterView extends AbstractView {
	private JTextField textLogin;
	private JPasswordField textPassword1;
	private JPasswordField textPassword2;
	private JTextField textName;
	private JTextField textAddress;
	private JTextField textPhoneNumber;
	private JTextField textEmail;
	private JTextField textDoB;
	private JLabel errorLabel;

	/**
	 * Create the panel.
	 */
	public RegisterView(RegisterController registerController) {
		super(registerController);
		setLayout(new MigLayout("", "[61px][grow]", "[16px][][][][][][][][][][]"));

		JLabel lblNewLabel = new JLabel("Register new customer");
		add(lblNewLabel, "cell 0 0 2 1,alignx center,aligny top");

		JLabel lblUsername = new JLabel("Username");
		add(lblUsername, "cell 0 1,alignx trailing");

		textLogin = new JTextField();
		add(textLogin, "cell 1 1,growx");
		textLogin.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Password");
		add(lblNewLabel_1, "cell 0 2,alignx trailing");

		textPassword1 = new JPasswordField();
		add(textPassword1, "cell 1 2,growx");
		textPassword1.setColumns(10);

		JLabel lblRepeatPassword = new JLabel("Repeat password");
		add(lblRepeatPassword, "cell 0 3,alignx trailing");

		textPassword2 = new JPasswordField();
		add(textPassword2, "cell 1 3,growx");
		textPassword2.setColumns(10);

		JLabel lblFirstnameSurname = new JLabel("Firstname & Surname");
		add(lblFirstnameSurname, "cell 0 4,alignx trailing");

		textName = new JTextField();
		add(textName, "cell 1 4,growx");
		textName.setColumns(10);

		JLabel lblAddress = new JLabel("Address");
		add(lblAddress, "cell 0 5,alignx trailing");

		textAddress = new JTextField();
		add(textAddress, "cell 1 5,growx");
		textAddress.setColumns(10);

		JLabel lblPhoneNumber = new JLabel("Phone number");
		add(lblPhoneNumber, "cell 0 6,alignx trailing");

		textPhoneNumber = new JTextField();
		add(textPhoneNumber, "cell 1 6,growx");
		textPhoneNumber.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		add(lblEmail, "cell 0 7,alignx trailing");

		textEmail = new JTextField();
		add(textEmail, "cell 1 7,growx");
		textEmail.setColumns(10);

		JLabel lblDateOfBirth = new JLabel("Date of birth");
		add(lblDateOfBirth, "cell 0 8,alignx trailing");

		textDoB = new JTextField();
		add(textDoB, "cell 1 8,growx");
		textDoB.setColumns(10);

		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(registerController);

		errorLabel = new JLabel(" ");
		errorLabel.setForeground(Color.RED);
		add(errorLabel, "cell 0 9 2 1,alignx center");
		add(btnNewButton, "flowx,cell 0 10 2 1,alignx center");

		JButton btnNewButton_1 = new JButton("Create account");
		btnNewButton_1.addActionListener(registerController);
		add(btnNewButton_1, "cell 0 10 2 1");
	}

	public JTextField getTextLogin() {
		return textLogin;
	}

	public JPasswordField getTextPassword1() {
		return textPassword1;
	}

	public JPasswordField getTextPassword2() {
		return textPassword2;
	}

	public JTextField getTextName() {
		return textName;
	}

	public JTextField getTextAddress() {
		return textAddress;
	}

	public JTextField getTextPhoneNumber() {
		return textPhoneNumber;
	}

	public JTextField getTextEmail() {
		return textEmail;
	}

	public JTextField getTextDoB() {
		return textDoB;
	}

	public void setErrorLabelText(String errorLabelText) {
		this.errorLabel.setText(errorLabelText);
	}

}
