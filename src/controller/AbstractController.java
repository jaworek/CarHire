package controller;

import javax.swing.JPanel;

public abstract class AbstractController {
	JPanel view;

	public void setView(JPanel view) {
		this.view = view;
	}

	public JPanel getView() {
		return view;
	}
}
