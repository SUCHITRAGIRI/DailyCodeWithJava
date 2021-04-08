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
