import java.util.LinkedList;
import java.util.Queue;

class Buffer<T> {
    private int maxCount;
    private Queue<T> queue = new LinkedList<>();

    Buffer(int maxCount) {
        this.maxCount = maxCount;
    }

    synchronized void push(T value) {
        while (queue.size() >= maxCount) {
            safeWait();
        }
        queue.add(value);
        notify();
    }

    synchronized T pop() {
        while (queue.isEmpty()) {
            safeWait();
        }
        final T value = queue.poll();
        notify();
        return value;
    }

    private void safeWait() {
        try {
            wait();
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }
}
