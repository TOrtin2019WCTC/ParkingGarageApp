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



    public static void Machine() {
        System.out.println("\n\nBest Value Parking Garage\n===============================");
        System.out.println("1 - Check/In");
        System.out.println("3 - Close Garage");
        System.out.println("=>_");
        System.out.println("==================================\n\n");

        String ans = keyboard.nextLine();

        switch (ans) {
            case "1":
                Main.totalCheckIns++;
                Ticket t = new Ticket();
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

        Main.totalFees = Main.totalCheckOutFees + Main.totalLostTicketFees;
        //NumberFormat numberFormatter = NumberFormat.getCurrencyInstance();
        System.out.println("\n\nBest Value Parking Garage");
        System.out.println("\n============================");
        System.out.println("Activity to Date\n");
        System.out.println(PricesAndFees.currencyFormatter(Main.totalCheckOutFees) + " was collected from " + Main.totalCheckIns +
                " Check Ins");
        System.out.println(PricesAndFees.currencyFormatter(Main.totalLostTicketFees) + " was collected from " + Main.totalLostTickets +
                " Lost Tickets\n");
        System.out.println(PricesAndFees.currencyFormatter(Main.totalFees) + " was collected overall");
        System.out.println("------------------------------\n\n");

    }


}
