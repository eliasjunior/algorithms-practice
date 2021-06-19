package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SalesService {

    // It seems Atomic variable scales better then locking, for instance public syncronyzed void increment(), but depends on the scenario, there are always trade-offs
    // --> Java concurrency book,  In practice, atomics tend to scale better than locks because atomics deal more effectively with typical contention levels.
    private AtomicInteger totalSales = new AtomicInteger();

    /**
     * Adds a integer amount to the total sales, and returns the total sales
     *
     * @param saleAmount The integer amount to add to the total sales
     *
     * @return The total sales amount so far
     */
    public int addSale(int saleAmount) {
        try {
            TimeUnit.MICROSECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return incrementSaleAndReturnTotal(saleAmount);
    }

    public int getTotalSales() {
        return totalSales.get();
    }

    // it could be from disk, network, etc
    private int incrementSaleAndReturnTotal(int saleAmount) {
        return totalSales.updateAndGet( sum -> sum + saleAmount);
    }

    public static void main(String[] args) throws InterruptedException {
        // Heavy, long-running use, a fixed number of threads is constantly maintained regardless of workload
        // Threads will kept active until they are explicitly shutdown, see Executors.newCachedThreadPool for light-weight asynchronous task
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        SalesService salesService = new SalesService();
        final List<Callable<Integer>> salesCallables = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            salesCallables.add(() -> salesService.addSale(1));
        }
        final List<Future<Integer>> sales = executorService.invokeAll(salesCallables);

        assert 1000 == sales.size();
        assert 1000 == salesService.getTotalSales();
    }
}
