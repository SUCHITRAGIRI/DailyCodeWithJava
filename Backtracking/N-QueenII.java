//https://leetcode.com/problems/n-queens-ii/

class Solution {
    
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                 board[i][j] = '.';
            }   
            }
        
        int count = dfs(0, board);
        
        return count;
    }
    
    public int dfs(int col, char[][] board){
        if(col == board.length){
            return 1;
        }
        int count = 0;
        for(int row = 0; row < board.length; row++){
            if(isValid(board, row, col)){
                board[row][col] = 'Q';
                count  += dfs(col + 1, board);
                board[row][col] = '.';
            }
        }
        return count;
    }
    
     public boolean isValid(char[][] board, int row, int col){
        int tempRow = row;
        int tempCol = col;
        
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q')return false;
            row--;
            col--;   
        }
        
        row = tempRow;
        col = tempCol;
        
        while(row < board.length && col >= 0){
            if(board[row][col] == 'Q')return false;
            row++;
            col--;
        }
        
        row = tempRow;
        col = tempCol;
        
         while(col >= 0) {
            if(board[row][col] == 'Q') return false; 
            col--; 
        }
        return true;
    }
}
