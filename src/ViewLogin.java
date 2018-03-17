import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class ViewLogin extends View {

    static JPanel panel;
    static JRadioButton radioClient, radioStaff;
    static JTextField textLogin;
    static JPasswordField textPassword;
    static JButton buttonLogin, buttonRegister;

    ViewLogin() {

        super();
        createPanel();
        createRadioButtons();
        createLoginInput();
        createButtons();
        pack();
    }

    private void createPanel() {
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setPreferredSize(new Dimension(400, 500));
        panel.setBackground(Color.YELLOW);
        add(panel);
    }

    private void createRadioButtons() {
        JPanel panelRadio = new JPanel();
        panelRadio.setLayout(new FlowLayout());
        panelRadio.setPreferredSize(new Dimension(400, 50));

        radioClient = new JRadioButton("Client", true);
        panelRadio.add(radioClient);

        radioStaff = new JRadioButton("Staff");
        panelRadio.add(radioStaff);

        ButtonGroup groupType = new ButtonGroup();
        groupType.add(radioClient);
        groupType.add(radioStaff);

        panel.add(panelRadio);
    }

    private void createLoginInput() {
        JLabel labelLogin = new JLabel("Login:");
        panel.add(labelLogin);

        textLogin = new JTextField("admin");
        textLogin.setPreferredSize(new Dimension(100, 30));
        panel.add(textLogin);

        JLabel labelPassword = new JLabel("Password:");
        panel.add(labelPassword);

        textPassword = new JPasswordField("admin");
        textPassword.setPreferredSize(new Dimension(100, 30));
        panel.add(textPassword);
    }

    private void createButtons() {
        buttonLogin = new JButton("Login");
        panel.add(buttonLogin);

        buttonRegister = new JButton("Register");
        panel.add(buttonRegister);
    }

    void addListener(ActionListener actionListener) {

        buttonLogin.addActionListener(actionListener);
        buttonRegister.addActionListener(actionListener);

    }
}