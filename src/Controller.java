import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class Controller {
    private View view;
    private Model model;

    Controller(View view, Model model) {
        this.view = view;
        this.model = model;

        this.view.addListener(new ActListener());
        this.view.addWindowListener(new WinListener());

    }

    // Removes current view and loads a new one
    void loadView(View newView) {
        view.dispose();
        view = newView;
        view.setVisible(true);
        view.addListener(new ActListener());
        view.addWindowListener(new WinListener());
    }

    class ActListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String buttonName = e.getActionCommand();

            switch (buttonName) {
                case "Login":
                    if (model.checkLoginCredentials()) {
                        System.out.println("ok");
                        loadView(new ViewApplication());
                    }
                    break;
                case "Register":
                    loadView(new ViewRegistration());
                    break;
                case "Return":
                    loadView(new ViewLogin());
                    break;
                case "Create account":
                    model.createAccount();
                    break;
            }
        }
    }

    class WinListener implements WindowListener {

        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {
            model.writeFile();
            System.out.println("File written");
        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }

}