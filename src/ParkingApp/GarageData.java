package ParkingApp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class GarageData {
    static double totalCheckIns;
    static double totalCheckOutFees;
    static double totalLostTickets;
    static double totalLostTicketFees;
    static double totalFees;
    List<Double> garageData;
    private final String DATA_PATH = "/Users/tim/ParkingApp_Test/src/ParkingApp/files/GarageDataToDate.txt";

    public GarageData() {
        garageData = new ArrayList<>();
        totalCheckIns = 0;
        totalCheckOutFees = 0;
        totalLostTicketFees = 0;
        totalLostTickets = 0;
        totalFees = 0;
    }


    public static double getTotalCheckIns() {
        return totalCheckIns;
    }

    public static double getTotalCheckOutFees() {
        return totalCheckOutFees;
    }


    public static double getTotalLostTickets() {
        return totalLostTickets;
    }


    public static double getTotalLostTicketFees() {
        return totalLostTicketFees;
    }


    public static double getTotalFees() {
        return totalFees;
    }


    public List<Double> getGarageData() {
        return garageData;
    }

    public void setGarageData(List<Double> garageData) {
        this.garageData = garageData;
    }

    public String fileOuputString(){
        return getTotalCheckOutFees() + "," + getTotalCheckIns() + "," + getTotalLostTicketFees() + "," +
                getTotalLostTickets() + "," + getTotalFees();
    }

    public void writeDataToFile(String s) {
        try{
            FileWriter fw;

            BufferedWriter writer = new BufferedWriter(fw = new FileWriter(DATA_PATH));
            fw.write(s);

            fw.close();
            writer.close();


        }catch(Exception e){
            e.printStackTrace();
            e.getMessage();
        }



    }

}
