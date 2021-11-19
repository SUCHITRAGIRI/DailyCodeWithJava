//https://leetcode.com/problems/excel-sheet-column-title/

class Solution {
    String convertToTitle(int n) {
        
        String result="";
        while(n != 0)
            {
            char c=(char)('A'+(n-1)%26);
            result=c+result;
            n=(n-1)/26;
            }
        return result;
        
    }
}
