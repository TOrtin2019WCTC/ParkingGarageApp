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

    }
    private void generateReciept(){

    }
    private void generateLostReciept(){

    }



}
