package AllRecursion;

public class StairCase {

	public static void main(String[] args) {
		int n = 3;
		System.out.println(stepPerms(n));

	}
	
	  
	public static int stepPerms(int n) {
	    int[] memo = new int[n + 1];
	    int count = NumOfWays(n, memo);
	    return count;
	    }
	
	    //count nos of diff ways
	    public static int NumOfWays(int n, int[] memo)
	    {
	        if(n == 0){
	        return 1;}
	    
	    if(n < 0)return 0;
	    
	    if(memo[n] != 0){
	        return memo[n];
	    }
	    
	    int res = NumOfWays(n - 1, memo) + NumOfWays(n - 2, memo) + NumOfWays(n - 3, memo);
	     memo[n] = res;
	    return res; 
	    }
}
