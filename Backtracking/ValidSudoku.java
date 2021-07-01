//https://leetcode.com/problems/valid-sudoku/

//Check where the existing elements are present in sudoku is valid or not!

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.')continue;
                if(!isValidIndex(board[i][j], board, i, j))return false;  
                }
            }
        
    return true;
    }

public boolean isValidIndex(char num, char[][] board, int row, int col){
    int blkrow = (row / 3) * 3, blkcol = (col / 3) * 3; // Block no. is i/3, first element is i/3*3
    int count = 0;
    for (int i = 0; i < 9; i++){
            if (board[i][col] == num && i != row)return false;
            if(board[row][i] == num && i != col)return false;
            if(board[blkrow + i / 3][blkcol + i % 3] == num && blkrow + i / 3 != row && blkcol + i % 3 != col)return false;
            }
                
    return true;

}
}
