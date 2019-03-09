package ParkingApp;

import java.io.*;
import java.util.List;


class FileOutput {

    FileOutputStream fos = null;
    ObjectOutputStream obj = null;
    BufferedWriter writer = null;
    FileWriter fw = null;
    private final String TICKET_PATH = "/Users/tim/ParkingApp_Test/src/ParkingApp/files/Garage.txt";


    public FileOutput() {
        try {
            fos = new FileOutputStream(TICKET_PATH);
            obj = new ObjectOutputStream(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fileWrite(List<Ticket> t) {

        try {
            obj.writeObject(t);

        } catch (Exception e) {
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

    public void fileWriteData(String s) {
        try {
            fw.write(s);
            fw.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}

