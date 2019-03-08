package ParkingApp;

public class Reciept  {

    private final double MINIMUM_FEE = 5.00;
    private final double CHARGE_PER_ADDITIONAL_HOUR = 1.00;
    private final double LOST_TICKET_FEE = 25.00;
    private final double MAX_CHARGE = 15.00;
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

        System.out.println("Best Value Parking Garage");
        System.out.println("\n============================");
        System.out.println("\nReciept for vehicle id " + this.ticket.getVehicleID());
        System.out.println("\n\nLost Ticket");
        System.out.println("$" + LOST_TICKET_FEE);


    }



}
