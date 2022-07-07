package utils;

import models.Booking;

import java.time.LocalDate;
import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {

    @Override
    public int compare(Booking o1, Booking o2) {
        LocalDate startDate1 = o1.getStartDate();
        LocalDate startDate2 = o2.getStartDate();
        LocalDate endDate1 = o1.getEndDate();
        LocalDate endDate2 = o2.getEndDate();
        if (startDate1.compareTo(startDate2) > 0) {
            return 1;
        } else if (startDate1.compareTo(startDate2) < 0) {
            return -1;
        } else {
            return Integer.compare(endDate1.compareTo(endDate2), 0);
        }
    }
}
