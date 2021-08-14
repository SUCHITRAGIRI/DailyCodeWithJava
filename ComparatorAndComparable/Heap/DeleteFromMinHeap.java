
public class DeleteElementFromMin_Heap {

	public static void main(String[] args) {
		//array representation of min heap
		
//		        1
//		      /   \
//		     5     2
//        / \   / \
//       9   7  4   6
		int[] arr = {1, 5, 2, 9, 7, 4, 6};
		
		int n = arr.length;
		n = deleteRoot(arr, n);
		printArray(arr, n);	
	}
		
	//mathod to delete root from min heap
	
	static int deleteRoot(int[] arr, int n) {
		int smallestEle = arr[n - 1];
		
		arr[0] = smallestEle;
		
		n = n - 1;
		
		heapify(arr, n, 0);
		return n;
	}
		
	//heapify method
	
	static void heapify(int arr[], int n, int i) {
		int small = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		
		if(l < n && arr[small] > arr[l]) {
			small = l;
		}
		if(r < n && arr[small] > arr[r]) {
			small = r;
		}
		
		if(small != i) {
			int swap = arr[i];
			arr[i] = arr[small];
			arr[small] = swap;
			
			heapify(arr, n, small);
		}
	}
	
	//print the array
	static void printArray(int[] arr, int n) {
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	}

