
//#### About #######
//1. Stable sort
//2. Adaptive (means tc reduces when array is sorted, no need to do anything by users)
//3. Worst Case : time O(N^2)
//     Best Case : time O(N)
//4. In place sorting means no require any extra space 
// Space complexity O(1)


//****** Logic ************//
// 1. let us assume [5, 2, 3, 7, 1], size = 5 
// 2.  So, here just assume that [5| 2, 3, 7, 1]   (left part is sorted arry and right is unsorted cuz single ele (5) itself in sorted order)
// 3.  make a for loop i = 1 to n-1 (5 - 1) ==> its in unsorted array
// 4. nd take j = i - 1 ( which is end index of sorted array)
// 5. store the vlur of arr[i] in temp 
// 6. make another while loop until j >= 0 && temp < arr[j]
// 7. nd inside this just update the arr[j + 1] value with arr[j] (nothing but just shifting the value in right side if above condition is true) and j--
// 8. exit the while loop
// 9. now update the arr[j + 1]  = temp
// 10. exit for loop and return the array !! Done

//###########In simple word, just compare the curr ele in left hand with every possible ele and find its proper position by shifting the other ele nd placed over there.##########

package stableSorts;
import java.util.*;

public class InsertionSort {

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
				arr = insertionSort(arr, n);
				for(int a : arr)
					System.out.print(a + " ");
	}
	
	public static int[] insertionSort(int[] arr, int n) {
		for(int i = 1; i < n; i++) {
			int temp = arr[i];
			int j = i - 1;
			while(j >= 0 && temp < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			
			arr[j + 1] = temp;
		}
		
		return arr;
	}

}


