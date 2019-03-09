package ParkingApp;

import java.text.NumberFormat;
import java.time.Duration;
import java.util.Currency;

public class PricesAndFees {
    static final double MINIMUM_FEE = 5.00; // 3 hour minimum
    static final double CHARGE_PER_ADDITIONAL_HOUR = 1.00;
    static final double LOST_TICKET_FEE = 25.00;
    static final double MAX_CHARGE = 15.00;
    static final int MINIMUM_HOURS = 3;
    static final int MAX_CHARGEABLE_HOURS = 15;



    static double calculateFees(Ticket ticket) {

        double fee = 0;
        long hours ;
        long minutes;

        try {
            hours = CheckOut.calculateHours(ticket);
            minutes = CheckOut.calculateMinutes(ticket);


            if (hours <= MINIMUM_HOURS) {
                fee = MINIMUM_FEE;
            } else if (hours >= MAX_CHARGEABLE_HOURS) {
                fee = MAX_CHARGE;
            } else {
                long extraHours = hours - MINIMUM_HOURS;
                fee = (extraHours * CHARGE_PER_ADDITIONAL_HOUR) + PricesAndFees.MINIMUM_FEE;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(fee);

        Main.totalCheckOutFees += fee;

        return fee;
    }

    public static String currencyFormatter(Object o) {
        String currencyFormatted = null;

        if (o != null) {
            NumberFormat numberFormatter = NumberFormat.getCurrencyInstance();
            currencyFormatted = numberFormatter.format(o);
        } else {
            throw new IllegalArgumentException();
        }


        return currencyFormatted;
    }



}
