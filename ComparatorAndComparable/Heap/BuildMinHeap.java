
public class BuildMinHeap {

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
	
		int startInd = (n - 2) / 2;
		
		for(int i = startInd; i >= 0; i--) {
			heapify(arr, n, i);
		}	
		
	}
	
	public static void heapify(int arr[], int n, int i) {
		
		int smallest = i;
		
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		
		if(l < n && arr[smallest] > arr[l])
			smallest = l;
		if(r < n && arr[smallest] > arr[r])
			smallest = r;
		if(smallest != i) {
			int temp = arr[smallest];
			arr[smallest] = arr[i];
			arr[i] = temp;
			
			//recursively heapify for the affected subtree
			heapify(arr, n, smallest);
		}
	}
	
   public static void printArray(int arr[], int n) {
	for(int ele : arr)
		System.out.print(ele + " ");

  }

}
