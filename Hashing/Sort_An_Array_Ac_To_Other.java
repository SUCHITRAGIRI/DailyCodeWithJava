//https://practice.geeksforgeeks.org/problems/relative-sorting4323/1/?track=dsa-workshop-1-hashing&batchId=308#

//Enjoyed with this question and successfully done by own!!

class Solution{
    // A1[] : the input array-1
    // N : size of the array A1[]
    // A2[] : the input array-2
    // M : size of the array A2[]
    
    //Function to sort an array according to the other array.
    public static int[] sortA1ByA2(int A1[], int N, int A2[], int M)
    {
        Map<Integer, Integer> map = new TreeMap<>();
        
        for(int i = 0; i < N; i++){
            map.put(A1[i], map.getOrDefault(A1[i], 0) + 1);
        }
        
        int[] res = new int[N];
        int index = 0;
        
        for(int i = 0; i < M; i++){
            if(map.containsKey(A2[i])){
                Integer freq = map.get(A2[i]);
                while(freq > 0){
                    res[index++] = A2[i];
                    freq--;
                }
                map.remove(A2[i]);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            Integer freq = entry.getValue();
            while(freq > 0){
                res[index++] = entry.getKey();
                freq--;
            }
        }
        return res;
    }
}

