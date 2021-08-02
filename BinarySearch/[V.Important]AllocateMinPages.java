//This problem covers lots of concepts and if you do this problem similar kind of problem you can do very easily!
//https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1#

//Approach:
//Binary Search on Answer!


class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]a,int n,int m)
    {
        if(m > n)return -1;
        int result = Integer.MAX_VALUE;
        int start = -1;
        int end = 0;
        for(int ele : a){
           start = Math.max(start, ele);
            end += ele;
        }
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            if(isValid(a, n, m, mid)){
                result = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return result;
    }
    
    public static boolean isValid(int[] a, int n, int m, int max){
        int std = 1;
        int sum = 0;
        
        for(int i = 0; i < n; i++){
            sum += a[i];
            if(sum > max){
                std++;
                sum = a[i];
            }
            if(std > m){
                return false;
            }
        }
        return true;
    }
};
