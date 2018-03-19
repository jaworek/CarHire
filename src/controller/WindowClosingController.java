package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.MainModel;

public class WindowClosingController extends WindowAdapter {
	private MainModel mainModel;

	public WindowClosingController(MainController mainController) {
		this.mainModel = mainController.getModel();
	}

	public void windowClosing(WindowEvent e) {
		System.out.println("bob");
	}
}
