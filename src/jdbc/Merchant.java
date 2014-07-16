package jdbc;

/**
 * Created by oper4 on 16.07.2014.
 */
public class Merchant {
    private int id;
    private String name;
    private double charge;
    private int period;
    private double minSum;
    private String bankName;
    private String swift;
    private String account;
    private double total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double getMinSum() {
        return minSum;
    }

    public void setMinSum(double minSum) {
        this.minSum = minSum;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", charge=" + charge +
                ", period=" + period +
                ", minSum=" + minSum +
                ", bankName='" + bankName + '\'' +
                ", swift='" + swift + '\'' +
                ", account='" + account + '\'' +
                ", total=" + total +
                '}';
    }
}
