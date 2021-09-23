//https://leetcode.com/problems/powx-n/
class Solution {

       
public double myPow(double x, int n) {
    if (n == 0)
		return 1;

    if(n == -1){
        return 1/x;
    }
    
	double ans = myPow(x, n / 2);
    
    return (n % 2 == 0) ? ans * ans : ans * ans * ((n > 0) ? x : 1 / x);
}
}
