package dp;
import java.util.Scanner;

public class GlodMinePath {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();//row
		int n =  sc.nextInt();//column
		int[][] grid = new int[m][n];//grid
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt(); // the cost
			}
		}
		// function to find the min cost path
		int max = goldMinPath(grid);
		System.out.println(max);

	}
	public static int goldMinPath(int grid[][]) {
		int n = grid.length;
		int m = grid[0].length;
		int[][] dp = new int[n][m];
		
		//Here we are traversing from right to left column wise.
		
		for(int j = m - 1; j >= 0; j--) {
			for(int i = n - 1; i >= 0; i--) {
				if(j == m - 1) {
					dp[i][j] = grid[i][j];
				}else if(i == n - 1) {
					dp[i][j] = grid[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
				}else if(i == 0) {
					dp[i][j] = grid[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
				}else {
					dp[i][j] = grid[i][j] + Math.max(dp[i - 1][j], Math.max(dp[i][j + 1], dp[i + 1][j + 1]));
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			max = Math.max(dp[i][0],max);
		}
		return max;
	}

}


// Although we can do left to right as well
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
     // write your code here
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     int m = sc.nextInt(); 

     int[][] amount = new int[n][m];

     for(int i = 0; i < n; i++){
     for(int j = 0; j < m; j++){
         amount[i][j] = sc.nextInt();
     }
     }

     System.out.print(maxGold(amount));

    }

    public static int maxGold(int[][] amount){
     
     int n = amount.length;
     int m = amount[0].length;

     int[][] dp = new int[n][m];


     
     for(int c = 0; c < m ; c++){
         for(int r = 0; r < n; r++){
             if(c == 0){
                 dp[r][c] = amount[r][c];
             }else if(r == 0){
                 dp[r][c] = Math.max(dp[r][c - 1], dp[r + 1][c - 1]) + amount[r][c];
             }else if(r == n - 1){
                 dp[r][c] = Math.max(dp[r - 1][c - 1], dp[r][c - 1]) + amount[r][c];
             }
             else{
                 dp[r][c] = Math.max(Math.max(dp[r - 1][c - 1], dp[r][c - 1]), dp[r + 1][c - 1]) + amount[r][c];
             }
         }
     }
     int max = dp[0][m - 1];
     for(int i = 1; i < dp.length; i++){
        max = Math.max(max, dp[i][m - 1]);
     }

     return max;
    }

}
