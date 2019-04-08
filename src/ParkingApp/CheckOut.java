package ParkingApp;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class CheckOut {

    //private Scanner keyboard = new Scanner(System.in);

    public CheckOut() {
        machine();
    }


    public void machine() {
        System.out.println("\n\n\tBest Value Parking Garage");
        System.out.println("\n\t===============================");
        System.out.println("\t1 - Check/Out");
        System.out.println("\t2 - Lost Ticket");
        System.out.println("\t=>_");
        System.out.println("\t==================================");

        String ans = Main.keyboard.nextLine();

        switch (ans) {
            case "1":
                checkOut();
                break;
            case "2":
                lostTicket();
                break;
        }
    }

    private void checkOut() {
        try {
            Random random = new Random();
            int index = random.nextInt(Main.garage.getParked_Cars().size());
            Ticket ticketToRemove = Main.garage.getParked_Cars().get(index);
            ticketToRemove.setCheck_Out_Time(generateRandomCheckOutTime());
            Main.garage.removeCar(index);
            Receipt receipt = new Receipt(ticketToRemove);
            receipt.generateReceipt();

        } catch (IllegalArgumentException e) {
            System.out.println("There are currently no cars in the garage, perhaps you illegally entered and never" +
                    " received a ticket");
            System.out.print("Generating lost ticket receipt.....\n");
            new Receipt().generateLostReceiptWithNoTicketID();

        }
        GarageData.totalLostTickets++;
        GarageData.totalLostTicketFees += PricesAndFees.LOST_TICKET_FEE;


    }

    private void lostTicket() {
        try {
            Random random = new Random();
            int index = random.nextInt(Main.garage.getParked_Cars().size());
            Ticket ticketToRemove = Main.garage.getParked_Cars().get(index);
            Main.garage.removeCar(index);
            new Receipt(ticketToRemove).generateLostReceipt();


        } catch (Exception e) {
            new Receipt().generateLostReceiptWithNoTicketID();
            GarageData.totalLostTickets++;
            GarageData.totalLostTicketFees += PricesAndFees.LOST_TICKET_FEE;
        }

        GarageData.totalLostTickets++;
        GarageData.totalLostTicketFees += PricesAndFees.LOST_TICKET_FEE;

    }

    private LocalTime generateRandomCheckOutTime() {
        LocalTime checkOutTime = null;
        Random random = new Random();
        int hours = 0;
        int minutes = 0;

        hours = random.nextInt(11) + 13;
        minutes = random.nextInt(59);

        checkOutTime = LocalTime.of(hours, minutes);

        return checkOutTime;
    }

    static long calculateHours(Ticket ticket) {
        long hours = 0;

        hours = Duration.between(ticket.getCheck_In_Time(), ticket.getCheck_Out_Time()).toHours();

        return hours;
    }

    static long calculateMinutes(Ticket ticket) {
        long minutes = 0;

        minutes = Duration.between(ticket.getCheck_In_Time(), ticket.getCheck_Out_Time()).toMinutes();

        while (minutes > 60) {
            minutes -= 60;
        }
        return minutes;
    }


}

