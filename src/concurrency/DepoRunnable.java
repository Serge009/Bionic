package concurrency;

import deposit.app9.DepoList;

/**
 * Created by oper4 on 21.07.2014.
 */
public class DepoRunnable implements Runnable {
    DepoList list;

    public DepoRunnable(DepoList list) {
        this.list = list;
    }

    @Override
    public void run() {
        double sum;
        for (int i = 0; i < list.size(); i++) {
            synchronized (list) {
                sum = list.getSum(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.setSum(i, sum + 100);
            }
        }
    }

    private void add100() {
        for (int i = 0; i < list.size(); i++) {
            list.add100(i);
        }
    }
}
