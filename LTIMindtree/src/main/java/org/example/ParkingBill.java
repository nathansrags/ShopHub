package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//Given two strings representing times of entry and exit from a car parking lot, find the cost of the ticket according to the given billing rules.
public class ParkingBill {
    public static void main(String[] args) {
        ParkingBill pb = new ParkingBill();
        String entry = "9:00";
        String exit = "13:21";
        int bill = pb.solution(entry, exit);
        System.out.println("$ " + bill + ".00");
    }

    private int solution(String entry, String exit) {
        try {
            final int MILL_PER_HOUR = 60 * 60 * 1000;
            final int MILL_PER_MINUTE = 60 * 1000;
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            Date entryTime = format.parse(entry);
            Date exitTime = format.parse(exit);
            long difference = exitTime.getTime() - entryTime.getTime();
            long hours = difference / MILL_PER_HOUR;
            long minutes = (difference / MILL_PER_MINUTE) % 60;
            System.out.println("Hours = "+ hours + " minutes ="+ minutes);
            return calculateBill(hours, minutes);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private int calculateBill(long hours, long mins) {
        final int ENTRANCE_FEE = 2;
        final int FIRST_HOUR = 3;
        final int SUC_HOURS = 4;

        int bill = 0;
        if (hours > 1) {
            bill = (int) (ENTRANCE_FEE + FIRST_HOUR + ((hours - 1) * SUC_HOURS));
        }
        if (mins > 0) {
            bill = bill + SUC_HOURS;
        }
        return bill;
    }

}
