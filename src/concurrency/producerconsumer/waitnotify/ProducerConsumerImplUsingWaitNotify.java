package concurrency.producerconsumer.waitnotify;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerImplUsingWaitNotify {

    private int max;
    private Queue<String> queue = new LinkedList<>();
    private Object notEmpty = new Object();
    private Object notFull = new Object();

    public ProducerConsumerImplUsingWaitNotify(int size) {
        queue = new LinkedList<>();
        this.max = size;
    }

    public synchronized void produce(String value) throws InterruptedException {
        if (queue.size() == max) {
            notFull.wait();
        }
        queue.add(value);
        notEmpty.notifyAll();
    }

    public synchronized void consume() throws InterruptedException {
        while (queue.size() == 0) {
            notEmpty.wait();
        }
        queue.remove();
        notFull.notifyAll();
    }
}
