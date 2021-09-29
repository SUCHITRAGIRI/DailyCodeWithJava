//https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.

//My first approach and I am very glad to see it works:)
//Really makes me Happy
//Top Down
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)return nums[0];
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return Math.max(helper(nums, n - 1, dp), helper(nums, n - 2, dp));
    }
    
    public int helper(int[] nums, int n, int[] dp){
        if(n < 0)return 0;
        if(n == 0 || n == 1)return nums[n];
        if(dp[n] != -1)return dp[n];
        return dp[n] = nums[n] + Math.max(helper(nums, n - 2, dp), helper(nums, n - 3, dp));
        
    }
}

//Bottom Up
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)return nums[0];
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 1; i < n; i++){
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        return dp[n];
    }
    
}
