package concurrency;

import java.util.List;

/**
 * Created by oper4 on 21.07.2014.
 */
public class FibonacciRunnable implements Runnable {

    private List<Integer> list;

    public FibonacciRunnable(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        fib(20);
    }

    private void fib(int len){
        list.add(0);
        list.add(1);
        for(int i = 1; i <= len; i++){
            list.add(list.get(i) + list.get(i-1));
        }
    }
}
