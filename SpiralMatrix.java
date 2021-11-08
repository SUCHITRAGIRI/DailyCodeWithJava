//https://leetcode.com/problems/spiral-matrix/
//Very insightful problem

//O(
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


//Another approach!
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
       
        List<Integer> list = new ArrayList<>();
       
        int rowB = 0, rowE = matrix.length - 1;
        int colB = 0, colE = matrix[0].length - 1;
        
        while(rowB <= rowE && colB <= colE){
            //right traversal
            for(int j = colB; j <= colE; j++){
                list.add(matrix[rowB][j]);
            }
            rowB++;
            
            //down traversal
            for(int i = rowB; i <= rowE; i++){
                list.add(matrix[i][colE]);
            }
            colE--;
            
            if(rowB > rowE || colB > colE)break;
            
            //left traversal
            for(int j = colE; j >= colB; j--){
                list.add(matrix[rowE][j]);
            }
            
            rowE--;
            
            //up traversal
            for(int i = rowE; i >= rowB; i--){
                list.add(matrix[i][colB]);
            
            }
            colB++;
        }
        
        return list;
    }  
}

//Bit tweak..
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length - 1; //row size
        int m = matrix[0].length - 1;// col size
        
        List<Integer> res = new ArrayList<>();
        
        int rowB = 0, rowE = n;
        int colB = 0, colE = m;
        int dir = 0;
        
        while(rowB <= rowE && colB <= colE){
            
            //right traversal
            if(dir == 0){
            for(int i = colB; i <= colE; i++){
                res.add(matrix[rowB][i]);
            }
            rowB++;
            }
            
            //down traversal
            else if(dir == 1){
            for(int i = rowB; i <= rowE; i++){
                res.add(matrix[i][colE]);
            }
            colE--;
            }
            
            //left traversal
            else if(dir == 2){
            for(int i = colE; i >= colB; i--){
                res.add(matrix[rowE][i]);
            }
            rowE--;
            }
            
            //up traversal
            else if(dir == 3){
            for(int i = rowE; i >= rowB; i--){
                res.add(matrix[i][colB]);
            }
            colB++;
            }
            
            dir = (dir + 1) % 4;
        }
        return res;
    }
}
