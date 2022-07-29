import com.timgroup.statsd.NonBlockingStatsDClientBuilder;
import com.timgroup.statsd.StatsDClient;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        StatsDClient Statsd = new NonBlockingStatsDClientBuilder()
                .prefix("statsd")
                .hostname("localhost")
                .port(8125)
                .build();
        for (int i = 0; i < 10; i++) {
            Statsd.incrementCounter("example_metric.increment", new String[]{"environment:dev"});
            Statsd.decrementCounter("example_metric.decrement", new String[]{"environment:dev"});
            Statsd.count("example_metric.count", 2, new String[]{"environment:dev"});
            Thread.sleep(100000);
        }

    }

}
