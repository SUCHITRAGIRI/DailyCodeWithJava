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
