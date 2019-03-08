package ParkingApp;

import java.io.*;
import java.util.List;


class FileOutput {

    FileOutputStream fos = null;
    ObjectOutputStream obj = null;
    private String path = "/Users/tim/ParkingApp_Test/src/ParkingApp/Garage.txt";

    public FileOutput() {
        try {
            fos = new FileOutputStream(path);
            obj = new ObjectOutputStream(fos);

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void fileWrite(List<Ticket> t) {

        try{
            obj.writeObject(t);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void fileClose() {
        if (obj != null) {
            try {
                obj.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}

