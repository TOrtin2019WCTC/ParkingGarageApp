package ParkingApp;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckIn {
    //public static Scanner keyboard = new Scanner(System.in);
    //private List<Ticket> parked_Cars;

    public CheckIn() {
        machine();
    }

    public void machine() {
        System.out.println("\n\n\tBest Value Parking Garage");
        System.out.println("\n\t===============================");
        System.out.println("\t1 - Check/In");
        System.out.println("\t3 - Close Garage"); //generateReport()?
        System.out.println("\t=>_");
        System.out.println("\t==================================\n\n");

        String ans = Main.keyboard.nextLine();

        switch (ans) {
            case "1":
                Ticket ticket = new Ticket();
                System.out.println("Welcome, your check-in time is: " + ticket.getCheck_In_Time() + "am");
                break;
            case "3":
                closeGarage();
                break;
        }
    }

// maybe change name to generateReport?
    private void closeGarage() {


        GarageData.totalFees = GarageData.totalCheckOutFees + GarageData.totalLostTicketFees;

        System.out.println("\n\n\tBest Value Parking Garage");
        System.out.println("\n\t===============================");
        System.out.println("\tActivity to Date\n");
        System.out.println("\t" + PricesAndFees.currencyFormatter(GarageData.totalCheckOutFees) + " was collected from " + GarageData.totalCheckIns +
                " Check Ins");
        System.out.println("\t" + PricesAndFees.currencyFormatter(GarageData.totalLostTicketFees) + " was collected from " + GarageData.totalLostTickets +
                " Lost Tickets\n");
        System.out.println("\t" + PricesAndFees.currencyFormatter(GarageData.totalFees) + " was collected overall");
        System.out.println("\t------------------------------\n\n");

    }


}
