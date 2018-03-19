package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Customer;
import model.MainModel;
import view.LoginView;

public class LoginController extends AbstractController implements ActionListener {
	private MainController mainController;
	private MainModel mainModel;
	private LoginView loginView;

	public LoginController(MainController mainController, MainModel mainModel) {
		this.mainController = mainController;
		this.mainModel = mainModel;
		this.loginView = (LoginView) getView();
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
	void checkLoginCustomer(String login, String password) {
		for (Customer customer : mainModel.getCustomers()) {
			if (customer.getUsername().equals(login) && customer.getPassword().equals(password)) {
				System.out.println("Customer login");
			}
		}
	}

	void checkLoginStaff(String login, String password) {
		if (login.equals("admin") && password.equals("admin")) {
			System.out.println("Staff login");
		}
	}

	void checkLogin() {
		String login = loginView.getTextLogin().getText();
		String password = new String(loginView.getTextPassword().getPassword());
		if (loginView.getRdbtnCustomer().isSelected()) {
			checkLoginCustomer(login, password);
		} else if (loginView.getRdbtnStaff().isSelected()) {
			checkLoginStaff(login, password);
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String source = event.getActionCommand();

		if (source == "Register") {
			mainController.loadRegister();
		} else if (source == "Login") {
			checkLogin();
		}
	}

}
