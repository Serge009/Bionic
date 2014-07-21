package concurrency;

/**
 * Created by oper4 on 18.07.2014.
 */
public class TestRunnable implements Runnable {
    @Override
    public void run() {
        try {
            for(int i = 0; i < 30; i++){
                System.out.println("TestRunnable = " + i);
                Thread.currentThread().sleep(1000);
            }

            System.out.println("TestRunnable is over!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}