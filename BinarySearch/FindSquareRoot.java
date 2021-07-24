//https://practice.geeksforgeeks.org/problems/square-root/1


class Solution
{
     long floorSqrt(long x)
	 {
		long start=0,end=x;
		while(start<=end){
		    long mid=start+(end-start)/2;
		    if(mid*mid==x)return mid;
		    else if(mid*mid>x){
          If(((mid - 1) * (mid - 1)) < x)return mid - 1;
          end=mid-1;
        }
		    else {
          If(((mid + 1) * (mid + 1)) > x)return mid;
          start=mid+1;
        }
		}
		return mid;
	 }
}

//Improvised version
class Solution
{
     long floorSqrt(long x)
	 {
		long start=0,end=x;
		while(start<=end){
		    long mid=start+(end-start)/2;
		    if(mid*mid==x)return mid;
		    else if(mid*mid>x)end=mid-1;
		    else start=mid+1;
		}
		return end;
	 }
}
