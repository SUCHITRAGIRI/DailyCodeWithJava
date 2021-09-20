//

import java.io.*;

class GFG {
	public static void main (String[] args) {
	 //product of two numbers using recursion
     int x = 19;
     int y = 10;
     
     System.out.println(product(x, y));
	}
	
	static int product(int x, int y){
	    if(y == 0)return 0;
	    if(x < y)return product(y, x);
	    
	    return x + product(x, y - 1);
	}
}
