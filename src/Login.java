import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		JRadioButton rdbtnStaff = new JRadioButton("Staff");
		panel_1.add(rdbtnStaff);
		
		JRadioButton rdbtnCustomer = new JRadioButton("Customer");
		panel_1.add(rdbtnCustomer);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new MigLayout("", "[220px][220px]", "[117px][117px][]"));
		
		JLabel lblLogin = new JLabel("Login");
		panel_2.add(lblLogin, "cell 0 0,grow");
		
		textField = new JTextField();
		panel_2.add(textField, "cell 1 0,grow");
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		panel_2.add(lblPassword, "cell 0 1,grow");
		
		passwordField = new JPasswordField();
		panel_2.add(passwordField, "cell 1 1,grow");
		
		JButton btnLogin = new JButton("Login");
		panel_2.add(btnLogin, "cell 0 2");
		
		JButton btnRegister = new JButton("Register");
		panel_2.add(btnRegister, "cell 1 2");
	}

}
