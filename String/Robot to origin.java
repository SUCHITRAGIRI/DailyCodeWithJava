//https://leetcode.com/problems/robot-return-to-origin/


//time: O(N), where N is the length of moves 
class Solution {
    public boolean judgeCircle(String moves) {
        //Simulation
        int x = 0, y = 0;
        
        for(char c : moves.toCharArray()){
            if(c == 'U')y--;
            else if(c == 'D')y++;
            else if(c == 'L')x--;
            else if(c == 'R')x++;
        }
        return x == 0 && y == 0;
    }
}
