import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class ViewApplication extends View {
    static JButton buttonHire, buttonReturn;

    ViewApplication() {
        setPreferredSize(new Dimension(1050, 850));

        createTable();

        JPanel panelRight = new JPanel();
        panelRight.setPreferredSize(new Dimension(300, 600));
        panelRight.setBackground(Color.RED);
        add(panelRight, BorderLayout.EAST);

        JPanel panelBottom = new JPanel();
        panelBottom.setPreferredSize(new Dimension(1000, 200));
        panelBottom.setBackground(Color.GREEN);
        add(panelBottom, BorderLayout.SOUTH);

        buttonHire = new JButton("Hire vehicles");
        panelRight.add(buttonHire);

        buttonReturn = new JButton("Return Vehicles");
        panelRight.add(buttonReturn);

        pack();
    }

    private void createTable() {
        JPanel panelMain = new JPanel();
        panelMain.setPreferredSize(new Dimension(700, 600));
        panelMain.setBackground(Color.BLUE);
        add(panelMain, BorderLayout.CENTER);

        final Object[][] vehicles = {
                {"Tesla", 5, true},
                {"Tesla", 5, true},
                {"Tesla", 5, true},
                {"Tesla", 5, true},
                {"Tesla", 5, true},
                {"Tesla", 5, true},
                {"Tesla", 5, true},
                {"Tesla", 5, true},
                {"Tesla", 5, true},
                {"Tesla", 5, true},
                {"Tesla", 5, true},
                {"Tesla", 5, true},
                {"Tesla", 5, true},
                {"Tesla", 5, true},
                {"Tesla", 5, true},
        };

        final String[] headings = {"Model", "Daily hire rate", "Hired"};

        JTable vehicleTable = new JTable(vehicles, headings);

        JScrollPane scrollPane = new JScrollPane(vehicleTable);
        panelMain.add(scrollPane);
    }

    @Override
    void addListener(ActionListener actionListener) {
    }
}
