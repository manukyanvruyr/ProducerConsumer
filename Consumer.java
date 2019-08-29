import java.util.concurrent.atomic.AtomicInteger;

class Consumer implements Runnable {
    private static AtomicInteger i = new AtomicInteger(0);

    private Buffer buffer;
    private int number;

    Consumer(Buffer buffer, int number) {
        this.buffer = buffer;
        this.number = number;
    }

    void consume() {
        while (i.getAndIncrement() < InputData.elementsCount) {
            System.out.println(number + " Consumed: " + buffer.pop());
        }
    }

    @Override
    public void run() {
        consume();
    }
}