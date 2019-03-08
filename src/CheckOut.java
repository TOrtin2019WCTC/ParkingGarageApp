import java.util.List;
import java.util.Scanner;

public class CheckOut {
    private Scanner keyboard = new Scanner(System.in);
    private List<Ticket> parked_Cars;


    public CheckOut(List<Ticket> list){
        ParkingGarage garage = new ParkingGarage(list);
        parked_Cars = list;
//        for(Ticket t : garage.getParked_Cars()){
//            parked_Cars.add(t);
//        }


        }


    public void Machine() {
        System.out.println("1 - Check/Out");
        System.out.println("2 - Lost Ticket");
        System.out.println("=>_");

        String ans = keyboard.nextLine();

        switch (ans) {
            case "1":
                CheckOut();
                break;
            case "2":
                for (Ticket t : new ParkingGarage(parked_Cars).getParked_Cars()) {
                    System.out.println("ID: " + t.getVehicleID());
                    System.out.println("check in time: " + t.getCheck_In_Time());
                    System.out.println("-----------");
                }
                break;
        }
    }

    public void CheckOut(){
        System.out.println(parked_Cars.toString());
        int random = (int) (Math.random() * parked_Cars.size());
       Ticket t = parked_Cars.get(random);
       parked_Cars.remove(t);

        System.out.println(parked_Cars.toString());

    }
}

