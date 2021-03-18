package AllRecursion;

import java.util.*;

public class BinarySearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int val = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int search = find(arr, n, val);
		System.out.println(search);
		sc.close();
	}

	private static int find(int[] arr, int n, int val) {

		return 0;
	}

}
