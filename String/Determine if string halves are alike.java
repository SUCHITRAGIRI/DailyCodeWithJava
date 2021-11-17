//https://leetcode.com/problems/determine-if-string-halves-are-alike/

class Solution {
    public boolean halvesAreAlike(String s) {
        char[] store = s.toCharArray();
        int i = 0, j = s.length() - 1;
        int c = 0;
        while(i < j){
            if(store[i] == 'a' | store[i] == 'e' | store[i] == 'i' | store[i] == 'o' | store[i] == 'u' | store[i] == 'A' | store[i] == 'E' | store[i] == 'I' | store[i] == 'O' | store[i] == 'U')c++;
           if(store[j] == 'a' | store[j] == 'e' | store[j] == 'i' | store[j] == 'o' | store[j] == 'u' | store[j] == 'A' | store[j] == 'E' | store[j] == 'I' | store[j] == 'O' | store[j] == 'U')c--;
            i++;
            j--;
        }
        
        return c == 0;
    }
}

class Solution {
    public boolean halvesAreAlike(String s) {
        int halfL = s.length() / 2, count = 0;
        for(int i = 0;i < halfL;i++){
            char c = s.charAt(i);
            if(c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U'){
                count++;
            }
        }
        for(int i = halfL;i < s.length();i++){
            char c = s.charAt(i);
            if(c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U'){
                count--;
            }
        }
        
        return count == 0;
    }
}
