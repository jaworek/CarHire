import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class ViewRegistration extends View {

    static JPanel panel;
    static JTextField textLogin, textName, textAddress, textPhoneNumber, textEmail, textDoB;
    static JPasswordField textPassword, textPasswordRepeat;
    static JButton buttonReturn, buttonCreateAccount;

    ViewRegistration() {

        super();

        createPanel();

        JLabel labelRegister = new JLabel("Register new customer:", SwingConstants.CENTER);
        labelRegister.setPreferredSize(new Dimension(400, 30));
        panel.add(labelRegister);

        JLabel labelLogin = new JLabel("Username:");
        labelLogin.setPreferredSize(new Dimension(190, 30));
        panel.add(labelLogin);

        textLogin = new JTextField();
        textLogin.setPreferredSize(new Dimension(190, 30));
        panel.add(textLogin);

        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setPreferredSize(new Dimension(190, 30));
        panel.add(labelPassword);

        textPassword = new JPasswordField();
        textPassword.setPreferredSize(new Dimension(190, 30));
        panel.add(textPassword);

        JLabel labelPasswordRepeat = new JLabel("Repeat password");
        labelPasswordRepeat.setPreferredSize(new Dimension(190, 30));
        panel.add(labelPasswordRepeat);

        textPasswordRepeat = new JPasswordField();
        textPasswordRepeat.setPreferredSize(new Dimension(190, 30));
        panel.add(textPasswordRepeat);

        JLabel labelName = new JLabel("Firstname & Surname:");
        labelName.setPreferredSize(new Dimension(190, 30));
        panel.add(labelName);

        textName = new JTextField();
        textName.setPreferredSize(new Dimension(190, 30));
        panel.add(textName);

        JLabel labelAddress = new JLabel("Address:");
        labelAddress.setPreferredSize(new Dimension(190, 30));
        panel.add(labelAddress);

        textAddress = new JTextField();
        textAddress.setPreferredSize(new Dimension(190, 30));
        panel.add(textAddress);

        JLabel labelPhoneNumber = new JLabel("Phone number:");
        labelPhoneNumber.setPreferredSize(new Dimension(190, 30));
        panel.add(labelPhoneNumber);

        textPhoneNumber = new JTextField();
        textPhoneNumber.setPreferredSize(new Dimension(190, 30));
        panel.add(textPhoneNumber);

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setPreferredSize(new Dimension(190, 30));
        panel.add(labelEmail);

        textEmail = new JTextField();
        textEmail.setPreferredSize(new Dimension(190, 30));
        panel.add(textEmail);

        JLabel labelDoB = new JLabel("Date of Birth:");
        labelDoB.setPreferredSize(new Dimension(190, 30));
        panel.add(labelDoB);

        textDoB = new JTextField();
        textDoB.setPreferredSize(new Dimension(190, 30));
        panel.add(textDoB);

        buttonReturn = new JButton("Return");
        panel.add(buttonReturn);

        buttonCreateAccount = new JButton("Create account");
        panel.add(buttonCreateAccount);

        pack();
    }

    private void createPanel() {
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setPreferredSize(new Dimension(400, 500));
        panel.setBackground(Color.YELLOW);
        add(panel);
    }


    void addListener(ActionListener actionListener) {
        buttonReturn.addActionListener(actionListener);
        buttonCreateAccount.addActionListener(actionListener);
    }
}