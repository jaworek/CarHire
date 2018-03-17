package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPanel loginPanel;
	private JPanel registerPanel;

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
		setResizable(false);
		LoginController loginController = new LoginController(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		loginPanel = new JPanel();
		contentPane.add(loginPanel, BorderLayout.CENTER);
		loginPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		loginPanel.add(panel_1, BorderLayout.NORTH);
		
		JRadioButton rdbtnStaff = new JRadioButton("Staff");
		panel_1.add(rdbtnStaff);
		
		JRadioButton rdbtnCustomer = new JRadioButton("Customer");
		panel_1.add(rdbtnCustomer);
		
		JPanel panel_2 = new JPanel();
		loginPanel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new MigLayout("", "[220px][220px]", "[45.00px][45.00px][grow]"));
		
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
		panel_2.add(btnLogin, "flowx,cell 0 2 2 1,alignx center");
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(loginController);
		panel_2.add(btnRegister, "cell 0 2");
		
		registerPanel = new Register(loginController);
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
}
