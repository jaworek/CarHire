package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainView;

public class LoginController implements ActionListener {
	private MainView mainView;

	public LoginController(MainView main) {
		this.mainView = main;
	}

	// boolean checkLoginCredentials() {
	// String login = ViewLogin.textLogin.getText();
	// String password = new String(ViewLogin.textPassword.getPassword());
	//
	// if (ViewLogin.radioStaff.isSelected()) {
	// if (login.equals("admin") && password.equals("admin")) {
	// System.out.println("StaffPanel");
	// return true;
	// }
	// }
	//
	// // Loops through all customers and checks if login and password match one of
	// the
	// // users
	// for (Customer customer : customers) {
	// if (customer.getUsername().equals(login) &&
	// customer.getPassword().equals(password)) {
	// System.out.println(customer);
	// return true;
	// }
	// }
	// return false;
	// }

	@Override
	public void actionPerformed(ActionEvent event) {
		String source = event.getActionCommand();

		if (source == "Register") {
			mainView.setRegisterPanel();
		} else if (source == "Login") {
			mainView.setCustomerPanel();
		}
	}

}
