package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Customer;
import model.MainModel;
import view.RegisterView;

public class RegisterController extends AbstractController implements ActionListener {
	private MainController mainController;
	private MainModel mainModel;

	public RegisterController(MainController mainController, MainModel mainModel) {
		this.mainController = mainController;
		this.mainModel = mainModel;
	}

	void createAccount() {
		RegisterView registerView = (RegisterView) getView();
		int id = 2;
		String name = registerView.getTextName().getText(), address = registerView.getTextAddress().getText(),
				phoneNumber = registerView.getTextPhoneNumber().getText(),
				email = registerView.getTextEmail().getText(), doB = registerView.getTextDoB().getText(),
				login = registerView.getTextLogin().getText(),
				password = new String(registerView.getTextPassword1().getPassword()),
				password2 = new String(registerView.getTextPassword2().getPassword());
		if (!name.isEmpty() && password.equals(password2)) {
			Customer newCustomer = new Customer(id, name, address, phoneNumber, email, doB, login, password);
			mainModel.getCustomers().add(newCustomer);
			System.out.println("Account created");
			System.out.println(mainModel.getCustomers());
			mainController.loadLogin();
		} else {
			System.out.println("Wrong details");
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String source = event.getActionCommand();

		if (source == "Return") {
			mainController.loadLogin();
		} else if (source == "Create account") {
			System.out.println("Works");
			createAccount();
		}
	}

}
