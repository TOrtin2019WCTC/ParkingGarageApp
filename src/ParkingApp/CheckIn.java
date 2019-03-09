package ParkingApp;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckIn {
   public static Scanner keyboard = new Scanner(System.in);
   private List<Ticket> parked_Cars;

    public CheckIn(){
    }

    static void machine() {
        System.out.println("\n\n\tBest Value Parking Garage");
        System.out.println("\n\t===============================");
        System.out.println("\t1 - Check/In");
        System.out.println("\t3 - Close Garage");
        System.out.println("\t=>_");
        System.out.println("\t==================================\n\n");

        String ans = keyboard.nextLine();

        switch (ans) {
            case "1":
                GarageData.totalCheckIns++;
                Ticket t = new Ticket();
                System.out.println("Welcome, your check-in time is: " + t.getCheck_In_Time() + "am");
                break;
            case "3":
                closeGarage();
                break;
        }
    }

    public List<Ticket> getParked_Cars(){
        return parked_Cars;
    }

//    public void CheckIn(){
//        Ticket ticket = new Ticket();
//        new ParkingGarage().addCar(ticket);
//
//    }
    private static void closeGarage(){

        GarageData.totalFees = GarageData.totalCheckOutFees + GarageData.totalLostTicketFees;
        //NumberFormat numberFormatter = NumberFormat.getCurrencyInstance();
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
