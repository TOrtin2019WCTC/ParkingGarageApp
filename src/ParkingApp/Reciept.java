package ParkingApp;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;

public class Reciept  {

    Ticket ticket;



    public Reciept(Ticket ticket){
        this.ticket = ticket;
    }


    public void generateReciept(){

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("h:mm");
        System.out.println("\n\n\tBest Value Parking Garage");
        System.out.println("\n\t===============================");
        System.out.println("\n\tReceipt for vehicle id " + this.ticket.getVehicleID());

        System.out.println("\n\t" + CheckOut.calculateHours(this.ticket) + " hours "
                + CheckOut.calculateMinutes(this.ticket) + " minutes parked"
                + "\n\t" + fmt.format(this.ticket.getCheck_In_Time())
                + "am - " + fmt.format(this.ticket.getCheck_Out_Time()) + "pm");

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
