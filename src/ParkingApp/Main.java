package ParkingApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        List<Ticket> list = new ArrayList<>();
        new CheckIn();
       FileInput in = new FileInput();
       in.fileRead();
       in.fileClose();
       list = in.getParked();
       ParkingGarage garage = new ParkingGarage();
       garage.setParked_Cars(list);
        System.out.println("GARAGE OPEN\n\n");
        String ans;

        do{
            System.out.println("1 Check/In");
            System.out.println("2 Check/Out");
            ans = keyboard.nextLine();

            switch(ans){
                case "1":
                    CheckIn.Machine();
                    break;
                case "2":
                    CheckOut.machine();
            }

        }while(!ans.equals("3"));
        FileOutput out = new FileOutput();
        out.fileWrite(list);
        out.fileClose();



    }

}
