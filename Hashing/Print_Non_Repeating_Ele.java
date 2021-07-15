
//Here I learned about LinkedHashMap which almost similar to HashMap but along with this it has additional feature which it maintains the insertion order, means in which order we give the input same order we get the result but in case of HashMap we don't get that.

//https://practice.geeksforgeeks.org/problems/print-distinct-elements-1587115620/1/?track=dsa-workshop-1-hashing&batchId=308#
class Solution
{
    //Function to return non-repeated elements in the array.
    static ArrayList<Integer> printNonRepeated(int arr[], int n)
    {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        
        for(int i = 0; i < n; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);
            }else{
                map.put(arr[i], 1);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1)res.add(entry.getKey());
        }
        
        return res;
    }
}

