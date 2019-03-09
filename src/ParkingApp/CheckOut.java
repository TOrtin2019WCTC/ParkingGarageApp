package ParkingApp;

import java.time.LocalTime;
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
        System.out.println("\n\n\tBest Value Parking Garage");
        System.out.println("\n\t===============================");
        System.out.println("\t1 - Check/Out");
        System.out.println("\t2 - Lost Ticket");
        System.out.println("\t=>_");
        System.out.println("\t==================================");

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
        generateRandomCheckOutTime(ticketToRemove);
        garage.removeCar(index);
       // Reciept reciept = new Reciept(ticketToRemove);
        PricesAndFees.calculateFees(ticketToRemove);


    }

    private static void lostTicket() {
        ParkingGarage garage = new ParkingGarage();
        Random random = new Random();
        int index = random.nextInt(garage.getParked_Cars().size());
        Ticket ticketToRemove = garage.getParked_Cars().get(index);
        garage.removeCar(index);
        Reciept reciept = new Reciept(ticketToRemove);
        reciept.generateLostReciept();
        Main.totalLostTickets++;
        Main.totalLostTicketFees += PricesAndFees.LOST_TICKET_FEE;
    }

    private static LocalTime generateRandomCheckOutTime(Ticket ticket) {
        LocalTime checkOutTime = null;
        Random random = new Random();
        int hours = 0;
        int minutes = 0;

        hours = random.nextInt(23 + 1 - 13) + 13 ;
        minutes = random.nextInt(58) + 1;

        checkOutTime = LocalTime.of(hours, minutes);
        ticket.setCheck_Out_Time(checkOutTime);

        return checkOutTime;
    }

//    public static String calculateFees(Ticket ticket) {
//        NumberFormat numberFormatter = NumberFormat.getCurrencyInstance();
//        double fee = 0;
//        int hours = 0;
//        int minutes = 0;
//        int minimumHours = 3;
//
//        hours = (ticket.getCheck_Out_Time().getHour() - ticket.getCheck_In_Time().getHour());
//        minutes = (ticket.getCheck_Out_Time().getMinute() - ticket.getCheck_In_Time().getMinute());
//
//        hours = minutes > 0 ? hours + 1 : hours + 0;
//
//        if (hours <= minimumHours) {
//            fee = PricesAndFees.MINIMUM_FEE;
//        } else if(hours >= 15){
//           fee = PricesAndFees.MINIMUM_FEE;
//        }else{
//            int extraHours = hours - minimumHours;
//            fee = (extraHours * 1) + PricesAndFees.MINIMUM_FEE;
//        }
//
//        System.out.println(fee);
//
//        return numberFormatter.format(fee);
//    }
}

