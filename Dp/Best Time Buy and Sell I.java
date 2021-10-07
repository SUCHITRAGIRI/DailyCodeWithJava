//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/


class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minVal = Integer.MAX_VALUE;
    for(int i = 0; i < prices.length; i++){
            if(prices[i] < minVal)
            minVal = prices[i];
        
        else if(maxProfit < prices[i] - minVal){
            maxProfit = prices[i] - minVal;
        }
            
    }
        return maxProfit;
    }
}
