package ParkingApp;

import java.text.NumberFormat;

public class Reciept  {

    Ticket ticket;



    public Reciept(Ticket ticket){
        this.ticket = ticket;
    }


    public void generateReciept(){

        System.out.println("\n\nBest Value Parking Garage");
        System.out.println("\n============================");
        System.out.println("\nReciept for vehicle id " + this.ticket.getVehicleID());
        System.out.println(this.ticket.getCheck_In_Time());
        System.out.println("$" + PricesAndFees.LOST_TICKET_FEE);
        System.out.println("------------------------------\n\n");

    }
    public void generateLostReciept(){
        NumberFormat numberFormatter = NumberFormat.getCurrencyInstance();
        System.out.println("\n\nBest Value Parking Garage");
        System.out.println("\n============================");
        System.out.println("\nReciept for vehicle id " + this.ticket.getVehicleID());
        System.out.println("\n\nLost Ticket");
        System.out.println(numberFormatter.format(PricesAndFees.LOST_TICKET_FEE));
        System.out.println("------------------------------\n\n");


    }



}
