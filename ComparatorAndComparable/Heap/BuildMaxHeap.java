// Build heap from the given array!
//Max_heap
public class BuildMaxHeap {

	public static void main(String[] args) {
		int arr[] = {6, 2, 5, 3, 1, 9};
		// representation of tree corresponding to the arr
		
		//    6
    //      /   \         
//         2	 5
//        / \    /
//       3	1   9
		
		int n = arr.length;
		buildHeap(arr, n);
		printArray(arr, n);
		
	}
	
	public static void buildHeap(int[] arr, int n) {
		//find the last non leaf node index from the array
		//which can be calculated by using ind = (n - 2) / 2
		
		int startInd = (n - 2) / 2;
		
		//Perform reverse the level order traversal from last non leaf node to each node
		for(int i = startInd; i >= 0; i--) {
			heapify(arr, n, i);
		}
	}
	
	public static void heapify(int[] arr, int n, int i) {
		// initialize the largest ele index as i
		
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		
		if(l < n && arr[largest] < arr[l])
			largest = l;
		if(r < n && arr[largest] < arr[r])
			largest = r;
		
		if(largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			
			//recursively heapify the affected tree
			heapify(arr, n, largest);
					
		}
	}
	
	public static void printArray(int[] arr, int n) {
		for(int ele : arr) {
			System.out.print(ele + " ");
		}
	}

}
