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
        System.out.println("\nReceipt for vehicle id " + this.ticket.getVehicleID());
        System.out.println("\n"CheckOut.calculateHours(this.ticket) + " hours parked " + this.ticket.getCheck_In_Time().getHour()
                + "am - " + this.ticket.getCheck_Out_Time().getHour() + "pm");
        System.out.println("$" + PricesAndFees.calculateFees(this.ticket));
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
