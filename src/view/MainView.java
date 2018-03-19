package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainView extends JFrame {

	private JPanel contentPane;

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
	}

	public void setPanel(JPanel panel) {
		JPanel contentPane = (JPanel) this.getContentPane();

		contentPane.removeAll();
		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
		this.pack();
	}
}
