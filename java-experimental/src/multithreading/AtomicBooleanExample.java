package multithreading;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanExample {
    public static void main(String[] args) {
        AtomicBooleanExample example = new AtomicBooleanExample();
        System.out.println( "does the data has been written ==> "+ example.writeSomeData());
        System.out.println( "does the data has been written ==> "+ example.writeSomeData());
       // System.out.println(example.writeSomeData());
    }
    //return true if data was written
    public boolean writeSomeData() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        new Thread(() -> {
            System.out.println("I have written " + Thread.currentThread().getName());
            atomicBoolean.set(true);
        }).start();

        return atomicBoolean.compareAndSet(true, false);

      //  return atomicBoolean.get() != true;
    }
}
