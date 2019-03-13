package ParkingApp;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
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
        Main.garage.addCar(this);
        GarageData.totalCheckIns++;

    }

    public int getVehicleID() {
        return vehicleID;
    }

    public LocalTime getCheck_In_Time() {
        return check_In_Time;
    }

    public void setCheck_Out_Time(LocalTime check_Out_Time) {
        this.check_Out_Time = check_Out_Time;
    }

    public LocalTime getCheck_Out_Time() {
        return check_Out_Time;
    }


    private LocalTime generateRandomCheckInTime() {
        Random random = new Random();
        int hours = 0;
        int minutes = 0;
        hours = random.nextInt(11 + 1 - 7) + 7;

        minutes = random.nextInt(59) + 1;
        check_In_Time = LocalTime.of(hours, minutes);
        return check_In_Time;
    }

    public LocalTime generateRandomCheckOutTime() {
        Random random = new Random();
        int hours = 0;
        int minutes = 0;

        hours = random.nextInt(11) + 13;
        minutes = random.nextInt(60);

        check_Out_Time = LocalTime.of(hours, minutes);

        return check_Out_Time;
    }

    private int generateVehicleID() {
        List<Integer> ticketID = new ArrayList<>();
        ParkingGarage garage = new ParkingGarage();
        boolean isAMatch = true;
        int id = (int) (Math.random() * (500 - 1) + 1);
        if (garage.getParked_Cars().size() > 0) {
            for (Ticket t : garage.getParked_Cars()) {
                ticketID.add(t.getVehicleID());
            }
        } else {
            vehicleID = id;
        }

        if (ticketID.size() > 0) {
            while (isAMatch) {
                if (!ticketID.contains(id)) {
                    isAMatch = false;
                    vehicleID = id;
                } else {
                    id = (int) (Math.random() * (500 - 1) + 1);
                }
            }
        }


        return vehicleID;


    }


}

