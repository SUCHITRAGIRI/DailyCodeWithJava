package binarySearch;

import java.util.Scanner;

public class FindFirstOccurance {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of array");
		int n = sc.nextInt();
		System.out.println("enter the array elements");
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println("enter searched element");
		int search=sc.nextInt();
		sc.close();
       int index=first(a,0,n-1,search);
       System.out.println(index);
	}
public static int first(int[] a, int s, int e, int search) {
int result=-1;
	while(s<=e) {
		int mid=s+((e-s)/2);
		if(a[mid]==search) {
			result=mid;
			e=mid-1;
		}else if(a[mid]>search) {
			e=mid-1;
		}else {
			s=mid+1;
		}
	}
	return result;
}
	
}
