package test3.deposit;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by oper4 on 25.07.2014.
 */
public class SimpleDeposit extends AbstractDeposit {


    @Override
    public void calculateInterest() {
        double daysInYear;
        double daysInYear1;
        double daysInYear2;
        double period1;
        double period2;

        if(startDate.getYear() == maturityDate.getYear()){
            if(startDate.isLeapYear()){
                daysInYear = 366;
            } else {
                daysInYear = 365;
            }

            this.interest = this.sum * (this.rate / 100.0) * (this.duration / daysInYear);
        } else {
            period1 = ChronoUnit.DAYS.between(this.startDate, LocalDate.of(startDate.getYear(), 12, 31));
            period2 = ChronoUnit.DAYS.between(LocalDate.of(this.maturityDate.getYear(), 1, 1), this.maturityDate) + 1;

            daysInYear1 = this.startDate.isLeapYear() ? 366 : 365;

            daysInYear2 = this.maturityDate.isLeapYear() ? 366 : 365;


            this.interest = this.sum * (this.rate / 100.0) * (period1 / daysInYear1 + period2 / daysInYear2);
        }
    }
}
