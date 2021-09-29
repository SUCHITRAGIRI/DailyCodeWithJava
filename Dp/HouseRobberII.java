//https://leetcode.com/problems/house-robber-ii/
public class Solution {
public int rob(int[] nums) {
    if(nums.length == 1)return nums[0];
	return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
}

public int rob(int[] nums, int lo, int hi) {
    int preRob = 0, preNotRob = 0, rob = 0, notRob = 0;
    for (int i = lo; i <= hi; i++) {
      	rob = preNotRob + nums[i];
    	notRob = Math.max(preRob, preNotRob);
    	
    	preNotRob = notRob;
    	preRob = rob;
    }
    return Math.max(rob, notRob);
}
}

//

class Solution {
    
        public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    
    public int rob(int[] nums, int start, int end) 
    {
        int prev1 = 0;
        int prev2 = 0;
        int curr = 0;
        for (int i = start; i <= end; i++)
        {
            curr = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
        
    
}
