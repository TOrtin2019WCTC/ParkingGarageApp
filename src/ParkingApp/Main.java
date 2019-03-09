package ParkingApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int totalCheckIns = 0;
    public static double totalCheckOutFees = 0;
    public static int totalLostTickets = 0;
    public static double totalLostTicketFees = 0;
    public static double totalFees = 0;
    public static ParkingGarage garage = new ParkingGarage();
    protected static FileInput in = new FileInput();

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String ans;
        // List<Ticket> list = new ArrayList<>();
        garage = new ParkingGarage();
        garage.garageListInitializer();

        for (int i = 0; i < 50;i++){
            new Ticket();
        }
        in.fileClose();
        //garage.setParked_Cars(list);
        System.out.println("GARAGE OPEN\n\n");

        CheckIn.machine();
        CheckOut.machine();


        do {
            System.out.println("\t----------------------");
            System.out.println("\tPRESS 1 TO CHECK IN");
            System.out.println("\tPRESS 2 TO CHECK OUT");
            System.out.println("\tPRESS 3 TO EXIT PROGRAM");
            System.out.println("\t----------------------");
            ans = keyboard.nextLine();

            switch (ans) {
                case "1":
                    CheckIn.machine();
                    break;
                case "2":
                    CheckOut.machine();
            }

        } while (!ans.equals("3"));

        totalFees = totalCheckOutFees + totalLostTicketFees;
        FileOutput out = new FileOutput();
        out.fileWrite(garage.getParked_Cars());
        out.fileClose();


    }

}
