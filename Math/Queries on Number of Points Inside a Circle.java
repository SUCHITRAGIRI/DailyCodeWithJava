
//https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/

//Brute froce soln: O(N*M) where N is the number of points and M is the number of queries!
class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        int k = 0;
        int count = 0;
        for(int[] q: queries){ 
            count = 0;
            for(int[]  p: points){ 
                int r = q[2];
                if(euclideanDistance(q[0], q[1], p[0], p[1]) <= r)count++; 
            }
            res[k++] = count;
        }
        return res;
    }
    
    double euclideanDistance(int x1, int y1, int x2, int y2){
        
        double distance = 0;
        int dis1 = x2 - x1;
        int dis2 = y2 - y1;
        
        distance = Math.sqrt(dis1 * dis1 + dis2 * dis2);
        
        return distance;
        
    }
}

//Can we improve this??
//Via sorting but I don't know how to do that!
