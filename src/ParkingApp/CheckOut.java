package ParkingApp;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CheckOut {
    private Scanner keyboard = new Scanner(System.in);
    private List<Ticket> parked_Cars;
    private int ticketNumber;


    public CheckOut() {
        machine();
    }


    public void machine() {
        System.out.println("Best Value Parking Garage\n===============================");
        System.out.println("1 - Check/Out");
        System.out.println("2 - Lost Ticket");
        System.out.println("=>_");
        System.out.println("==================================");

        String ans = keyboard.nextLine();

        switch (ans) {
            case "1":
                checkOut();
                break;
            case "2":

                break;
        }
    }

    public void checkOut() {

        ParkingGarage garage = new ParkingGarage();
        Random random = new Random();
        int index = random.nextInt(garage.getParked_Cars().size());
        Ticket ticketToRemove = garage.getParked_Cars().get(index);
        garage.removeCar(ticketToRemove);


    }
}

