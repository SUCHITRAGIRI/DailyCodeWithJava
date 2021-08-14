
//Delete an element from the max heap
public class DeleteElementFromMax_Heap {

	public static void main(String[] args) {
		// Array representation of Max-Heap
//        //     10
//        //    /  \
//        //   5    3
//        //  / \
//        // 2   4
		int arr[] = {10, 5, 3, 2, 4};
		int n = arr.length;
		n = deleteRoot(arr, n);
		printArray(arr, n);
	}	
	//method to delete the root from the heap
	public static int deleteRoot(int arr[], int n) {
		//get the last element 
		int lastEle = arr[n - 1];
		//replace root with last element
		 arr[0] = lastEle; 
		 //decrease the size of heap by 1
		 n = n - 1;
		 //heapify the root node
		 heapify(arr, n, 0);
		 //return the new size of the heap
		return n;
	}
	
	//heapify method to retain the order of heap tree
	public static void heapify(int[] arr, int n, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		//if left child is larger than largest
		if(left < n && arr[left] > arr[largest]) {
			largest = left;
		}
		//if right child is larger than largest
		if(right < n && arr[right] > arr[largest]) {
			largest = right;
		}
		//if largest is not root
		if(largest != i) {
			int swap = arr[largest];
			arr[largest] = arr[i];
			arr[i] = swap;		
			//recursively heapfy the affected subtree
			heapify(arr, n, largest);
		}	
	}	
	//print the array
	public static void printArray(int[] arr, int n) {
		for(int i = 0; i < n; ++i) {
			System.out.print(arr[i] + " ");
		}
	}
}
