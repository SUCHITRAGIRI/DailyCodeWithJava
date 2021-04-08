package stableSorts;
//Leetcode problem no. 75 Color sort link- https://leetcode.com/problems/sort-colors/ 

import java.util.Scanner;

public class DutchFlageAlgo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array \n");
		int n = sc.nextInt(); // no. of elements in an array
		int[] arr = new int[n];
		// put the elements in an array
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
      
		sortColors(arr);
	}
	    public static void sortColors(int[] nums) {
	     
	//apply Dutch NAtional Flag algorithm
	 // use only one pass
	        //Tc O(N)
	        //Sc O(1)
	     int lo = 0, mid = 0, hi = nums.length - 1;
	        //int i = 0;
	        while(mid <= hi){
	            switch(nums[mid]){
	                case 0:{
	                    int temp = nums[mid];
	                    nums[mid] = nums[lo];
	                    nums[lo]  = temp;
	                    mid++;
	                    lo++;
	                    break;
	                }
	                    
	                case 1:{
	                    mid++;
	                    break;
	                }
	                
	                case 2:{
	                    int temp = nums[mid];
	                    nums[mid] = nums[hi];
	                    nums[hi]  = temp;
	                    hi--;
	                    break;
	                }     
	            }
	        }
	           for(int arr : nums)
	           System.out.print(arr +" ");  
	      
	    }
	}

// This my another approach
//using count sort strategy
//class Solution {
//    //this is my two pass solution
//    public void sortColors(int[] nums) {
//        int c1 = 0, c2 = 0, c0 = 0;
//       // pass 1
//        for(int i = 0; i < nums.length; i++){
//            if(nums[i] == 0)c0++;
//            else if(nums[i] == 1)c1++;
//            else c2++;
//        }
//       // pass 2
//        for(int i = 0; i < nums.length; i++){
//            if(i < c0)nums[i] = 0;
//            else if(i < c0 + c1)nums[i] = 1;
//            else nums[i] = 2;
//        }
//        
//    }
//}
//
//
