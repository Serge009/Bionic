package app12;

/**
 * Created by Matrix on 09.07.2014.
 */
public class TBill implements Profitable {
    private double nominal;
    private double price;
    private int amount;
    private double income;

    public TBill() {
    }

    public TBill(double nominal, double price, int amount) {
        this.nominal = nominal;
        this.price = price;
        this.amount = amount;
        this.income = (this.nominal - this.price) * this.amount;
    }

    @Override
    public double getProfit() {
        return income;
    }

    public double getIncome(){
        if(income == 0) {
            this.income = (this.nominal - this.price) * this.amount;
        }
        return this.income;
    }
}
