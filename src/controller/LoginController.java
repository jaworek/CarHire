package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.MainModel;

public class LoginController extends AbstractController implements ActionListener {
	private MainController mainController;
	private MainModel mainModel;

	public LoginController(MainController mainController, MainModel mainModel) {
		this.mainController = mainController;
		this.mainModel = mainModel;
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
			mainController.loadRegister();
		} else if (source == "Login") {

		}
	}

}
