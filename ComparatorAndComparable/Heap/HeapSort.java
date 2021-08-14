import java.util.Scanner;
public class HeapSortInAscendingAndDescending {
//If you want to sort array in ascending order then use Max_heap
//and for descending order just use min heap (means in order to sort asc or dsc order we just have to change the heapify function in our program ac to the given q) 	
	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	//size of the array
	int n = sc.nextInt();
	int[] arr = new int[n];
	for(int i = 0; i < n; i++) {
		arr[i] = sc.nextInt();
	}
	// in ascending order!
	heapSortAsc(arr, n);
	System.out.println("Ascending Order!");
	printArray(arr, n);
	
	//in descending order!
	heapSortDsc(arr, n);
	System.out.println("\nDescending Order!");
	printArray(arr, n);
	
	
	}
	//Heap sort in ascending order
	public static void heapSortAsc(int arr[], int n) {
		//Build heap
		for(int i = (n - 2) / 2 ; i >= 0; i--)
			heapifyMax(arr, n, i);
			
		//extract one by one
		for(int i = n - 1; i >= 0; i--) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			
			//call max heapify on the reduce heap
			heapifyMax(arr, i, 0);
		}	
	}
//Heap sort in Descending order	
	public static void heapSortDsc(int arr[], int n) {
		//Build heap
		for(int i = (n - 2) / 2 ; i >= 0; i--)
			heapifyMin(arr, n, i);
			
		//extract one by one
		for(int i = n - 1; i >= 0; i--) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			
			//call min heapify on the reduce heap
			heapifyMin(arr, i, 0);
		}	
	}
	
//Min Heapify	
public static void heapifyMin(int arr[], int n, int i) {
		
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
			heapifyMin(arr, n, smallest);
		}
	}

//Max Heapify
public static void heapifyMax(int[] arr, int n, int i) {
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
		heapifyMax(arr, n, largest);
				
	}
}

public static void printArray(int[] arr, int n) {
	for(int ele : arr)
		System.out.print(ele + " ");
}

}
