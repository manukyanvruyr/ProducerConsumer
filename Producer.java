import java.util.concurrent.atomic.AtomicInteger;

class Producer implements Runnable {
    private static AtomicInteger i = new AtomicInteger(0);

    private Buffer queue;
    private int number;

    Producer(Buffer queue, int number) {
        this.queue = queue;
        this.number = number;
    }

    void produce() {
        while (i.get() < InputData.elementsCount) {
            queue.push(i.getAndIncrement());
            // The output can be incorrect as this method is not thread safe.
            System.out.println(number + " Produced: " + (i.get() - 1));
        }
    }

    @Override
    public void run() {
        produce();
    }
}
