package binarySearch;

import java.util.Scanner;

public class NumberOfRotation {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the size of rotated array");
			int n = sc.nextInt();
			System.out.println("enter the array elements");
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			sc.close();
	      int index=bS(a,0,n-1);
	      System.out.println("Number of rotation is :"+index);
	       }
	public static int bS(int[] a, int start, int end) {
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(a[mid]<a[(mid+1)%a.length]&&a[mid]<a[(mid+a.length-1)%a.length]) {
				return mid;
			}
			else if(a[mid]>a[end]) {
				start=mid+1;
			}else {
				end=mid-1;
			}
		}
			return 0;	
				
			
		}
	}

	


