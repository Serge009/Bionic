package concurrency;

/**
 * Created by oper4 on 18.07.2014.
 */
public class TestThread implements Runnable {

    private Thread thread;

    @Override
    public void run() {
        try {

            for (int i = 0; i < 30; i++) {
                System.out.println("TestThread = " + i);
                Thread.currentThread().sleep(500);
            }

            if(thread != null)
                thread.join();

            System.out.println("TestThread is over!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void setThread(Thread thread) {
        this.thread = thread;
    }
}
