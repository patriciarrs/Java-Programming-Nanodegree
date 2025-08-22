package _2javafundamentals._5commontypes._9datesandcalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatesAndCalendar {
    public static void main(String[] args) {
        displayCurrentDate();
        displaySetDate();
        formatDate();
    }

    public static void displayCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        Date date = new Date();
        calendar.setTime(date);
        System.out.println(calendar.getTime());
    }

    public static void displaySetDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2031, Calendar.MARCH, 2);
        Date date = calendar.getTime();
        System.out.println(date);
    }

    public static void formatDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        String formattedDate = formatter.format(currentDate);
        System.out.println(formattedDate);
    }
}
