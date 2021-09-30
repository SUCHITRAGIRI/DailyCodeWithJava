//https://leetcode.com/problems/jump-game-ii/


//We can solve this problem using Dp


//This is greedy Approch!
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0, currEnd = 0, nextEnd = 0;
        for(int i = 0; i < n - 1; i++){
            nextEnd = Math.max(i + nums[i], nextEnd);
            if(i == currEnd){
                currEnd = nextEnd;
                jumps++;
            }
        }
        return jumps;
    }
}
