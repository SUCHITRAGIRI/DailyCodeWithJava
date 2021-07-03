//https://leetcode.com/problems/two-sum/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        
        
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(target - nums[i])){
                map.put(nums[i], i);                
            }else{
                ans[0] = i;
                ans[1] = map.get(target - nums[i]);
                break;
            }
        }
             
        return ans;
    }
}
