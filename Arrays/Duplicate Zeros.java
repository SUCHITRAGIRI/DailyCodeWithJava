

//https://leetcode.com/problems/duplicate-zeros/
//O(1) space and O(N^2) time solution.

    public void duplicateZeros(int[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i; j--) {
                    arr[j] = arr[j-1];
                }
                i++; // we don't want to traverse over the duplicate zero
            }
        }
    }



// Tc : O(n)
//Sc: )(n)

class Solution {
    //Tc: O(N)
    //Sc: O(N)
    public void duplicateZeros(int[] arr) {
         ArrayList<Integer> a=new ArrayList<Integer>();
        int i=0;
      while(i<arr.length) 
          {
          if(arr[i]==0)
              {
              a.add(0);
              
              a.add(0);
          
              }
          else
              {
            a.add(arr[i]);
              }
          i++;
          
          }
        for(i=0;i<arr.length;i++)
            {
                arr[i]=a.get(i);
            }
     }
}
