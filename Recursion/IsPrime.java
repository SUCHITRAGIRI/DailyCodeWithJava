/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) {
	 //product of two numbers using recursion
     int n = 19;
     System.out.println(isPrime(n, 2));
     
	}
	
	static boolean isPrime(int n, int a){
	    if(a == n)return true;
	    
	    if(n % a == 0)return false;
	    if(a * a > n)return true;
	    
	    return isPrime(n, a + 1);
	}
}
