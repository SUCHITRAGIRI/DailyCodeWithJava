
https://practice.geeksforgeeks.org/problems/nearly-sorted-1587115620/1/?track=dsa-workshop-1-heap&batchId=308#

class Solution
{
    //Function to return the sorted array.
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
      ArrayList<Integer> res = new ArrayList<>();
      Queue<Integer> min_heap = new PriorityQueue<>();
      
      for(int i = 0; i < num; i++){
          min_heap.add(arr[i]);
          if(min_heap.size() > k){
              res.add(min_heap.poll());
          }
      }
      
      while(!min_heap.isEmpty())
      res.add(min_heap.poll());
      
      return res;
    }
}

//another approch
class Solution
{
    //Function to return the sorted array.
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        // your code here
        ArrayList<Integer> list = new ArrayList<>();

       PriorityQueue<Integer> pq = new PriorityQueue<>();
       for(int i: arr)
       pq.offer(i);

       while(!pq.isEmpty())
        list.add(pq.poll());

       return list;
}
    
}

