package controller;

import java.awt.EventQueue;

import model.MainModel;
import view.LoginView;
import view.MainView;
import view.RegisterView;

public class MainController {
	private MainModel mainModel;
	private MainView mainView;

	// Controllers
	private LoginController loginController;
	private RegisterController registerController;

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
			LoginView loginView = new LoginView(loginController);
		}
		mainView.setPanel(loginController.getView());
	}

	public void loadRegister() {
		if (registerController == null) {
			registerController = new RegisterController(this, mainModel);
			RegisterView registerView = new RegisterView(registerController);
		}
		mainView.setPanel(registerController.getView());
	}

	public MainModel getModel() {
		return mainModel;
	}
}
