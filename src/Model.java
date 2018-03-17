import java.io.*;
import java.util.ArrayList;

class Model {
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    Model() {
        loadFile();

        System.out.println(vehicles);
    }

    boolean checkLoginCredentials() {
        String login = ViewLogin.textLogin.getText();
        String password = new String(ViewLogin.textPassword.getPassword());

        if (ViewLogin.radioStaff.isSelected()) {
            if (login.equals("admin") && password.equals("admin")) {
                System.out.println("StaffPanel");
                return true;
            }
        }

        // Loops through all customers and checks if login and password match one of the users
        for (Customer customer : customers) {
            if (customer.getUsername().equals(login) && customer.getPassword().equals(password)) {
                System.out.println(customer);
                return true;
            }
        }
        return false;
    }

    void createAccount() {
        int id = 2;
        String name = ViewRegistration.textName.getText(),
                address = ViewRegistration.textAddress.getText(),
                phoneNumber = ViewRegistration.textPhoneNumber.getText(),
                email = ViewRegistration.textEmail.getText(),
                doB = ViewRegistration.textDoB.getText(),
                login = ViewRegistration.textLogin.getText(),
                password = new String(ViewRegistration.textPassword.getPassword()),
                password2 = new String(ViewRegistration.textPasswordRepeat.getPassword());
        if (!name.isEmpty() && password.equals(password2)) {
            Customer newCustomer = new Customer(id, name, address, phoneNumber, email, doB, login, password);
            customers.add(newCustomer);
            System.out.println("Account created");
            ViewRegistration.buttonReturn.doClick();
        } else {
            System.out.println("Wrong details");
        }
    }

    // Reads customers and vehicles object from the binary files
    void loadFile() {
        try {
            ObjectInputStream customersFile = new ObjectInputStream(new FileInputStream("customers.dat"));
            ObjectInputStream vehiclesFile = new ObjectInputStream(new FileInputStream("vehicles.dat"));

            customers = (ArrayList<Customer>) customersFile.readObject();
            customersFile.close();

            vehicles = (ArrayList<Vehicle>) vehiclesFile.readObject();
            vehiclesFile.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Saves vehicles and customers objects in the binary files
    void writeFile() {
        try {
            ObjectOutputStream customersFile = new ObjectOutputStream(new FileOutputStream("customers.dat"));
            customersFile.writeObject(customers);
            customersFile.close();

            ObjectOutputStream vehiclesFile = new ObjectOutputStream(new FileOutputStream("vehicles.dat"));
            vehiclesFile.writeObject(vehicles);
            vehiclesFile.close();

        } catch (IOException io) {
            System.out.println(io);
        }
    }

    // Overloaded function used to add different types of vehicles
    void addVehicle(String model, int topSpeed, String registrationNumber, double dailyHireRate, String fuelType, int doors) {
        Car newCar = new Car(model, topSpeed, registrationNumber, dailyHireRate, fuelType, doors);
        vehicles.add(newCar);
    }

    void addVehicle(String model, int topSpeed, String registrationNumber, double dailyHireRate, double loadingCapacity) {
        Lorry newLorry = new Lorry(model, topSpeed, registrationNumber, dailyHireRate, loadingCapacity);
        vehicles.add(newLorry);
    }

    void addVehicle(String model, int topSpeed, String registrationNumber, double dailyHireRate, int seatingCapacity) {
        MiniBus newMiniBus = new MiniBus(model, topSpeed, registrationNumber, dailyHireRate, seatingCapacity);
        vehicles.add(newMiniBus);
    }

}