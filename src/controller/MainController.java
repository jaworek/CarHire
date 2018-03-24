package controller;

import java.awt.EventQueue;

import model.CustomerModel;
import model.MainModel;
import objects.Customer;
import view.MainView;

public class MainController {
	private MainModel mainModel;
	private MainView mainView;

	// Controllers
	private LoginController loginController;
	private RegisterController registerController;
	private CustomerController customerController;
	private StaffController staffController;

	public MainController() {
		this.mainModel = new MainModel();
		mainModel.loadFile();
		this.mainView = new MainView();

		loadLogin();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// Listeners
		mainView.addWindowListener(new WindowClosingController(this));
	}

	public void loadLogin() {
		if (loginController == null) {
			loginController = new LoginController(this, mainModel);
		}
		mainView.setPanel(loginController.getView());
	}

	public void loadRegister() {
		if (registerController == null) {
			registerController = new RegisterController(this, mainModel);
			// RegisterView registerView = new RegisterView(registerController);
		}
		mainView.setPanel(registerController.getView());
	}

	public void loadCustomer(Customer customer) {
		if (customerController == null) {
			CustomerModel customerModel = new CustomerModel(customer);
			customerController = new CustomerController(this, mainModel, customerModel);
		}
		mainView.setPanel(customerController.getView());
	}

	public void loadStaff() {
		if (staffController == null) {
			staffController = new StaffController(this, mainModel);
		}
		mainView.setPanel(staffController.getView());
	}

	public MainModel getModel() {
		return mainModel;
	}
}
