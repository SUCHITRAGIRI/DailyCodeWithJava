//https://leetcode.com/problems/to-lower-case/

//time : O(N)
class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray()){
            if(c >= 65 && c <= 90){
                c = (char)(c + 32);    //use this cuz the diff betw A to a is 32
                     //and also we know A start from 65 and Z(90)
              //a to z(97 to 122)
            }
            sb.append(c);
        }
        
        return sb.toString();
    }
}
