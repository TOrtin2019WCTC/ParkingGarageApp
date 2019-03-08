import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Ticket implements Serializable {
    private LocalDateTime check_In_Time;
    private int vehicleID;

    public Ticket(){}

    public Ticket(int vehicleID, LocalDateTime check_In_Time){
        this.vehicleID = vehicleID;
        this.check_In_Time = check_In_Time;

    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }


    public int getVehicleID() {
        return vehicleID;
    }
    public LocalDateTime getCheck_In_Time() {
        return check_In_Time;
    }
}
