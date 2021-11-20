//

//time: O(M + N)
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int n = typed.length();
        int m = name.length();
        
       // if(m > n)return false;
        
        int j = 0;
        for(int i = 0; i < n; i++){
            if(j < m && name.charAt(j) == typed.charAt(i))j++;
            else if(i == 0 || typed.charAt(i - 1) != typed.charAt(i))return false;
        }
        return j == m;
    }
}
