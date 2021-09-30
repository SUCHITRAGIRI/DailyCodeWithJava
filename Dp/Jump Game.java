//https://leetcode.com/problems/jump-game/


//Simple and straight forword solution in Greedy approch.
//Also this problem can be solved by Dp approach!

class Solution {
public boolean canJump(int[] A) {
    int max = 0;
    for(int i=0;i<A.length;i++){
        if(i>max) {return false;}
        max = Math.max(A[i]+i,max);
    }
    return true;
}
}
