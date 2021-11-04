// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

//Time : O(N^2)
// execution time: 12ms
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
       //time : O(N^2)
        int count = 0;
        int n = nums.length;
        int[] res = new int[n];
        
        for(int i = 0; i < n; i++){
            count = 0;
            for(int j = 0; j < n; j++){              
                if(nums[i] > nums[j] && i != j)count++;
            }            
            res[i] = count;
        }        
        return res;
    }
}


//execution time : 3ms
// Optimizex it N^2 to NlogN
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
       //total time : O(nlogn + nlogn + n) = O(nlogn)
        int count = 0;
        int n = nums.length;
        int[] res = new int[n]; 
        
        int[] temp = Arrays.copyOf(nums, n); //O(n)
 
        Arrays.sort(temp); //O(nlogn)
        
        for(int i = 0; i < n; i++){ // n + 1
            res[i] = binarySearch(temp, 0, n - 1, nums[i], 0); // n * logn
        }
        
        return res;
    }
    
    int binarySearch(int[] arr, int start, int end, int key, int index){
        if(start > end)return index;
        int mid = start + (end - start) / 2;
        if(arr[mid] == key){
            index = mid;
            return binarySearch(arr, start, mid - 1, key, index);
        }else if(arr[mid] < key){
             return binarySearch(arr, mid + 1, end, key, index);
        }else{
             return binarySearch(arr, start, mid - 1, key, index);
        }
    }
}

//Another approach, but worst the time complexity!!
// execution time : 15ms
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
       //total time : O(nlogn + nlogn + n) = O(nlogn)
        int count = 0;
        int n = nums.length;
        int[] res = new int[n]; 
        
        ArrayList<Integer> temp = new ArrayList<>();//extra space
        for(int a : nums){// O(n)
            temp.add(a);  
        }
        Collections.sort(temp);
        for(int i = 0; i < n; i++){ // n + 1
            res[i] = temp.indexOf(nums[i]); // n * n, cuz indexOf takes O(n)
        }
        
        return res;
    }
    
}

// Can optimize it further from nlogn to n!! ----> yes
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int[] res = new int[nums.length];
        
        for (int i =0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        
        for (int i = 1 ; i <= 100; i++) {
            count[i] += count[i-1];    
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                res[i] = 0;
            else 
                res[i] = count[nums[i] - 1];
        }
        
        return res;        
    }
}

