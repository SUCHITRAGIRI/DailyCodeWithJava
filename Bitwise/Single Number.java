//https://leetcode.com/problems/single-number/


//Sort the array then check! TC: O(nlogn)
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i=1;
        while(nums.length>i){
           /*if(nums[i-1]==nums[i]){
              i=i+2;
           }*/
            if(nums[i-1]!=nums[i]){
                return nums[i-1];
            }
               i=i+2;
        
        }
       return nums[nums.length-1];
        
    }
}

//Using Bit wise operator: TC- O(n)
class Solution {
    public int singleNumber(int[] nums) {
        //using XOR operator
        int uniqueNo = 0;   // as we know about XOR operator
        // if XOR with same num gives 0 ===> n ^ n = 0 
        // and XOR with 0 gives the num itself ===> n ^ 0 = n
        for(int i = 0; i < nums.length; i++){
            uniqueNo ^= nums[i];  //so, here twise nos are cancelled and only left with the unique no, when we perform XOR with total ele in an array
        }
        
        return  uniqueNo;
    }
}
