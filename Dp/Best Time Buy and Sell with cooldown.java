//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/


//Using state machine approch Tc - O(n) SC- O(n)
class Solution {
    public int maxProfit(int[] prices) {
        int[] noStock = new int[prices.length];
        int[] inHand = new int[prices.length];
        int[] sold = new int[prices.length];
        inHand[0] = -prices[0];
        sold[0] = Integer.MIN_VALUE;
        for(int i = 1; i < prices.length; i++){
            noStock[i] = Math.max(noStock[i - 1], sold[i - 1]);
            inHand[i] = Math.max(inHand[i - 1], noStock[i - 1] - prices[i]); //Buying the stock
            sold[i] = inHand[i - 1] + prices[i]; //selling the stock
        }
        return Math.max(noStock[prices.length - 1], sold[prices.length - 1]);
    }
}


//Bit improvised  Tc- O(N) , SC - O(1)
class Solution {
int maxProfit(int[] prices) {
    int sold = 0, hold = Integer.MIN_VALUE, rest = 0;
    for (int i = 0; i < prices.length; ++i)
    {
        int prvSold = sold;
        sold = hold + prices[i];
        hold = Math.max(hold, rest-prices[i]);
        rest = Math.max(rest, prvSold);
    }
    return Math.max(sold, rest);
}
}


