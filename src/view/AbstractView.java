package view;

import javax.swing.JPanel;

import controller.AbstractController;

public abstract class AbstractView extends JPanel {
	public AbstractView(AbstractController abstractController) {
		abstractController.setView(this);
	}
}
