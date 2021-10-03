
//https://leetcode.com/problems/maximum-product-subarray/submissions/
class Solution {
    public int maxProduct(int[] nums) {
        //Brut force approach of this problem is :
        //find all possible subarray and betw them find the max product subarry
        //that approch will take tc O(n^2)
        
        
        //This is a optimal approch to solve this problem with tc O(n) and sc O(1)
        
        //Logic of this problem is that : we have two possibilities either maxProduct subarray lie on left to right or right to left.
        //for brtter understanding the approch follow this : https://www.youtube.com/watch?v=jzQ-f2uU0UU
        int currProduct = 1;
        int maxAns = Integer.MIN_VALUE;
        //left to right subarry
        for(int i = 0; i < nums.length; i++){
            currProduct *= nums[i];
            maxAns = Math.max(maxAns, currProduct);
            if(currProduct == 0)currProduct = 1;
        }
        currProduct = 1;
        //right to left subarry
        for(int i = nums.length - 1; i >= 0; i--){
            currProduct *= nums[i];
            maxAns = Math.max(maxAns, currProduct);
            if(currProduct == 0)currProduct = 1;
        }
        
        return maxAns;
    }
}
