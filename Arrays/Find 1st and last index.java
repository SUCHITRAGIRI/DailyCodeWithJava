//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

//time : O(logn)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        
   res[0] = startIndex(nums, target, 0, nums.length - 1);
   res[1] = endIndex(nums, target, 0, nums.length - 1);
        
        
        return res;
    }
    
    int startIndex(int[] nums, int key, int start, int end){
        int index = -1;
        while(start <= end){
        int mid = start + (end - start) / 2;
        if(nums[mid] == key){
            index = mid;
            end = mid - 1;
        }else if(nums[mid] < key){
            start = mid + 1;
        }else{
            end = mid - 1;
        }
        }
    
        return index;
    }
    
    int endIndex(int[] nums, int key, int start, int end){
        int index = -1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == key){
                index = mid;
                start = mid + 1;
            }else if(nums[mid] < key){
            start = mid + 1;
        }else{
            end = mid - 1;
        }
        }
    
        return index;
        }
    }
    
