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
