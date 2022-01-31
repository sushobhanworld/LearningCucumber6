package example.Utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DateUtility
{
    public static String GetStartDate(int day)
    {
        Date date= new Date();
        Calendar calendar= Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        Date date1= calendar.getTime();
        String startDate= date1.toString();
        String[] s=startDate.split(" ");
        return s[1]+" "+s[2]+" "+s[5];
    }

    public static String GetReturnDate(int day)
    {
        Date date= new Date();
        Calendar calendar= Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        Date date1= calendar.getTime();
        String returnDate= date1.toString();
        String[] s=returnDate.split(" ");
        return s[1]+" "+s[2]+","+" "+s[5];
    }

    private static long DateDifferenceInDays(String futureDate) throws ParseException {
        Date date1= new Date();
        Date date2;

        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("MM/dd/yyyy");
        System.out.println(simpleDateFormat.format(date1));
        date2= simpleDateFormat.parse(futureDate);
        long diff= date2.getTime()- date1.getTime();
        return ChronoUnit.DAYS.between(date1.toInstant(), date2.toInstant());
    }
    public static void main(String[] args) throws ParseException {
        System.out.println(GetStartDate(2));
        System.out.println(GetReturnDate(5));
        System.out.println(DateDifferenceInDays("12/2/2021"));
    }
}
