package controller;

import java.awt.EventQueue;

import model.MainModel;
import view.LoginView;
import view.MainView;

public class MainController {
	private MainModel mainModel;
	private MainView mainView;

	// Controllers
	private LoginController loginController;

	public MainController() {
		this.mainModel = new MainModel();

		// Controllers
		// LoginController loginController = new LoginController(new
		// LoginView(loginController), mainModel);
		// RegisterController registerController = new RegisterController(new
		// RegisterView(registerController), mainModel);
		// StaffController staffController = new StaffController(this);
		// CustomerController customerController = new CustomerController(this);
		// VehicleController vehicleController = new VehicleController(this);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainView = new MainView();
					mainView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void loadLogin() {
		if (loginController == null) {
			LoginView loginView = new LoginView(loginController);
			loginController = new LoginController(loginView, mainModel);
		}
		mainView.setPanel(loginController.getView());
	}
}
