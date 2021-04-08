package dp;
import java.util.*;
public class MinimumCostPath {

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
		int cost = findMinCostPath(grid);
		System.out.println(cost);
	}
	
	public static int findMinCostPath(int[][] grid)
	{
		 for(int i=1; i<grid.length; i++) {
	            grid[i][0] = grid[i-1][0] + grid[i][0];
	        }
	        for(int j=1; j<grid[0].length; j++) {
	            grid[0][j] = grid[0][j-1] + grid[0][j];
	        }
	        for(int i=1; i<grid.length; i++) {
	            for(int j=1; j<grid[0].length; j++) {
	                grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
	            }
	        }
	        return grid[grid.length-1][grid[0].length-1];
	    }

	}


