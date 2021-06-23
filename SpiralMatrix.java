//https://leetcode.com/problems/spiral-matrix/
//Very insightful problem

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
       
        List<Integer> list = new ArrayList<>();
       
        int T = 0, D = m - 1;
        int L = 0, R = n - 1;
        
        int dir = 0;
       
        while( T <= D && L <= R){
            
            //right traversal
            if(dir == 0){
            for(int j = L; j <= R; j++){
                list.add(matrix[T][j]);
            }
            T++;
            }
            
            //down traversal
            else if(dir == 1){
            for(int i = T; i <= D; i++){
                list.add(matrix[i][R]);
            }
            R--;
            }
            //left traversal
            else if(dir == 2){
            for(int j = R; j >= L; j--){
                list.add(matrix[D][j]);
            }
            D--;
            }
            //up traversal
           else if(dir == 3){
            for(int i = D; i >= T; i--){
                list.add(matrix[i][L]);
            }
            L++;
        }
        
            dir = (dir + 1) % 4;
        }
        return list;
    }
    
   
}
