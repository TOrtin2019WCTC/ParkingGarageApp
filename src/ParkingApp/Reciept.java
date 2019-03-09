package ParkingApp;

import java.text.NumberFormat;

public class Reciept  {

    Ticket ticket;



    public Reciept(Ticket ticket){
        this.ticket = ticket;
    }


    public void generateReciept(){

        System.out.println("\n\n\tBest Value Parking Garage");
        System.out.println("\n\t===============================");
        System.out.println("\n\tReceipt for vehicle id " + this.ticket.getVehicleID());

        System.out.println("\n\t" + CheckOut.calculateHours(this.ticket) + " hours "
                + CheckOut.calculateMinutes(this.ticket) + " minutes parked"
                + "\n" + this.ticket.getCheck_In_Time()
                + "am - " + this.ticket.getCheck_Out_Time()+ "pm");

        System.out.println("\n\t" + PricesAndFees.currencyFormatter(PricesAndFees.calculateFees(this.ticket)));
        System.out.println("\n\t------------------------------\n\n");

    }
    public void generateLostReciept(){
        NumberFormat numberFormatter = NumberFormat.getCurrencyInstance();
        System.out.println("\n\n\tBest Value Parking Garage");
        System.out.println("\n\t===============================");
        System.out.println("\n\tReciept for vehicle id " + this.ticket.getVehicleID());
        System.out.println("\n\n\tLost Ticket");
        System.out.println("\t" + numberFormatter.format(PricesAndFees.LOST_TICKET_FEE));
        System.out.println("\t------------------------------\n\n");


    }



}
