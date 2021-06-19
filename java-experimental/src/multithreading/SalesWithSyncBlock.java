package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SalesWithSyncBlock {
    private volatile int totalSales = 0;

    public int addSale(int saleAmount) {
        synchronized (this) {
            try {
                TimeUnit.MICROSECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            totalSales = totalSales + saleAmount;
            return totalSales;
        }
    }

    public int getTotalSales() {
        return totalSales;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        SalesWithSyncBlock sales = new SalesWithSyncBlock();
        final List<Callable<Integer>> salesCallables = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            salesCallables.add(() -> sales.addSale(1));
        }
        final List<Future<Integer>> listPromises = executorService.invokeAll(salesCallables);

        assert 1000 == listPromises.size();
        assert 1000 == sales.getTotalSales();
    }
}
