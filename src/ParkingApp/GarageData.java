package ParkingApp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class GarageData {
    static int totalCheckIns;
    static double totalCheckOutFees;
    static int totalLostTickets;
    static double totalLostTicketFees;
    static double totalFees;
    List<Double> garageData;
    private final String DATA_PATH = "/Users/tim/ParkingApp_Test/src/ParkingApp/files/GarageDataToDate.csv";

    public GarageData() {
        garageData = new ArrayList<>();
        totalCheckIns = 0;
        totalCheckOutFees = 0;
        totalLostTicketFees = 0;
        totalLostTickets = 0;
        totalFees = 0;
    }


    private int getTotalCheckIns() {
        return totalCheckIns;
    }

    private double getTotalCheckOutFees() {
        return totalCheckOutFees;
    }

    private int getTotalLostTickets() {
        return totalLostTickets;
    }

    private double getTotalLostTicketFees() {
        return totalLostTicketFees;
    }


    private double getTotalFees() {
        return totalFees;
    }


    public String fileOutputString() {
        return "TotalCheckOutFees,TotalCheckIns,TotalLostTicketFees,TotalLostTickets,TotalFees\n" +
                getTotalCheckOutFees() + "," + (int) getTotalCheckIns() + "," + getTotalLostTicketFees() + "," +
                (int) getTotalLostTickets() + "," + getTotalFees();
    }

    public void writeDataToFile(String s) {
        BufferedWriter writer;

        try {

            writer = new BufferedWriter(new FileWriter(DATA_PATH));
            writer.write(s);
            writer.close();

            Main.garage.writeTicketsToFile();

        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }


    }

    public void readDataFromFile() {

        String path = DATA_PATH;
        String line;


        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(path));
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] tempList = line.split(",");
                totalCheckOutFees = Double.parseDouble(tempList[0]);
                totalCheckIns = Integer.parseInt(tempList[1]);
                totalLostTicketFees = Double.parseDouble(tempList[2]);
                totalLostTickets = Integer.parseInt(tempList[3]);
                totalFees = Double.parseDouble(tempList[4]);

            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }


    }

}
