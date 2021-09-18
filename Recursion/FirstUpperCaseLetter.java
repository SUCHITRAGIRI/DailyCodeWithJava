/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) {
	String s = "TgeVekHsforgeeks";
	char c = find1stUpper(s, 0);
	if( c == '0') 
	System.out.println("Upper case is not found"); 
	else
	System.out.println(c);
	}
	
	static char find1stUpper(String s, int ind){
	        if(ind == s.length())return '0';
	        //if(s.charAt(ind) >= 65 &&  s.charAt(ind) <= 90)return s.charAt(ind);
	        if(Character.isUpperCase(s.charAt(ind)))return s.charAt(ind);
	        return find1stUpper(s, ind + 1);
	}
}

//################# Iterative
import java.io.*;

class GFG {
	public static void main (String[] args) {
	String s = "geeksforgeeks";
	char c = find1stUpper(s);
	if( c == '0') 
	System.out.println("Upper case is not found"); 
	else
	System.out.println(c);
	}
	
	static char find1stUpper(String s){
	    for(char c : s.toCharArray()){
	        if(c >= 65 && c <= 90)return c;
	    }
	    return '0';
	}
}
