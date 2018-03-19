package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.MainModel;

public class CustomerController extends AbstractController implements ActionListener {
	private MainController mainController;
	private MainModel mainModel;

	public CustomerController(MainController mainController, MainModel mainModel) {
		this.mainController = mainController;
		this.mainModel = mainModel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
