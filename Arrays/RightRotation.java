//Using extra space and O(n) time complexity!
class Solution {
    public void rotate(int[] nums, int k) {
        //using extra space
        //right rotation by k steps
        int n = nums.length;
        k = k % n;
        if(k == 0)return;
        int pos = n - k;
        int[] res = new int[n];
        int j = 0;
        for(int i = pos; i < n; i++){
            res[j++] = nums[i];
        }
        
        for(int i = 0; i < pos; i++){
            res[j++] = nums[i];
        }
        
      for(int i = 0; i < n; i++){
          nums[i] = res[i];
      }
    }
}

//In place solution with time complexity O(n)

class Solution {
    public void rotate(int[] nums, int k) {
        //without extra space
        //right rotation by k steps
        int n = nums.length;
        k = k % n;
        if(k == 0)return;
        int pos = n - k;
        //pos to n
        reverse(nums, pos, n);
        reverse(nums, 0, pos);
        reverse(nums, 0, n);
    }
    
    public void reverse(int[] arr, int start, int end){
        //two pointer approach
        int i = start, j = end - 1;
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}

//bit tweek
class Solution {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        
        
    }
    public void reverse(int[] nums,int start,int end){
      while(start<end){
       int temp=nums[start];
          nums[start]=nums[end];
          nums[end]=temp;
          start++;
          end--;
          }
      
      
    }
}
