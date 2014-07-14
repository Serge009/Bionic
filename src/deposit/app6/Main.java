package deposit.app6;

/*
How old are you in days and months? What day of week is your birthday?

Please, send your code and results of the program running.
*/


import java.time.*;
import java.time.format.DateTimeFormatter;


public class Main {

    public static void main(String[] args) {
        LocalDate d = LocalDate.of(1991, 9, 13);

        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String dayOfWeek = d.getDayOfWeek().toString();
        Period p = d.until(LocalDate.now());
        long months = p.toTotalMonths();
        int days = p.getDays();


        System.out.println("Date of birth: " + d.format(f));
        System.out.println("Day of birth: " + dayOfWeek);
        System.out.println(days + " day(s) and " + months + " month(s)");

    }

}
