package mutithreading;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SynchronyzedTreeMap {
    private final Object monitor = new Object();
    private boolean state;
    private final Map<Integer, String> numbers = new TreeMap<>();

    public String put(String value) throws InterruptedException {
        synchronized (monitor) {
            while (state) monitor.wait();
            numbers.put(Converter.converterFromStringsToNumbers(value), value);
            monitor.notifyAll();
        }
        return value;
    }

    public String takeMin() throws InterruptedException {
        String value;
        synchronized (monitor) {
            while (!state && numbers.size() == 0) monitor.wait();
            state = false;
            value = numbers.remove(numbers.entrySet().stream().findFirst().get().getKey());
            monitor.notifyAll();
        }
        return value;
    }

    @Override
    public String toString() {
        return numbers.entrySet().toString();
    }
}
