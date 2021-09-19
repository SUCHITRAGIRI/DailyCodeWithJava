/*package whatever //do not write package name here */
//https://www.geeksforgeeks.org/program-for-length-of-a-string-using-recursion/
import java.io.*;

class GFG {
	public static void main (String[] args) {
	String s = "jkjs";
	System.out.println(findLength(s));
	}
	
	static int findLength(String s){
	    if(s.equals(""))return 0;
	    return findLength(s.substring(1)) + 1;
	}
}
