import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main(String[] args) throws InterruptedException {
        InputData.input();

        Buffer<Integer> buffer = new Buffer<>(InputData.bufferMaxCount);
        List<Thread> producers = new ArrayList<>();
        for (int i = 0; i < InputData.producersCount; ++i) {
            producers.add(new Thread(new Producer(buffer, i)));
        }

        List<Thread> consumers = new ArrayList<>();
        for (int i = 0; i < InputData.consumersCount; ++i) {
            consumers.add(new Thread(new Consumer(buffer, i)));
        }

        producers.forEach(Thread::start);
        consumers.forEach(Thread::start);

        for (Thread thread : producers) {
            thread.join();
        }

        for (Thread thread : consumers) {
            thread.join();
        }

    }
}
