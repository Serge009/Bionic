import app12.Profitable;
import app12.TBill;
import app9.BarrierDepo;
import app9.Deposit;
import app9.SimpleDepo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by SERGE on 30.06.2014.
 */
public class Main {
    public static void main(String[] args) {

        ArrayList<Profitable> list = new ArrayList<>();

        list.add(new SimpleDepo(1000, 20, 15, LocalDate.of(2013, 9, 8)));
        list.add(new BarrierDepo(1000, 30, 15, LocalDate.of(2013, 9, 8)));
        list.add(new Deposit(1000, 180, 15, LocalDate.of(2014, 5, 12)));
        list.add(new TBill(1000, 980, 10));

        for(Profitable p : list){
            System.out.println(p.getProfit());
        }


    }
}
