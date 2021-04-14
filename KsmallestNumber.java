import java.util.*;

public class KsmallestNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		int[] eles = findKthSmallestNo(arr, k);
		for(int ele : eles)
		System.out.println(ele);
	}
	
	public static int[] findKthSmallestNo(int[] arr, int k) {
		//using heap to find the kth smallest no.
		Queue<Integer> min_heap = new PriorityQueue<>();
//		for(int i = 0; i < arr.length; i++) {
//			max_heap.add(arr[i]);
//			if(max_heap.size() > k) {
//				max_heap.poll();
//			}
		//}
//		for(int i = 0; i < arr.length; i++) {
//			min_heap.add(arr[i]);
//			if(min_heap.size() > k) {
//				min_heap.poll();
//			}
//		}
//		int[] temp = new int[k];
//		int i = 0;
//		while(min_heap.size() > 0) {
//			temp[i++] = min_heap.poll();
//		}
//		return temp;
//	}

		
		//sort the k nearly sorted array
		int j = 0;
		for(int i = 0; i < arr.length; i++) {
			min_heap.add(arr[i]);
			if(min_heap.size() > k) {
				arr[j++] = min_heap.poll();
			}
		}
		while(min_heap.size() > 0) {
			arr[j++] = min_heap.poll();
		}
		return arr;
	}
}
