// 1. Unstable sort
// 2. TC : O(N^2) 
// 3. Non Adaptive sorting algo (means always the tc will be n^2 will not change in the input array order, ex if array is already sorted still it will take O(n^2) means doesn't matter arr is in which order it will take same for every input)


//########### Logic #################
// two for loop i = 0; i < n - 1 (outer loop)
// j = i + 1 ; j < n (inner loop)
//1. initalize ith index as min value index
//2. then start compare with arr[min] with rest array 
// nd if found the other ele is less than the arr[min] value then just upadate the min index value with found less ele index
//now find the 1st min index , exit the inner for loop
// nd swap arr[min] with arr[i]
// repeat the steps
// exit **done!!

//In simple word if our array size is n
// we have to make n - 1 comparation
//in 1st i = 0, iteration the smallest ele will place at index i = 0
// in 2nd iteration i = 1, 2nd smallest ele will place at index i = 1
// in 3rd iteration the 3rd smallest ele will place at index i = 2
//.................
//....so no...
// nd in n- 1 iteration the n - 1 samllest Or largest ele will place at last index or i = n - 1


package unstableSorts;
import java.util.*;

public class SelectionSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// no. of elements in an array
				int n = sc.nextInt();
				// take an array
				int[] arr = new int[n];
				
				for(int i = 0; i < n; i++) {
					arr[i] = sc.nextInt();
				}
				//method call
				arr = seletionSort(arr, n);
				for(int a : arr)
					System.out.print(a + " ");

	}
	
	// note : selection sort is a unstable when we take an array 
	// but in linkedlist it will be stable sort 
	
	
	public static int[] seletionSort(int[] arr, int n) {	
		int min;
		for(int i = 0; i < n - 1; i++) {
			min = i;
			for(int j = i + 1; j < n; j++) {
				if(arr[min] > arr[j]) {
					min = j;
				}
			}
		int temp = arr[min];
		arr[min] = arr[i];
		arr[i] = temp;
		}	
		return arr;
	}

}




