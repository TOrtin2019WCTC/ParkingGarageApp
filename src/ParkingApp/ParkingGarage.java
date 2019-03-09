package ParkingApp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

class ParkingGarage {

    static List<Ticket> parked_Cars;
    private boolean isListInitialized = false;
    private final String TICKET_PATH = "/Users/tim/ParkingApp_Test/src/ParkingApp/files/Garage.txt";

    public ParkingGarage() {

    }


    public List<Ticket> getParked_Cars() {
        return parked_Cars;
    }


    public void addCar(Ticket ticket) {
        parked_Cars.add(ticket);
    }

    public void removeCar(int i) {
        parked_Cars.remove(i);
    }


    public void garageListInitializer() {
        while (!isListInitialized) {
            parked_Cars = new ArrayList<>();
            this.isListInitialized = true;
        }

    }

    public void writeTicketsToFile() {

        ObjectOutputStream obj;

        try {
            obj = new ObjectOutputStream(new FileOutputStream(TICKET_PATH));
            obj.writeObject(parked_Cars);

            obj.close();

        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public void readTicketsFromFile() {

        ObjectInputStream in;
        boolean endOfFile = false;


        try {
            in = new ObjectInputStream(new FileInputStream(TICKET_PATH));

            while (!endOfFile) {
                parked_Cars = (List) in.readObject();
                endOfFile = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

}
