import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckIn {
   private Scanner keyboard = new Scanner(System.in);
   private List<Ticket> parked_Cars;

public CheckIn(){parked_Cars = new ArrayList<>();}



    public CheckIn(Ticket ticket, List<Ticket> list){
       parked_Cars = list;
       ticket.setVehicleID(list.size() + 5);
       parked_Cars.add(ticket);
    }



    public void Machine() {
        System.out.println("Best Value Parking Garage\n===============================");
        System.out.println("1 - Check/In");
        System.out.println("3 - Close Garage");
        System.out.println("=>_");
        System.out.println("==================================");

        String ans = keyboard.nextLine();

        switch (ans) {
            case "1":
                CheckIn();
                break;
            case "3":
                for (Ticket t : new ParkingGarage(parked_Cars).getParked_Cars()) {
                    System.out.println("ID: " + t.getVehicleID());
                    System.out.println("check in time: " + t.getCheck_In_Time());
                    System.out.println("-----------");
                }
                break;
        }
    }

    public List<Ticket> getParked_Cars(){
        return parked_Cars;
    }

    public void CheckIn(){
//    FileOutput output = new FileOutput();
//    output.fileWrite(parked_Cars);
        new ParkingGarage(parked_Cars);

    }
    public void closeGarage(){

    }


}
