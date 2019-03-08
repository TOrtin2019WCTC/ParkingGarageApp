package ParkingApp;

public class Reciept  {

    Ticket ticket;



    public Reciept(Ticket ticket){
        this.ticket = ticket;
    }

    private void calculateHoursParked(){
        this.ticket.getCheck_In_Time();
        this.ticket.getCheck_Out_Time();


    }
    public void generateReciept(){

    }
    public void generateLostReciept(){

        System.out.println("\n\nBest Value Parking Garage");
        System.out.println("\n============================");
        System.out.println("\nReciept for vehicle id " + this.ticket.getVehicleID());
        System.out.println("\n\nLost Ticket");
        System.out.println("$" + PricesAndFees.LOST_TICKET_FEE);
        System.out.println("------------------------------\n\n");


    }



}
