package test3.deposit;

import java.time.LocalDate;

/**
 * Created by oper4 on 25.07.2014.
 */
abstract public class AbstractDeposit implements Comparable<AbstractDeposit> {
    protected int id;
    protected String bankName;
    protected String depositId;
    protected int type;
    protected LocalDate startDate;
    protected int duration;
    protected double sum;
    protected double rate;
    protected double interest;
    protected LocalDate maturityDate;

    public AbstractDeposit() {
    }

    public AbstractDeposit(int id, String bankName, String depositId, int type, LocalDate startDate, int duration, double sum, double rate) {
        this.id = id;
        this.bankName = bankName;
        this.depositId = depositId;
        this.type = type;
        this.startDate = startDate;
        this.duration = duration;
        this.sum = sum;
        this.rate = rate;
        setMaturityDate();
    }

    @Override
    public String toString() {
        return "AbstractDeposit{" +
                "id=" + id +
                ", bankName='" + bankName + '\'' +
                ", depositId='" + depositId + '\'' +
                ", type=" + type +
                ", startDate=" + startDate +
                ", duration=" + duration +
                ", sum=" + sum +
                ", rate=" + rate +
                ", interest=" + interest +
                ", maturityDate=" + maturityDate +
                '}';
    }

    @Override
    public int compareTo(AbstractDeposit o) {
        if(this.interest > o.interest) return 1;
        return (this.interest < o.interest) ? -1 : 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getDepositId() {
        return depositId;
    }

    public void setDepositId(String depositId) {
        this.depositId = depositId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setStartDate(java.sql.Date startDate) {
        this.startDate = startDate.toLocalDate();
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;

    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getInterest() {
        return interest;
    }

    abstract public void calculateInterest();


    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate() {
        this.maturityDate = startDate.plusDays(duration);
    }
}
