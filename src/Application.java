import java.awt.EventQueue;

import model.MainModel;
import view.MainView;

public class Application {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MainModel.loadFile();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}