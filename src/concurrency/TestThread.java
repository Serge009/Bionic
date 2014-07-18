package concurrency;

/**
 * Created by oper4 on 18.07.2014.
 */
public class TestThread extends Thread {

    @Override
    public void run() {
        try {
            Thread thread = new Thread(new TestRunnable());
            thread.start();

            for (int i = 0; i < 30; i++) {
                System.out.println("TestThread = " + i);
                Thread.currentThread().sleep(500);
            }

            thread.join();

            System.out.println("TestThread is over!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
