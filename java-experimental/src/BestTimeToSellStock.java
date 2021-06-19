public class BestTimeToSellStock {
    // brute force
    public int maxProfit(int[] prices) {
        return helper(prices, 0);
    }

    public int helper(int [] prices, int nextIndex) {
        if(nextIndex >= prices.length - 1) {
            return 0;
        }
        int max = 0;

        for (int i = nextIndex; i < prices.length; i++) {
            int buy = prices[i];
            int currentMax = 0;
            for (int j = i + 1; j < prices.length; j++) {
                int pSell = prices[j];

                if(buy < pSell) {
                    currentMax = helper(prices, j + 1) + pSell - buy;
                    max = Math.max(currentMax, max);
                }

            }

        }
        return max;
    }
}
