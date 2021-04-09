
//https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1#


class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> res = new ArrayList<>();
        boolean[][] v = new boolean[n][n]; 
        backtrack(0, 0, m, n, res, "", v);
        return res;
    }
    
    public static void backtrack(int i, int j, int[][] m, int n, ArrayList<String> res, String s, boolean[][] v){
        if(i < 0 || j < 0 || i >= n || j >= n || v[i][j] == true || m[i][j] == 0){
            return;
        }
        if(i == n - 1 && j == n - 1){
            res.add(s);
            return;
        }
        v[i][j] = true; //visited
            
               backtrack(i+1, j, m, n, res, s + "D", v);//D move
               backtrack(i, j-1, m, n, res, s + "L", v);//left
               backtrack(i, j+1, m, n, res, s + "R", v);//R move
               backtrack(i-1, j, m, n, res, s + "U", v);//Up
        
        v[i][j] = false;
        
    }
}
