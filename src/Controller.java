import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import model.Model;

class Controller {
//    private View view;
//    private Model model;

    Controller() {
//        this.view = view;
//        this.model = model;
//
//        this.view.addListener(new ActListener());
//        this.view.addWindowListener(new WinListener());

    }

    class WinListener implements WindowListener {

        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {
//            model.writeFile();
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