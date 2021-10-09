//https://leetcode.com/problems/remove-duplicates-from-sorted-array/


//Tc : O(n)
//Sc: O(1)
class Solution {
    public int removeDuplicates(int[] nums) 
    {
        int len=nums.length;
        int j=0;
        if(len<=1)
            {
            return len;
        }
        for(int i=0;i<len-1;i++)
            {
            if(nums[i]!=nums[i+1])
                {
                nums[j++]=nums[i];
            }
            }
        nums[j++]=nums[len-1];
        return j;
        
    }
}
