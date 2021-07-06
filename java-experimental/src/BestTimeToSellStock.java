public class BestTimeToSellStock {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        //7 1 5 3 6 4
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if(minPrice > price) {
                minPrice = price;
            }
            int currentProfit =  price - minPrice;
            maxProfit = Math.max(maxProfit, currentProfit);
        }

        return maxProfit;
    }


    public static void main(String[] args) {
        System.out.println(new BestTimeToSellStock().maxProfit(new int[]{2, 1, 2, 0 }));
    }









    // brute force
//    public int maxProfit(int[] prices) {
//        return helper(prices, 0);
//    }
//
//    public int helper(int [] prices, int nextIndex) {
//        if(nextIndex >= prices.length - 1) {
//            return 0;
//        }
//        int max = 0;
//
//        for (int i = nextIndex; i < prices.length; i++) {
//            int buy = prices[i];
//            int currentMax = 0;
//            for (int j = i + 1; j < prices.length; j++) {
//                int pSell = prices[j];
//
//                if(buy < pSell) {
//                    currentMax = helper(prices, j + 1) + pSell - buy;
//                    max = Math.max(currentMax, max);
//                }
//
//            }
//
//        }
//        return max;
//    }
}
