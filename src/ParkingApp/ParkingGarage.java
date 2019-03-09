package ParkingApp;

import java.util.ArrayList;
import java.util.List;

public class ParkingGarage {

    static List<Ticket> parked_Cars;
    //private List<String> garageInfoToDate;


    public ParkingGarage(List<Ticket> list) {
        parked_Cars = new ArrayList<>();
        //parked_Cars = list;
//        totalMoneyCollectedToDate = 0;
//        garageInfoToDate = new ArrayList<>();
//        totalCars = new ArrayList<>();
//        carsAdded = new ArrayList<>();

    }
    public ParkingGarage(Ticket ticket){

    }
    public ParkingGarage(){

    }


    public List<Ticket> getParked_Cars() {
        return parked_Cars;
    }

    public void setParked_Cars(List<Ticket> parked_Cars) {
        this.parked_Cars = parked_Cars;
    }


    public void addCar(Ticket ticket) {
        parked_Cars.add(ticket);
        System.out.println(parked_Cars.size());
        System.out.println("total cars added " + parked_Cars.size());
    }

    public void removeCar(int i) {
        parked_Cars.remove(i);
        System.out.println(parked_Cars.size());
    }

    public void testDisplay() {
//        System.out.println("Total cars to date:" + totalCarsToDate);
//        System.out.println("Cars added " + carsAdded);
//        System.out.println("Cars removed " + carsRemoved);
        System.out.println(parked_Cars.size() + " Cars in garage");
        for (Ticket t: parked_Cars){
            System.out.println(t.toString());
            System.out.println();
        }
    }

}
