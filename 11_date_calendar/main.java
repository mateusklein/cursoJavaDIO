import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class main {
    public static void main(String[] args) {
       /*
         * DATE:
        */
        

        var date = new Date();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
        System.out.println(date);
        System.out.println(formatter);


        /*depreciado:
        var month = date.getMonth();
        System.out.println(month);
        */


        /*
         * CALENDAR:
        */


        var calendar = Calendar.getInstance();


        System.out.println(calendar);
        DateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss Z");
        System.out.println(formatter2.format(calendar.getTime()));


        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));


        calendar.set(Calendar.YEAR, 2030);
        System.out.println(calendar.get(Calendar.YEAR));
    }
}
