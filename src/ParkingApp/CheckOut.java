package ParkingApp;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CheckOut {
    public static Scanner keyboard = new Scanner(System.in);
//    private List<Ticket> parked_Cars;
//    private int ticketNumber;


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

        Random random = new Random();
        int index = random.nextInt(Main.garage.getParked_Cars().size());
        Ticket ticketToRemove = Main.garage.getParked_Cars().get(index);
        ticketToRemove.setCheck_Out_Time(generateRandomCheckOutTime());
        Main.garage.removeCar(index);
        Reciept reciept = new Reciept(ticketToRemove);
        reciept.generateReciept();
        //PricesAndFees.calculateFees(ticketToRemove);


    }

    private static void lostTicket() {
        Random random = new Random();
        int index = random.nextInt(Main.garage.getParked_Cars().size());
        Ticket ticketToRemove = Main.garage.getParked_Cars().get(index);
        Main.garage.removeCar(index);
        Reciept reciept = new Reciept(ticketToRemove);
        reciept.generateLostReciept();
        GarageData.totalLostTickets++;
        GarageData.totalLostTicketFees += PricesAndFees.LOST_TICKET_FEE;
    }

    private static LocalTime generateRandomCheckOutTime() {
        LocalTime checkOutTime = null;
        Random random = new Random();
        int hours = 0;
        int minutes = 0;

        hours = random.nextInt(23 + 1 - 13) + 13;
        minutes = random.nextInt(58) + 1;

        checkOutTime = LocalTime.of(hours, minutes);
       // ticket.setCheck_Out_Time(checkOutTime);

        return checkOutTime;
    }

    static long calculateHours(Ticket ticket) {
         long hours = 0;

         hours = Duration.between(ticket.getCheck_In_Time(),ticket.getCheck_Out_Time()).toHours();

        return hours;
    }

    static long calculateMinutes(Ticket ticket) {
        long minutes = 0;

        minutes = Duration.between(ticket.getCheck_In_Time(),ticket.getCheck_Out_Time()).toMinutes();

        while (minutes > 60){
            minutes -= 60;
        }
        return minutes;
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

