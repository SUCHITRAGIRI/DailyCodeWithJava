//https://leetcode.com/problems/find-all-duplicates-in-an-array/

//Tc : O(n)
//Sc: O(1)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
     List<Integer> result=new ArrayList<>();
      for(int val:nums)
          {
          int index=Math.abs(val)-1;
          if(nums[index]<0)
              {
              result.add(index+1);
              }
          else{
              nums[index]=-nums[index];
              }
          
          }
        
        return result;
    }
}
