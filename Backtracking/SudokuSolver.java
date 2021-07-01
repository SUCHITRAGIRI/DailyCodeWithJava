//https://leetcode.com/problems/sudoku-solver/

class Solution {
    public void solveSudoku(char[][] board) {
        if(board.length == 0 || board == null)return;
        solve(board);
    }
  public boolean solve(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                        if(isValid(board, i, j, c)){
                            board[i][j] = c; //Put c for this cell
                            
                            if(solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }
                    
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board, int row, int col, char c){
        
         for(int i = 0; i < 9; i++) {
            if(board[i][col] == c) return false; //check row
            if(board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }   
}


//Optimize Code!

class Solution{ 
public void solveSudoku(char[][] board) {
        doSolve(board, 0); // grid and row
    }
    
    private boolean doSolve(char[][] board, int row) {
        for (int i = row; i < 9; i++) { 
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue; // if not empty cell then continue
                for (char num = '1'; num <= '9'; num++) { // otherwise try all possible num 1 to 9 whether can be fill or not!
                    if (isValid(board, i, j, num)) { 
                        board[i][j] = num; // put that number if it is valid for that index
                        if (doSolve(board, i)) //call the function with currunt row
                            return true;
                        board[i][j] = '.'; // backtrack
                    }
                }
                return false;
            }
        }
        return true;
    }
    // method use for checking the index whether it is valid for some num or not
    private boolean isValid(char[][] board, int row, int col, char num) {
        int blkrow = (row / 3) * 3, blkcol = (col / 3) * 3; // Block no. is i/3, first element is i/3*3
        for (int i = 0; i < 9; i++)
            if (board[i][col] == num || board[row][i] == num || 
                    board[blkrow + i / 3][blkcol + i % 3] == num)
                return false;
        return true;
    }
}




  
  
  
  
  
