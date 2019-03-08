import java.util.List;

public class ParkingGarage {

    private List<Ticket> parked_Cars;

    public ParkingGarage(){

        }



    public ParkingGarage(List<Ticket> list) {
        parked_Cars = list;

    }

    public List<Ticket> getParked_Cars() {
        return parked_Cars;
    }

    public void AddCar(List<Ticket> tickets){
        parked_Cars.addAll(tickets);
    }

}
