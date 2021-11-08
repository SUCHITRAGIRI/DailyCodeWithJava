//https://leetcode.com/problems/product-of-array-except-self/


//Time : O(N)
//soace : O(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int count = 0;
        //find the number of zeros
        for(int i = 0; i < nums.length; i++){ // O(n)
            if(nums[i] == 0)count++;
        }
        int[] res = new int[nums.length];
        
        if(count > 1)return res;
        
        else if(count == 1){
            int prodcut_except_zero = 1;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != 0)
                prodcut_except_zero *= nums[i]; 
            }
                   
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 0){
                res[i] = prodcut_except_zero;
                break;
                }
            }
                
        }
            
        else{
            int product = nums[0];
            for(int i = 1; i < nums.length; i++){ //O(n)
                product *= nums[i];
            }
            for(int i = 0; i < nums.length; i++){
                res[i] = product / nums[i];
            }
        }    
        
        return res;
    }
}

//More explanation
Given numbers [2, 3, 4, 5], regarding the third number 4, the product of array except 4 is 2*3*5 which consists of two parts: left 2*3 and right 5. The product is left*right. We can get lefts and rights:

Numbers:     2    3    4     5
Lefts:            2  2*3 2*3*4
Rights:  3*4*5  4*5    5      
Let’s fill the empty with 1:

Numbers:     2    3    4     5
Lefts:       1    2  2*3 2*3*4
Rights:  3*4*5  4*5    5     1
We can calculate lefts and rights in 2 loops. The time complexity is O(n).

We store lefts in result array. If we allocate a new array for rights. The space complexity is O(n). To make it O(1), we just need to store it in a variable which is right in @lycjava3’s code.

Clear code with comments:

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        // Calculate lefts and store in res.
        int left = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0)
                left = left * nums[i - 1];
            res[i] = left;
        }
        // Calculate rights and the product from the end of the array.
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1)
                right = right * nums[i + 1];
            res[i] *= right;
        }
        return res;
    }
}

//Insightful thinking process!
public class Solution {
public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    res[0] = 1;
    for (int i = 1; i < n; i++) {
        res[i] = res[i - 1] * nums[i - 1];
    }
    int right = 1;
    for (int i = n - 1; i >= 0; i--) {
        res[i] *= right;
        right *= nums[i];
    }
    return res;
}
}


