//https://www.geeksforgeeks.org/recursive-bubble-sort/

package AllRecursion;

public class BubbleSort {

	public static void main(String[] args) {
	
		int[] arr = {2, 4, 1, 5, 6, 3, 1, 35, 2};
		BubbleSort(arr.length, arr);
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	static void BubbleSort(int n, int[] arr) {
		if(n == 1)return;
			
			for(int i = 0; i < n - 1; i++) {
				if(arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
				
				BubbleSort(n - 1, arr);
			}
	}

}
