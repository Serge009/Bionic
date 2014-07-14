package deposit.app11;

import java.util.ArrayList;

/**
 * Created by oper4 on 07.07.2014.
 */
public class PrintList<T> {
    private ArrayList<T> list = new ArrayList();

    public void add(T o){
        list.add(o);
    }

    public void printList(boolean odd){
        int m = (odd) ? 1 : 0;

        for(int i = m; i < list.size(); i += 2){
            System.out.println(list.get(i));
        }
    }
}
