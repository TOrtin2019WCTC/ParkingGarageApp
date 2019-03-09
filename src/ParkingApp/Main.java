package ParkingApp;


import java.util.Scanner;

public class Main {


    static ParkingGarage garage;

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String ans;
        // List<Ticket> list = new ArrayList<>();
        garage = new ParkingGarage();
        garage.garageListInitializer();
        garage.readTicketsFromFile();
        GarageData garageData = new GarageData();
        garageData.readDataFromFile();

        System.out.println("GARAGE OPEN");
        System.out.println("There are currently " + garage.getParked_Cars().size() +
                " schmucks who haven't left the garage yet\n\n");

        new CheckIn();
        new CheckOut();

        do {
            System.out.println("\t----------------------");
            System.out.println("\tPRESS 1 TO CHECK IN");
            System.out.println("\tPRESS 2 TO CHECK OUT");
            System.out.println("\tPRESS 3 TO EXIT PROGRAM");
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
