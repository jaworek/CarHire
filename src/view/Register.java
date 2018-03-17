package view;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;

import controller.LoginController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Create the panel.
	 */
	public Register(LoginController loginController) {
		
		setLayout(new MigLayout("", "[61px][grow]", "[16px][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Register new customer");
		add(lblNewLabel, "cell 0 0 2 1,alignx center,aligny top");
		
		JLabel lblUsername = new JLabel("Username");
		add(lblUsername, "cell 0 1,alignx trailing");
		
		textField = new JTextField();
		add(textField, "cell 1 1,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		add(lblNewLabel_1, "cell 0 2,alignx trailing");
		
		textField_1 = new JTextField();
		add(textField_1, "cell 1 2,growx");
		textField_1.setColumns(10);
		
		JLabel lblRepeatPassword = new JLabel("Repeat password");
		add(lblRepeatPassword, "cell 0 3,alignx trailing");
		
		textField_2 = new JTextField();
		add(textField_2, "cell 1 3,growx");
		textField_2.setColumns(10);
		
		JLabel lblFirstnameSurname = new JLabel("Firstname & Surname");
		add(lblFirstnameSurname, "cell 0 4,alignx trailing");
		
		textField_3 = new JTextField();
		add(textField_3, "cell 1 4,growx");
		textField_3.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		add(lblAddress, "cell 0 5,alignx trailing");
		
		textField_4 = new JTextField();
		add(textField_4, "cell 1 5,growx");
		textField_4.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		add(lblPhoneNumber, "cell 0 6,alignx trailing");
		
		textField_5 = new JTextField();
		add(textField_5, "cell 1 6,growx");
		textField_5.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		add(lblEmail, "cell 0 7,alignx trailing");
		
		textField_6 = new JTextField();
		add(textField_6, "cell 1 7,growx");
		textField_6.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("Date of birth");
		add(lblDateOfBirth, "cell 0 8,alignx trailing");
		
		textField_7 = new JTextField();
		add(textField_7, "cell 1 8,growx");
		textField_7.setColumns(10);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(loginController);
		add(btnNewButton, "flowx,cell 0 9 2 1,alignx center");
		
		JButton btnNewButton_1 = new JButton("Create account");
		add(btnNewButton_1, "cell 0 9 2 1");

	}

}
