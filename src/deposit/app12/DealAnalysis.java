package deposit.app12;

/**
 * Created by Matrix on 09.07.2014.
 */
public class DealAnalysis {
    Profitable deal;

    public DealAnalysis(Profitable deal) {
        this.deal = deal;
    }


    public int compareIncome(Profitable o) {
        if(o == null) return -1;

        double int1 = deal.getProfit();
        double int2 = o.getProfit();
        if(int1 == int2) return 0;
        if(int1 > int2) return 1;
        return -1;
    }
}
