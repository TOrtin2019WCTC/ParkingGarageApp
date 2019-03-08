package ParkingApp;

import java.util.ArrayList;
import java.util.List;

public class ParkingGarage {

    private List<Ticket> parked_Cars;
    private List<String> garageInfoToDate;
    public int totalCarsToDate;
    public double totalMoneyCollectedToDate;
    private int totalCars;
    private int carsAdded;
    private int carsRemoved;
    private double totalAmountsPaid;

    public ParkingGarage() {
        parked_Cars = new ArrayList<>();
    }


    public List<Ticket> getParked_Cars() {
        return parked_Cars;
    }

    public void setParked_Cars(List<Ticket> parked_Cars) {
        this.parked_Cars = parked_Cars;
    }

    public void addCar(Ticket ticket) {
        parked_Cars.add(ticket);
        totalCars++;
        System.out.println("total cars " + totalCars);
        System.out.println(parked_Cars.size());
        carsAdded++;
    }

    public void removeCar(Ticket ticket) {
        parked_Cars.remove(ticket);
        System.out.println(parked_Cars.size());
        carsRemoved--;
    }

    public int getTotalCars() {
        return totalCars;
    }

    public double getTotalAmountsPaid() {
        return totalAmountsPaid;
    }

    public void testDisplay() {
        System.out.println("Total cars to date:" + totalCarsToDate);
        System.out.println("Cars added " + carsAdded);
        System.out.println("Cars removed " + carsRemoved);
    }

}
