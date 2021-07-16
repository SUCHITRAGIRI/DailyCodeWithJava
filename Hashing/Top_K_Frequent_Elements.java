//https://leetcode.com/problems/top-k-frequent-elements/submissions/
//Using priority queue

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (x, y) -> map.get(y) - map.get(x)
        );
        
        for(int ele : nums){
            map.put(ele, map.getOrDefault(ele, 1) + 1);
        }
        
        pq.addAll(map.keySet());
        
        int[] topK = new int[k];
        for(int i = 0; i < k; i++){
            topK[i] = pq.remove();
        }
        
        return topK;
    }
}


//using comparator

class Solution {
    public int[] topKFrequent(int[] arr, int k) {
      // My solution  
     Map<Integer, Integer> map = new HashMap<>();
		int n = arr.length;
		for(int i = 0; i < arr.length; i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			}else {
				map.put(arr[i], 1);
			}
		}
	       
Comparator<Map.Entry<Integer, Integer>> valueComparator = new Comparator<Map.Entry<Integer, Integer>>() {
	        	@Override
	        public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2){
	            Integer v1 = e1.getValue();
	            Integer v2 = e2.getValue();

	            return v2 - v1; 
	        }
	        };
	        
	        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
	       
	        
	        Collections.sort(list, valueComparator);	       
	        
	        
	        int[] res = new int[k];
	        for(int i = 0; i < k; i++) {
	        	res[i] = list.get(i).getKey();
	        }
	        
	       return res;
	    }

}


//GFG
//https://practice.geeksforgeeks.org/problems/top-k-frequent-elements-in-array/1/?track=dsa-workshop-1-hashing&batchId=308#

class Solution {
    public int[] topK(int[] nums, int k) {
      Map<Integer,Integer> map = new HashMap<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> 
    (map.get(x).equals(map.get(y))) ? y - x : map.get(y) - map.get(x));
        
    for (int ele : nums)
	map.put( ele , map.getOrDefault(ele, 0)+1 );
    pq.addAll(map.keySet());

    int[] topK = new int[k];
    for (int i = 0; i < k; i++)
	topK[i] = pq.remove();
    return topK;
}
}
