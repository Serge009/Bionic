package deposit.app7;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        int c;
        int n;
        int k;
        int i;
        int j;
        int l;
        int m;
        int d;
        int y = 2016;

        LocalDate date;
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        c = y / 100;
        n = y - 19 * ( y / 19 );
        k = ( c - 17 ) / 25;
        i = c - c / 4 - ( c - k ) / 3 + 19 * n + 15;
        i = i - 30 * ( i / 30 );
        i = i - ( i / 28 ) * ( 1 - ( i / 28 ) * ( 29 / ( i + 1 ) ) * ( ( 21 - n ) / 11 ) );
        j = y + y / 4 + i + 2 - c + c / 4;
        j = j - 7 * ( j / 7 );
        l = i - j;
        m = 3 + ( l + 40 ) / 44;
        d = l + 28 - 31 * ( m / 4 );

        date = LocalDate.of(y, m, d);
        System.out.print(date.format(f));

    }

}
