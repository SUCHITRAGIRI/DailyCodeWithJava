package stableSorts;

import java.util.*;

// count sort is a stable sort means it remain the order as earlier while sorting the elements when elements are same!
//example   1 3 4 5 1 2 4 
//          a b r d w s q   

// apply sorting: 1 1 2 3 4 4 5 (here order is maintain when the elements are same like 1st '1' is associated with a and 2nd 1 is associated with w so always a's asso '1' comes before w's asso '1' just maintain the order of element. 
//                a w s b r q d 
//This concept is known as stable sort.

//Note: count sort is used when the range is small and elements are more!

public class CountSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array \n");
		int n = sc.nextInt(); // no. of elements in an array
		int[] arr = new int[n];
		// put the elements in an array
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
        int min = arr[0];
        int max = arr[0];
        
        for(int i = 0; i < arr.length; i++) {
        	if(min > arr[i]) {
        		min = arr[i];
        	}
        	if(max < arr[i]) {
        		max = arr[i];
        	}
        }
		
       // System.out.println(min +" "+ max);
		
		// sort the array using count sort

		countSort(arr, min, max);

	}

	public static void countSort(int[] arr, int min, int max) {
     int range = max - min;
     int[] freq = new int[range + 1];
     //count feq of elements and store in feq array
     for(int i = 0; i < arr.length; i++) {
    	 int idx = arr[i] - min;
    	 freq[idx]++;
     }
     for(int f:freq)
     System.out.print(f+ " ");
     System.out.println();
     // add the elements
     for(int i = 1; i < freq.length; i++) {
    	 freq[i] = freq[i] + freq[i - 1];
     }
     for(int f : freq)
     System.out.print(f +" ");
     System.out.println();
     
     int ans[] = new int[arr.length];
     
     for(int i = arr.length - 1; i >= 0; i--) {
    	 int val = arr[i];
    	 int pos = freq[val - min];
    	 int ind = pos - 1;
    	 ans[ind] = val;
    	 freq[val - min]--;
     }
     System.out.println("Sort the array");
     for(int i : ans) {
    	 System.out.print(i +" ");
     }
	}

}
