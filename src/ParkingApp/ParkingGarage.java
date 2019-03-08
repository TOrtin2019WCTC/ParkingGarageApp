package ParkingApp;

import java.util.ArrayList;
import java.util.List;

public class ParkingGarage {

   private List<Ticket> parked_Cars;
  private List<String> garageInfoToDate;
   public int totalCarsToDate;
   public double totalMoneyCollectedToDate;
    private int totalCars;
   private double totalAmountsPaid;

    public ParkingGarage(){
            parked_Cars = new ArrayList<>();
        }


    public List<Ticket> setParked_Cars(){
        this.parked_Cars = parked_Cars;
        return parked_Cars;
    }

    public List<Ticket> getParked_Cars() {
        return parked_Cars;
    }

    public void setParked_Cars(List<Ticket> parked_Cars) {
        this.parked_Cars = parked_Cars;
    }

    public void addCar(Ticket ticket){
        parked_Cars.add(ticket);
        totalCars ++;
    }

    public void removeCar(Ticket ticket){
        parked_Cars.remove(ticket);
    }
    public int getTotalCars() {
        return totalCars;
    }

    public double getTotalAmountsPaid() {
        return totalAmountsPaid;
    }

}
