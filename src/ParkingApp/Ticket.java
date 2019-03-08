package ParkingApp;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

public class Ticket implements Serializable {
    private LocalTime check_In_Time;
    private int vehicleID;
    private LocalTime check_Out_Time;


    public Ticket() {
        this.vehicleID = generateVehicleID();
        this.check_In_Time = generateRandomCheckInTime();
        this.check_Out_Time = null;
        ParkingGarage garage = new ParkingGarage();
        garage.addCar(this);

    }


    public int getVehicleID() {
        return vehicleID;
    }

    public LocalTime getCheck_In_Time() {
        return check_In_Time;
    }

    public void setLocalTime() {
        this.check_Out_Time = check_Out_Time;
    }

    public LocalTime getCheck_Out_Time() {
        return check_Out_Time;
    }

    private LocalTime generateRandomCheckInTime() {
        Random random = new Random();
        int hours = 0;
        int minutes = 0;

        hours = random.nextInt(7 * 10) + 1;
        minutes = random.nextInt(58) + 1;

        check_In_Time = LocalTime.of(hours, minutes);


        return check_In_Time;
    }

    private LocalTime generateRandomCheckOutTime() {
        Random random = new Random();
        int hours = 0;
        int minutes = 0;

        hours = random.nextInt(1 * 10) + 1;
        minutes = random.nextInt(58) + 1;

        check_Out_Time = LocalTime.of(hours, minutes);

        return check_Out_Time;
    }

    private int generateVehicleID() {
        boolean isAMatch = false;
        ParkingGarage garage = new ParkingGarage();
        int id = (int) (Math.random() * (500 - 1) + 1);

        do {
            for (Ticket t : garage.getParked_Cars()) {
                if (id == t.getVehicleID()) {
                    isAMatch = true;
                    id = (int) (Math.random() * (500 - 1) + 1);
                }

            }
        } while (isAMatch = true);

        vehicleID = id;

        return vehicleID;


    }


}

