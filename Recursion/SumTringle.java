/*package whatever //do not write package name here */
//https://www.geeksforgeeks.org/sum-triangle-from-array/
import java.io.*;

class GFG {
	public static void main (String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		sumTringle(arr);
	}
	static void sumTringle(int[] arr){
	    if(arr.length == 1){
	        System.out.println(arr[0]);
	        return;
	    }
	    int[] a = new int[arr.length - 1];
	    
	    for(int i = 0; i < arr.length - 1; i++){
	        a[i] = arr[i] + arr[i + 1];
	    }
	    
	    sumTringle(a);
	    for(int i = 0; i < arr.length; i++){
	        System.out.print(arr[i]+" ");
	    }
	    System.out.println();
	}
}
