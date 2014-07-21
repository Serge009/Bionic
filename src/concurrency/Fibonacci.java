package concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oper4 on 21.07.2014.
 */
public class Fibonacci {
    private List<Integer> list = new ArrayList<>();

    public Integer get(int index){
        return list.get(index);
    }

    public synchronized void add(Integer i){
        list.add(i);
    }

    public int size(){
        return list.size();
    }
}
