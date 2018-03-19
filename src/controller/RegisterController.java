package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.MainModel;

public class RegisterController extends AbstractController implements ActionListener {
	private MainController mainController;
	private MainModel mainModel;

	public RegisterController(MainController mainController, MainModel mainModel) {
		this.mainController = mainController;
		this.mainModel = mainModel;
	}

	// void createAccount() {
	// int id = 2;
	// String name = ViewRegistration.textName.getText(), address =
	// ViewRegistration.textAddress.getText(),
	// phoneNumber = ViewRegistration.textPhoneNumber.getText(), email =
	// ViewRegistration.textEmail.getText(),
	// doB = ViewRegistration.textDoB.getText(), login =
	// ViewRegistration.textLogin.getText(),
	// password = new String(ViewRegistration.textPassword.getPassword()),
	// password2 = new String(ViewRegistration.textPasswordRepeat.getPassword());
	// if (!name.isEmpty() && password.equals(password2)) {
	// Customer newCustomer = new Customer(id, name, address, phoneNumber, email,
	// doB, login, password);
	// customers.add(newCustomer);
	// System.out.println("Account created");
	// ViewRegistration.buttonReturn.doClick();
	// } else {
	// System.out.println("Wrong details");
	// }
	// }

	@Override
	public void actionPerformed(ActionEvent event) {
		String source = event.getActionCommand();

		if (source == "Return") {
			mainController.loadLogin();
		} else if (source == "Create account") {
			System.out.println("Works");
		}
	}

}
