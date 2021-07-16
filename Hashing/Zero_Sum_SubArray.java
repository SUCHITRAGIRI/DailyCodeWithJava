//https://practice.geeksforgeeks.org/problems/zero-sum-subarrays1825/1/?track=dsa-workshop-1-hashing&batchId=308#

class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        Map<Long, Integer> map = new HashMap<>();
        long preSum = 0, count = 0;
        for(int i = 0; i < n; i++){
            preSum += arr[i];
            if(preSum == 0)count++;
            
            if(map.containsKey(preSum)){
                count += map.get(preSum);
            }
            
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        
        return count;
    }
}
