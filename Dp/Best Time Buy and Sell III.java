//This proble is one of the buy and selling problem 
//The group of this problem is :
//Best time to buy and sell I
//Best time to buy and sell II
//Best time to buy and sell III
//Best time to buy and sell IV
//Best time to buy and sell with cool down
//Best time to buy and sell with transaction fee

//Leetcode hard Dp problem
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/


//Logic of this problem is :
//Find left to right max profit up that day when you sell the stock

//Find right to left max profit till that day when you buy the stock

//then some the both points and find the max of them!


class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dpL[] = new int[n];
        
        int mpfst = 0; //max profit of sold today
        int leastsf = prices[0]; //min least so far (where we buy the stock for max profit)
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < leastsf){
                leastsf = prices[i]; //maintain the least so far
            }
            
            mpfst = prices[i] - leastsf;
            if(mpfst > dpL[i - 1]){ //this is just bcoz we want max profit sold up to day not just today
                //https://www.youtube.com/watch?v=wuzTpONbd-0 
                //this video can help
                dpL[i] = mpfst;
            }else{
                dpL[i] = dpL[i - 1];
            }
        }
        
        int[] dpR = new int[n];
        int mpfbt = 0; //max profit of buy today
        int maxsf = prices[n - 1];
        for(int i = n - 2; i >= 0; i--){
            
            if(maxsf < prices[i]){
                maxsf = prices[i];
            }
            
            mpfbt = maxsf - prices[i];
            if(dpR[i + 1] < mpfbt){
                dpR[i] = mpfbt;
            }else{
                dpR[i] = dpR[i + 1];
            }
        }
        
        int res = 0;
        for(int i = 0; i < prices.length; i++){
            res = Math.max(res, dpL[i] + dpR[i]);
        }
        
        return res;
    }
}
