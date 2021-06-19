package multithreading;

public class ProducerConsumer {
    private static Object lock = new Object();
    private static int[] buffer;
    private static int count;

    static class Producer {
        void produce() {
            synchronized (lock){
                if(isFull(buffer)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                buffer[count++] = 1;
                lock.notify();
            }
        }
    }
    static class Consumer {
        void consume() {
            synchronized (lock){
                if(isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                buffer[--count] = 0;
                lock.notify();
            }
        }
    }
    static boolean isFull(int[] buffer) {
        return buffer.length == count;
    }
    static boolean isEmpty() {
        return count == 0;
    }

    public static void main(String[] args) throws InterruptedException {
        buffer = new int[10];
        count = 0;

        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        Runnable produceTask = () -> {
            for (int i = 0; i < 50; i++) {
                producer.produce();
            }
            System.out.println("Done producing");
        };
        Runnable consumeTask = () -> {
            for (int i = 0; i < 45; i++) {
                consumer.consume();
            }
            System.out.println("Done Consuming");
        };

        Thread consumerThread = new Thread(consumeTask);
        Thread producerThread = new Thread(produceTask);

        //start threads
        consumerThread.start();
        producerThread.start();

        // wait to complete.
        consumerThread.join();
        producerThread.join();

        System.out.println("Data in the buffer " + count);
    }
}
