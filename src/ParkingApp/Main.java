package ParkingApp;


import java.util.Scanner;

public class Main {


    static ParkingGarage garage;
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        String ans;
        // List<Ticket> list = new ArrayList<>();
        garage = new ParkingGarage();
        garage.garageListInitializer();
        System.out.println("GARAGE OPEN");
        garage.readTicketsFromFile();
        GarageData garageData = new GarageData();
        garageData.readDataFromFile();

            System.out.println("There are currently " + garage.getParked_Cars().size() +
                    " vehicle(s) in the garage \n\n");


        new CheckIn();
        new CheckOut();

        do {
            System.out.println("\t----------------------");
            System.out.println("\tPRESS 1 TO CHECK IN");
            System.out.println("\tPRESS 2 TO CHECK OUT");
            System.out.println("\tPRESS 3 TO EXIT PROGRAM AND WRITE DATA TO FILE");
            System.out.println("\t----------------------\n\n");
            ans = keyboard.nextLine();

            switch (ans) {
                case "1":
                    new CheckIn();
                    break;
                case "2":
                    new CheckOut();
            }

        } while (!ans.equals("3"));

        GarageData.totalFees = GarageData.totalCheckOutFees + GarageData.totalLostTicketFees;
        garageData.writeDataToFile(garageData.fileOuputString());

        System.out.println("GARAGE CLOSED");


    }

}
