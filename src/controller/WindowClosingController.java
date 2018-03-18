package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowClosingController extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.out.println("bob");

		// Saves vehicles and customers objects in the binary files
		// try {
		// ObjectOutputStream customersFile = new ObjectOutputStream(new
		// FileOutputStream("customers.dat"));
		// customersFile.writeObject(customers);
		// customersFile.close();
		//
		// ObjectOutputStream vehiclesFile = new ObjectOutputStream(new
		// FileOutputStream("vehicles.dat"));
		// vehiclesFile.writeObject(vehicles);
		// vehiclesFile.close();
		//
		// } catch (IOException io) {
		// System.out.println(io);
		// }
	}
}
