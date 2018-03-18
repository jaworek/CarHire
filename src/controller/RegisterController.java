package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainView;

public class RegisterController implements ActionListener {
	private MainView mainView;

	public RegisterController(MainView mainView) {
		this.mainView = mainView;
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
			mainView.setLoginPanel();
		} else if (source == "Create account") {
			System.out.println("Works");
		}
	}

}
