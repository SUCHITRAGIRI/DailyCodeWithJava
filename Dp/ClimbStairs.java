//https://leetcode.com/problems/climbing-stairs/
//Top Down Approach!
class Solution {
    public int climbStairs(int n) {
        if(n == 1)return 1;
        if(n == 2)return 2;
        int[] dp = new int[n + 1];
        
        return helper(n, dp);
    }
    
    public int helper(int n, int[] dp){
        if(n == 1)return 1;
        if(n == 2)return 2;
        
        if(dp[n] != 0)return dp[n];
        
        return dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
    }
}

//Bottom Up Approach!
class Solution {
    public int climbStairs(int n) {
        if(n == 1)return 1;
        if(n == 2)return 2;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }    
}


//
class Solution {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        int first = 1;
        int second = 2;
        for(int i = 3; i <= n; i++){
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
