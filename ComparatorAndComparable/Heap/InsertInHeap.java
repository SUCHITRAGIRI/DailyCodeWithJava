//Insertion in heap
public class InsertInHeap {
	static private int arr[];
	static private int size;
	static private int maxSize;

	// constructor to initialize an empty max heap with max capacity

	public InsertInHeap() {
		this.maxSize = 1000;
		this.size = -1;
		arr = new int[maxSize + 1];
	}

	public static void main(String[] args) {
		// Array representation of max_heap
		// 10
		// / \
//       5 	  3
//      / \
//     2   4

		InsertInHeap heap = new InsertInHeap();
		heap.insert(10);
		heap.insert(165);
		heap.insert(3);
		heap.insert(2);
		heap.insert(4);

		heap.insert(15);
		heap.printArray();

	}
	
	private static void heapify(int i) {
		int n = size + 1;
		
		//find parent
		int parent = (i - 1) / 2;
		if(parent >= 0) {
			//for max heap
			if(arr[i] > arr[parent]) {
				int temp = arr[parent];
				arr[parent] = arr[i];
				arr[i] = temp;
				
				heapify(parent);
			}
		}
			
	}
	
	public static void insert(int ele) {
		arr[++size] = ele;
		if(size > 0) {
			heapify(size);
		}		
	}
	
	public static void printArray() {
		for(int i = 0; i <= size; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
