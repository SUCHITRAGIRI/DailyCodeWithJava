package dp;
import java.util.*;
public class UniquePath {
//using Dp...
	//https://leetcode.com/problems/unique-paths/
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int m = sc.nextInt();
	int n = sc.nextInt();
	sc.close();
	System.out.println(uniquePaths(m, n));
	} 
	    public static int uniquePaths(int m, int n) {
	        int[][] memo = new int[m + 1][n + 1]; // using memoization
	        int count = helper(0, 0, m, n, memo);
	          return count;
	    }   
		    public static int helper(int i, int j, int r, int c, int[][] memo){
	            if(memo[i][j] != 0)return memo[i][j];
	            
		        if(i > r - 1 || j > c - 1)return 0;
	            
		        if(i == r - 1 && j == c - 1){
		            return 1;
		        }
		        
		        int res = helper(i, j + 1, r, c, memo) + helper(i + 1, j, r, c, memo);
		        memo[i][j] = res;
	            return res;
	}
	}


