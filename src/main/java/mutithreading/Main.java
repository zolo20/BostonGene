package mutithreading;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SynchronyzedTreeMap map = new SynchronyzedTreeMap();
        map.put("one thousand ninety nine");
        map.put("nine thousand nine hundred ninety nine");
        ScheduledExecutorService executorService1 = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService executorService2 = Executors.newSingleThreadScheduledExecutor();

        executorService1.scheduleAtFixedRate(() -> {
            try {
                System.out.println("Enter number:");
                map.put(new Scanner(System.in).nextLine().trim());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (NumberFormatException ignored) {
                System.out.println("Incorrect format");
            }
        }, 0, 1, TimeUnit.MILLISECONDS);

        executorService2.scheduleAtFixedRate(() -> {
            try {
                System.out.println(map.takeMin());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 5, 5, TimeUnit.SECONDS);
    }

}
