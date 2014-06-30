package app8;

import java.time.LocalDate;

public abstract class DepoBase {

    protected double interest;

    protected double sum;

    protected int days;

    protected double interestRate;

    protected LocalDate startDate;

    protected LocalDate maturityDate;

    public DepoBase(double sum, int days, double interestRate, LocalDate startDate) {
        this.sum = sum;
        this.days = days;
        this.interestRate = interestRate;
        this.startDate = startDate;
        this.calculateInterest();
    }

    public abstract void calculateInterest();

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

}
