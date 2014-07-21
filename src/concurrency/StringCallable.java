package concurrency;

import java.util.concurrent.Callable;

/**
 * Created by oper4 on 21.07.2014.
 */
public class StringCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        return "result";
    }
}
