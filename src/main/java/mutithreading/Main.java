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
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        executorService.scheduleAtFixedRate(() -> {
            try {
                System.out.println(map.toString());
                System.out.println("Enter number:");
                map.put(new Scanner(System.in).nextLine().trim());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (NumberFormatException ignored) {
                System.out.println("Incorrect format");
            }
        }, 0, 1, TimeUnit.MILLISECONDS);

        executorService.scheduleAtFixedRate(() -> {
            try {
                System.out.println("Deleted value " + map.takeMin());
                System.out.println(map.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 5, 5, TimeUnit.SECONDS);
    }

}
