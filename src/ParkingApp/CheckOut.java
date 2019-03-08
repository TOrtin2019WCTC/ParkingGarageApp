package ParkingApp;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CheckOut {
    public static Scanner keyboard = new Scanner(System.in);
    private List<Ticket> parked_Cars;
    private int ticketNumber;


    public CheckOut() {
        machine();
    }


    static void machine() {
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
                lostTicket();
                break;
        }
    }

    private static void checkOut() {

        ParkingGarage garage = new ParkingGarage();
        Random random = new Random();
        int index = random.nextInt(garage.getParked_Cars().size());
        Ticket ticketToRemove = garage.getParked_Cars().get(index);
        garage.removeCar(ticketToRemove);
        Reciept reciept = new Reciept(ticketToRemove);
        calculateFees(ticketToRemove);

    }

    private static void lostTicket() {
        ParkingGarage garage = new ParkingGarage();
        Random random = new Random();
        int index = random.nextInt(garage.getParked_Cars().size());
        Ticket ticketToRemove = garage.getParked_Cars().get(index);
        garage.removeCar(ticketToRemove);
        Reciept reciept = new Reciept(ticketToRemove);
        reciept.generateLostReciept();
    }

    private static String calculateFees(Ticket ticket) {
        int fee = 0;
        int hours = 0;
        int minutes = 0;
        int minimumHours = 3;

        hours = (ticket.getCheck_Out_Time().getHour() - ticket.getCheck_In_Time().getHour());
        minutes = (ticket.getCheck_Out_Time().getMinute() - ticket.getCheck_In_Time().getMinute());

        hours += minutes > 0 ? 1 : 0;

        if (hours <= minimumHours) {
            fee = PricesAndFees.MINIMUM_FEE;
        } else if(hours >= 15){
           fee = PricesAndFees.MINIMUM_FEE;
        }else{
            int extraHours = hours - minimumHours;
            fee = (extraHours * 1) + PricesAndFees.MINIMUM_FEE;
        }

        System.out.println(fee);

        return ("$"+fee);
    }
}

