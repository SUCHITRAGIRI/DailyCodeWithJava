//https://leetcode.com/problems/spiral-matrix-ii/

class Solution {
    public int[][] generateMatrix(int n) {
        int T = 0, D = n - 1;
        int L = 0, R = n - 1;
        
        int[][] ans = new int[n][n];
        int dir = 0, value = 0;
        
        while(T <= D && L <= R){
            if(dir == 0){
                for(int i = L; i <= R; i++){
                   ans[T][i] = ++value; 
                }
                T++;
            }
            
            else if(dir == 1){
                for(int i = T; i <= D; i++){
                    ans[i][R] = ++value;
                }
                R--;
            }
            
            else if(dir == 2){
                for(int i = R; i >= L; i--){
                    ans[D][i] = ++value;
                }
                D--;
            }
            
            else if(dir == 3){
                for(int i = D; i >= T; i--){
                    ans[i][L] = ++value;
                }
                L++;
            }
            
            dir = (dir + 1) % 4;
        }
        
        return ans;
    }
}
