package binarySearch;

import java.util.Scanner;

public class FindElementInRotatedArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of rotated array");
		int n = sc.nextInt();
		System.out.println("enter the array elements");
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println("enter the searched element");
		int ele = sc.nextInt();
		sc.close();
		int index = find(a, 0, n-1, ele);
		System.out.println(index);
	}

	public static int find(int[] a, int start, int end, int ele) {
		int n=a.length,index=0;
		while (start <= end) {
        int mid=start+((end-start)/2);
        int prev=(mid+n-1)%n;
        int next=(mid+1)%n;
        if(a[mid]<=a[prev]&&a[mid]<=a[next]) {
        	index=mid;
        	
        }else if(a[mid]<a[start]) {
        	end=mid-1;
        }else {
        	start=mid+1;
        }
		}
		int i=bS(a,start,index-1,ele);
		if(i!=-1)return i;
		int j=bS(a,index,end,ele);
		if(j!=-1)return j;
		if(i==-1&&j==-1) {
			return i;
		}else if(i==-1) {
			return j;
		}else {
			return i;
		}
		
	}

	public static int bS(int[] a, int start, int end, int key) {
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (a[mid] == key) {
				return mid;
			} else if (a[mid] < key) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

}
