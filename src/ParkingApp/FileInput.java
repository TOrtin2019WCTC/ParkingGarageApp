package ParkingApp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.ArrayList;


public class FileInput {
    FileInputStream fis = null;
    ObjectInputStream obj = null;
    List<Ticket> parked;
    private final String FILE_NAME = "/Users/tim/ParkingApp_Test/src/ParkingApp/Garage.txt";

    public FileInput(){
        try{
            fis = new FileInputStream(FILE_NAME);
            obj = new ObjectInputStream(fis);
        }catch(Exception e){
            e.printStackTrace();
        }


    }
    public void fileRead(){
        parked = new ArrayList<>();
        boolean endOfFile = false;
        while(endOfFile == false){
            try{
                parked = ((List) obj.readObject());
                //parked.add(ticket);
            }catch(Exception e){
                e.printStackTrace();
            }

           // System.out.println(parked.toString());
            endOfFile = true;
        }

    }

    public void fileClose(){

        try {
            fis.close();
            obj.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List getParked(){
        return parked;
    }


}
