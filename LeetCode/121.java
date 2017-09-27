class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int result = 0;
        int minx = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (minx > prices[i]) {
                minx = prices[i];
            } else {
                int tmp = prices[i] - minx;
                result = result < tmp ? tmp : result;
            }
        }
        return result;
    }
}