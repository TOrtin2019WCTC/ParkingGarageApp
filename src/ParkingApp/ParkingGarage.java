package ParkingApp;

import java.util.ArrayList;
import java.util.List;

 class ParkingGarage {

    static List<Ticket> parked_Cars;
    private boolean isListInitialized = false;
    //private List<String> garageInfoToDate;


    public ParkingGarage(List<Ticket> list) {
        //parked_Cars = new ArrayList<>();
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
    }

    public void removeCar(int i) {
        parked_Cars.remove(i);
    }


    public void garageListInitializer(){
        while(!isListInitialized){
            parked_Cars = new ArrayList<>();
            this.isListInitialized = true;
        }

    }

}
