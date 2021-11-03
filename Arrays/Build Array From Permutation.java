//https://leetcode.com/problems/build-array-from-permutation/

//Time : O(N)
//space : O(N)

class Solution {
    public int[] buildArray(int[] nums) {
        //using extra space
        int n = nums.length;
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = nums[nums[i]];
        }
        
        return arr;
    }
}

//can do without space, means in place?
