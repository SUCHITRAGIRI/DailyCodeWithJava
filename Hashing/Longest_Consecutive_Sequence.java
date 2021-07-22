//https://leetcode.com/problems/longest-consecutive-sequence/
//TC: O(NlogN)

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)return 0;
        Arrays.sort(nums);
        int count = 1;
        int max = 1;
        for(int i = 0; i < nums.length - 1; i++){
           if(nums[i + 1] - nums[i] == 1){
               count++;
           }
           else if(nums[i + 1] - nums[i] == 0){
               continue;
           }
           else if(nums[i + 1] - nums[i] > 0){
               max = Math.max(max, count);
               count = 1;
           } 
        }
    
        return Math.max(max, count);
    }
}
