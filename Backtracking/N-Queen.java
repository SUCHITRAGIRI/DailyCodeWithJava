//https://leetcode.com/problems/n-queens/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                 board[i][j] = '.';
            }   
            }
                List<List<String>> res = new ArrayList<>();
                dfs(0, board, res);
            
        return res;
    }
    
    public void dfs(int col, char[][] board, List<List<String>> res){
        if(col == board.length){
            res.add(construct(board));
            return;
        }
        
        for(int row = 0; row < board.length; row++){
            if(isValid(board, row, col)){
                board[row][col] = 'Q';
                dfs(col + 1, board, res);
                board[row][col] = '.';
            }
        }
    }
    
    public List<String> construct(char[][] board){
        List<String> res = new ArrayList<String>();
        for(int i = 0; i < board.length; i++){
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
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
