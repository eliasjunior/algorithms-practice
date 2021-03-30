import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;
import java.lang.Math;

public class PercolationStats {
    private Percolation percolation;
    private int trials;
    private double[] meanResults;
    private final double PERC = 1.96;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        this.trials = trials;
        meanResults = new double[trials];
        int randomI, randomJ;

        for (int i = 0; i < trials; i++) {
            int numberOpenSites = 0;
            percolation = new Percolation(n);
            while (!percolation.percolates()) {
                randomI = StdRandom.uniform(1, n + 1);
                randomJ = StdRandom.uniform(1, n + 1);

                if (!percolation.isOpen(randomI, randomJ)) {
                    percolation.open(randomI, randomJ);
                    numberOpenSites++;
                }
            }
            double res =   (double) numberOpenSites / (double)(n * n);
            //StdOut.println("Trial="+i + " Open Sites "+ numberOpenSites);
            meanResults[i] = res;
        }
    }

    // sample mean of percolation threshold
    //The sample mean x⎯⎯⎯ provides an estimate of the percolation threshold;
   // So to calculate the mean, you have T values for the percolation threshold (that is something like in the example above the formula, where it is 0.51).
    // You add all up and divide by T and get the mean of the percolation threshold.
    // So it can very likely be 0.5929934999999997 as in the example, depending on the outcome of your T trials.
    public double mean() {
        return StdStats.mean(meanResults);
    }

    // sample standard deviation of percolation threshold
    //the sample standard deviation s; measures the sharpness of the threshold.
    public double stddev() {
        return StdStats.stddev(meanResults);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - (PERC / Math.sqrt(this.trials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + (PERC / Math.sqrt(this.trials));
    }

    // test client (see below)
    public static void main(String[] args) {
        //StdOut.println("=== Percolation Starting === for n=" + args[0] + ", trials="+args[1]);

        if (args[0] == null || args[1] == null) {
            throw new IllegalArgumentException();
        }

        //and prints the sample mean, sample standard deviation, and the 95% confidence interval for the percolation threshold.

        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        Stopwatch stopwatch = new Stopwatch();

        PercolationStats percolationStats = new PercolationStats(n, trials);

       // StdOut.println("Time " + stopwatch.elapsedTime());

        StdOut.println("mean                    = " + percolationStats.mean());
        StdOut.println("stddev                  = " + percolationStats.stddev());

        StdOut.println("95% confidence interval = [" + percolationStats.confidenceLo() +", "+ percolationStats.confidenceHi() +"]");
    }
}
