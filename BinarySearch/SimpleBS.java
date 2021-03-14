package binarySearch;

import java.util.*;

public class SimpleBS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of array");
int n=sc.nextInt();
System.out.println("enter the array elements");
int[] a=new int[n];
for(int i=0;i<n;i++) {
	a[i]=sc.nextInt();
}
System.out.println("enter the searched element");
int search=sc.nextInt();
sc.close();
int index=findSearchInd(a,0,n-1,search);
System.out.println("Indexed found of the searched element is\n"+index);
	}
public static int findSearchInd(int[] a,int l,int r,int search) {
	while(l<=r) {
		int mid=l+((r-l)/2);
		if(a[mid]==search) {
			return mid;
		}else if(a[mid]>search){
			r=mid-1;
		}else {
			l=mid+1;
		}
		
	}
	return -1;
}
}	
	
	

