//https://leetcode.com/problems/xor-operation-in-an-array/


class Solution {
    public int xorOperation(int n, int start) {
       int num = 0;
        // Time: O(n), here n is the num of elements to be xor!
        //space: O(1)
        for(int i = 0; i < n; i++){
            num ^= start + 2 * i;
        }
        
       return num; 
    }
}
