package view;

import javax.swing.JPanel;

import controller.AbstractController;

public abstract class AbstractView extends JPanel {
	public AbstractView(AbstractController abstractController) {
		if (abstractController != null) {
			abstractController.setView(this);
		}
	}
}
