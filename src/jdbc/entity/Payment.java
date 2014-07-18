package jdbc.entity;

/**
 * Created by Matrix on 17.07.2014.
 */
public class Payment {
    private int id;
    private long dt;
    private Merchant merchant;
    private Customer customer;
    private String goods;
    private double total;
    private double charge;

    public Payment() {
    }

    public Payment(int id, long dt, Merchant merchant, Customer customer, String goods, double total, double charge) {
        this.id = id;
        this.dt = dt;
        this.merchant = merchant;
        this.customer = customer;
        this.goods = goods;
        this.total = total;
        this.charge = charge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }
}
