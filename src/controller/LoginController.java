package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.MainModel;
import objects.Customer;
import view.LoginView;

public class LoginController extends AbstractController implements ActionListener {
	private MainController mainController;
	private MainModel mainModel;
	private LoginView loginView;

	public LoginController(MainController mainController, MainModel mainModel) {
		this.mainController = mainController;
		this.mainModel = mainModel;
		this.loginView = new LoginView(this);

	}

	void checkLoginCustomer(String login, String password) {
		for (Customer customer : mainModel.getCustomers()) {
			if (customer.getUsername().equals(login) && customer.getPassword().equals(password)) {
				System.out.println("Customer login");
				mainController.loadCustomer(customer);
			} else {
				loginView.setErrorLabelText("Invalid login or password");
				// LoginView.setErrorText("Invalid login or password");
			}
		}
	}

	void checkLoginStaff(String login, String password) {
		if (login.equals("admin") && password.equals("admin")) {
			System.out.println("Staff login");
			mainController.loadStaff();
		} else {

		}
	}

	void checkLogin() {
		LoginView loginView = (LoginView) getView();
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
