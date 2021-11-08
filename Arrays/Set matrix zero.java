//https://leetcode.com/problems/set-matrix-zeroes/



//I think the time complexity: O(N^3)
// space: O(N^2)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length - 1; // row size
        int n = matrix[0].length - 1; // col size        
        
        boolean[][] vis = new boolean[m + 1][n + 1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(matrix[i][j] == 0 && !vis[i][j])helper(matrix, i, j, vis);
            }
        }
    }
    
    void helper(int[][] matrix, int row, int col, boolean[][] vis){
        int rowB = 0, rowE = matrix.length - 1;
        int colB = 0, colE =  matrix[0].length - 1;
        
        //upadate the row
        for(int i = colB; i <= colE; i++){
             if(matrix[row][i] == 0)continue;
            matrix[row][i] = 0;
            vis[row][i] = true;
        }        
        //update the col
        for(int i = rowB; i <= rowE; i++){
            if(matrix[i][col] == 0)continue;
            matrix[i][col] = 0;
            vis[i][col] = true;
        }        
    }
}

// space: O(M + N)
class Solution {
  public void setZeroes(int[][] matrix) {
    int R = matrix.length;
    int C = matrix[0].length;
    Set<Integer> rows = new HashSet<Integer>();
    Set<Integer> cols = new HashSet<Integer>();

    // Essentially, we mark the rows and columns that are to be made zero
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (matrix[i][j] == 0) {
          rows.add(i);
          cols.add(j);
        }
      }
    }

    // Iterate over the array once again and using the rows and cols sets, update the elements.
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (rows.contains(i) || cols.contains(j)) {
          matrix[i][j] = 0;
        }
      }
    }
  }
}


//In place solution
class Solution {
 void setZeroes(int[][] matrix) {
    int col0 = 1, rows = matrix.length, cols = matrix[0].length;

    for (int i = 0; i < rows; i++) {
        if (matrix[i][0] == 0) col0 = 0;
        for (int j = 1; j < cols; j++)
            if (matrix[i][j] == 0)
                matrix[i][0] = matrix[0][j] = 0;
    }

    for (int i = rows - 1; i >= 0; i--) {
        for (int j = cols - 1; j >= 1; j--)
            if (matrix[i][0] == 0 || matrix[0][j] == 0)
                matrix[i][j] = 0;
        if (col0 == 0) matrix[i][0] = 0;
    }
}
}
