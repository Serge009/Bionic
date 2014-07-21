package concurrency;

/**
 * Created by oper4 on 18.07.2014.
 */
public class TestRunnable implements Runnable {

    Fibonacci fib;
    Thread t2;

    public TestRunnable(Fibonacci fib, Thread t) {
        this.fib = fib;
        this.t2 = t;
    }

    @Override
    public void run() {
        try {
            t2.join();
            for(int i = 0; i < fib.size(); i++){
                System.out.println(fib.get(i));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}