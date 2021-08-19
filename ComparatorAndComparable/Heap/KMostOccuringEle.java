//https://practice.geeksforgeeks.org/problems/most-occurring-elements-1587115620/1/?track=dsa-workshop-1-heap&batchId=308#


class Solution
{
    //Function to print the sum of frequencies of k numbers
    //with most occurrences in an array.
    int kMostFrequent(int arr[], int n, int k){
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(Integer freq : map.values()){
            maxHeap.offer(freq);
        }
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += maxHeap.poll();
        }
        
        return sum;
    }
}
