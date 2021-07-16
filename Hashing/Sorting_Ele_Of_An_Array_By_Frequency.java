//https://practice.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency-1587115621/1/?track=dsa-workshop-1-hashing&batchId=308#

//Struglling through this question but finally did!!
//Here grasped the concept of Comparator, quite confusingc concept but I am able to do this:)


//User function Template for Java

class Solution
{
    //Function to sort the array according to frequency of elements.
    static ArrayList<Integer> sortByFreq(int arr[], int n)
    {
        Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < n; i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			}else {
				map.put(arr[i], 1);
			}
		}
	       
	        Comparator<Entry<Integer, Integer>> valueComparator = new Comparator<Entry<Integer, Integer>>() {
	        	@Override
	        public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2){
	        		
	        Integer v1 = e1.getValue(); 
					Integer v2 = e2.getValue();
					return v1 == v2 ? e1.getKey() - e2.getKey() : v2 - v1;
	        }
	        };
	        
	        List<Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
	       
	        Collections.sort(list, valueComparator);	       
	       
	       ArrayList<Integer> res = new ArrayList<>();
	       
	        for(Entry<Integer, Integer> e : list) {
	        	int f = e.getValue();
	        	while(f > 0) {
	              res.add(e.getKey());
	        		f--;
	        	}
	        }
	        
	       return res; 
    }
}
