//https://leetcode.com/problems/number-of-good-pairs/

class Solution {
    public int numIdenticalPairs(int[] nums) {
        //brute force 
        // time : O(n^2)
        // space : O(1)
        int count = 0;
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j])count++;
            }
        }
        return count;
    }
}

//Another one:

class Solution {
    //time : O(N)
    //soace : O(N)
    public int numIdenticalPairs(int[] A) {
        int res = 0, count[] = new int[101];
        for (int a: A) {
            res += count[a]++;
        }
        return res;
    }
}
