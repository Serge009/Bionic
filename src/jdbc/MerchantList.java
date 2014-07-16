package jdbc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oper4 on 16.07.2014.
 */
public class MerchantList {
   private List<Merchant> list = new ArrayList<>();

   public void add(Merchant merchant){
       list.add(merchant);
   }

    @Override
    public String toString() {
        return "MerchantList{" +
                "list=" + list +
                '}';
    }
}
