class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        List<int[]> rotten = new ArrayList<>();
        int ans = 0;
        int fresh = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2)rotten.add(new int[]{i, j});
                else if(grid[i][j] == 1)fresh++;
            }
        }
        if(fresh == 0)return ans;
        
        while(rotten.size() > 0){
            List<int[]> temp = new ArrayList<>();
            
            for(int[] coor : rotten){
              int i = coor[0]; 
              int j = coor[1];
             
                if(i - 1 >= 0 && grid[i - 1][j] == 1){
                    grid[i - 1][j] = 2;
                    temp.add(new int[]{i - 1, j});
                    fresh--;
                }
                
                if(i + 1 <= grid.length - 1 && grid[i + 1][j] == 1){
                    grid[i + 1][j] = 2;
                    temp.add(new int[]{i + 1, j});
                    fresh--;
                }
                
               if(j - 1 >= 0 && grid[i][j - 1] == 1){
                   grid[i][j - 1] = 2;
                   temp.add(new int[]{i, j - 1});
                   fresh--;
             }
             if(j + 1 <= grid[0].length - 1 && grid[i][j + 1] == 1){
                 grid[i][j + 1] = 2;
                 temp.add(new int[]{i, j + 1});
                 fresh--;
             }   
         }
           
            rotten = temp;
            ans++; 
        }
        
        return fresh == 0 ? ans - 1 : -1;
    }
}
