package javaintro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Dawei on 10/10/2016.
 */
public class DateTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();

        SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
        Date date = null;
        try {
            date = sdf.parse(month + day + year);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int d = c.get(Calendar.DAY_OF_WEEK);
        String dw = "";
        switch(d) {
            case 1: dw = "SUNDAY"; break;
            case 2: dw = "MONDAY"; break;
            case 3: dw = "TUESDAY"; break;
            case 4: dw = "WEDNESDAY"; break;
            case 5: dw = "THURSDAY"; break;
            case 6: dw = "FRIDAY"; break;
            case 7: dw = "SATURDAY"; break;
        }
        System.out.println(dw);

    }
}
