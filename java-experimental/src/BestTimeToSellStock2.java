public class BestTimeToSellStock2 {

    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToSellStock2().maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
        System.out.println(new BestTimeToSellStock2().maxProfit(new int[] { 1, 2, 3, 4, 5 }));
        System.out.println(new BestTimeToSellStock2().maxProfit(new int[] { 7, 6, 4, 3, 1 }));
    }

}
