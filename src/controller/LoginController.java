package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Login;

public class LoginController implements ActionListener {

	private Login login;
	
	public LoginController(Login login) {
		// TODO Auto-generated constructor stub
		this.login = login;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		String source = event.getActionCommand();
		
		if(source == "Register") {
			login.setRegisterPanel();
		} else if(source == "Return") {
			login.setLoginPanel();
		}
	}
	
}
