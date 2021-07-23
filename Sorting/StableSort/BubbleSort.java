//Bubble sort is stable and adaptive.
//Tc : O(N^2)




package stableSorts;
import java.util.*;

public class BubbleSort {

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
		arr = bubbleSort(arr, n);
		for(int a : arr)
			System.out.print(a + " ");
	}
	
	public static int[] bubbleSort(int[] arr, int n) {
		
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - 1 - i; j++) {
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}
}
