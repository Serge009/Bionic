package concurrency;

import java.util.List;

/**
 * Created by oper4 on 21.07.2014.
 */
public class FibonacciRunnable implements Runnable {

    private Fibonacci fibonacci;

    public FibonacciRunnable(Fibonacci fibonacci) {
        this.fibonacci = fibonacci;
    }

    @Override
    public void run() {
        fib(20);
    }

    private void fib(int len){
        fibonacci.add(0);
        fibonacci.add(1);
        for(int i = 1; i <= len; i++){
            fibonacci.add(fibonacci.get(i) + fibonacci.get(i-1));
        }
    }
}
