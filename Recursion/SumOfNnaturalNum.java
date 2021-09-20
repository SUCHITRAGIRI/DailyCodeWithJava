/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) {
	 //product of two numbers using recursion
     int n = 10;
     System.out.println(sum_n_natural_num(n));
	}
	static int sum_n_natural_num(int n){
	    if(n == 0)return 0;
	    
	    return n + sum_n_natural_num(n - 1);
	}
	
