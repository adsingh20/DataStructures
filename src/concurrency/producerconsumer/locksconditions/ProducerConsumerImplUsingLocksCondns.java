package concurrency.producerconsumer.locksconditions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerImplUsingLocksCondns {

    private int max;
    private Queue<String> queue;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public ProducerConsumerImplUsingLocksCondns(int size) {
        queue = new LinkedList<>();
        this.max = size;
    }

    public void produce(String value) throws InterruptedException {
        lock.lock();
        try {
            if (queue.size() == max) {
                notFull.wait();
            }
            queue.add(value);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void consume() throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == 0) {
                notEmpty.wait();
            }
            queue.remove();
            notFull.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
