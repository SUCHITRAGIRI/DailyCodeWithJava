//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/


class Solution {
    public int maxProfit(int[] prices, int fee) {
//         int cash = 0, hold = -prices[0];
//         //[1,3,2,8,4,9]
//         for(int i = 1; i < prices.length; i++){
//             hold = Math.max(hold, cash - prices[i]);
//             cash = Math.max(cash, hold + prices[i] - fee);
//         }
        
//         return cash;
//     }
        
        int obsp = -prices[0]; //old buy state profit
        int ossp = 0; //old sell state profit
        
        for(int i = 1; i < prices.length; i++){
            int nbsp = 0; //new buy state profit
            int nssp = 0; //new sell state profit
            
            if(ossp - prices[i] > obsp){
                nbsp = ossp - prices[i];
            }else{
                nbsp = obsp;
            }
            
            if(obsp + prices[i] - fee > ossp){
                nssp = obsp + prices[i] - fee;
            }else{
                nssp = ossp;
            }
            
            ossp = nssp;
            obsp = nbsp;
        }
        
        return ossp;
}
}
