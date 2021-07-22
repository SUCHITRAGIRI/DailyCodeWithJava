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

//TC: O(N)
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
