import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

abstract class View extends JFrame {

    View() {
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setResizable(false);
        setTitle("MVC test");
    }

    abstract void addListener(ActionListener actionListener);

}