import java.text.MessageFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Synchronization {
    private static int t=0;
    private static Object mutex = new Object();
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(4);
        for (int i = 0; i < 1000000; i++) {
                executorService.execute(()->{
                    synchronized(mutex){
                        t++;
                        System.out.println(MessageFormat.format("t: {0}", t));
                    }

                });
        }
        executorService.shutdown();

    }
}