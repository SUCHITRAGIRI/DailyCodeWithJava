//https://leetcode.com/problems/minimum-size-subarray-sum/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //Sliding window technique
        //using two pointers 
        
        int min = Integer.MAX_VALUE; // take max value 
        int sum = 0;
        int i = 0, j = 0; //two pointers 
        for(; i < nums.length; i++){ // keep moving i

            sum = nums[i] + sum;
            while(sum >= target){  // if found sum is greater than or equal to target then just stop moving the ith pointer and start moving j's pointer till get the min sum value;
                //The idea behind the logic is that{
            
//j pointer is use for left index value and i is for right
                //Time : O(N)
                //Space: O(1)
                //By dry run can get better understanding!
                min = Math.min(min, i - j + 1);
                sum = sum - nums[j];
                j++;
            }                                
        }        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

//Slightly change
class Solution {
    public int minSubArrayLen(int s, int[] A) {
        int j = 0, n = A.length, res = n + 1;
        for (int i = 0; i < n; ++i) {
            s -= A[i];
            while (s <= 0) {
                res = Math.min(res, i - j + 1);
                s += A[j++];
            }
        }
        return res % (n + 1);
    }
}
