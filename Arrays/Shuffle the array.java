// Time : O(n)
// space : O(2n)
class Solution {
    public int[] shuffle(int[] nums, int n) {
        //using extra array sc : O(N)
        
        int[] res = new int[nums.length];
        int i = 0, j = n, k = 0;
        while(i < n && j < nums.length){
            res[k++] = nums[i++];
            res[k++] = nums[j++];
        }
        
        return res;
    }
}

//Can you do with O(1) space, means in place ???
