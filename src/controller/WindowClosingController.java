package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WindowClosingController extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.out.println("bob");

		// Saves vehicles and customers objects in the binary files
		try {
			ObjectOutputStream customersFile = new ObjectOutputStream(new FileOutputStream("customers.dat"));
			// customersFile.writeObject();
			customersFile.close();

			ObjectOutputStream vehiclesFile = new ObjectOutputStream(new FileOutputStream("vehicles.dat"));
			// vehiclesFile.writeObject();
			vehiclesFile.close();

		} catch (IOException io) {
			System.out.println(io);
		}
	}
}
