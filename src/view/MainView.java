package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CustomerController;
import controller.LoginController;
import controller.RegisterController;
import controller.StaffController;
import controller.VehicleController;
import controller.WindowClosingController;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JPanel loginPanel;
	private JPanel registerPanel;
	private JPanel staffPanel;
	private JPanel customerPanel;

	/**
	 * Create the frame.
	 */
	public MainView() {
		setTitle("Vehicle Hire");
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// Controllers
		LoginController loginController = new LoginController(this);
		RegisterController registerController = new RegisterController(this);
		StaffController staffController = new StaffController(this);
		CustomerController customerController = new CustomerController(this);
		VehicleController vehicleController = new VehicleController(this);

		// Panels
		loginPanel = new LoginView(loginController);
		contentPane.add(loginPanel, BorderLayout.CENTER);

		registerPanel = new RegisterView(registerController);

		customerPanel = new CustomerView(customerController);
		staffPanel = new StaffView(staffController);

		// Listeners
		addWindowListener(new WindowClosingController());
	}

	private void setPanel(JPanel panel) {
		JPanel contentPane = (JPanel) this.getContentPane();

		contentPane.removeAll();
		contentPane.add(panel);
		contentPane.revalidate();
		contentPane.repaint();
		this.pack();
	}

	public void setLoginPanel() {
		setPanel(loginPanel);
	}

	public void setRegisterPanel() {
		setPanel(registerPanel);
	}

	public void setCustomerPanel() {
		setPanel(customerPanel);
	}

	public void setStaffPanel() {
		setPanel(staffPanel);
	}
}
