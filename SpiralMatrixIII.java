//https://leetcode.com/problems/spiral-matrix-iii/

class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
       
        int d = 0;
        int[][] ans = new int[rows * cols][2];
        int k = 0;
        int[] dir = new int[]{0, 1, 0, -1, 0};
        
        ans[k++] = new int[]{rStart, cStart};
        
        int len = 0; 
//initial length for the spiral traverse, the sequence it would follow : 1 1  2 2 3 3 4 4..
        
        while(k < ans.length){
            if(d == 0 || d == 2){ 
// means left to right and right to left, during this time  we increase the length of traversal path
//                 initially the len = 0
                    
//                 1 -- 2 (L to R) len = 1 (incerament)
//                 2 -- 3 (T to D) len = 1 (remain same)  
                
//                 3 --- 5 (R to L) len = 2 (increament)
//                 5 --- 7 (D to T) len = 2 (remain same)  
                // .
                // .
                // .
                // and so on    
               // refer ex 2 for better understanding
                
              len++;      
            }
            
            for(int i = 0; i < len; i++){
                rStart += dir[d];
                cStart += dir[d + 1];
                    
                if(rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols){
                    ans[k++] = new int[]{rStart, cStart};
                }    
            }
            
            d = (d + 1) % 4;
        } 
        return ans;
    }
}
