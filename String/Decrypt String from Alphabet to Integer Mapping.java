//https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/

class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(i < s.length() - 2 && s.charAt(i + 2) == '#'){
                int a = Integer.parseInt(s.substring(i, i + 2));
                char c = (char)(96 + a);
                sb.append(c);
                i += 2;
            }else{
            char c = (char)((s.charAt(i)) + 97 - '1');      // Ascii value of '0' = 48     //A to Z = 65 - 90
                                                           //                 '9' = 57     // a - z = 97 - 122   
            sb.append(c);
            }
        }
        return sb.toString();
    }
}


public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int size = s.length();
        for(int i=0; i< size;i++){
            if(i+2 < size && s.charAt(i+2) == '#'){
                sb.append((char) ((Integer.parseInt(s.substring(i, i+2)) - 1)+ 'a') );
                i=i+2;
            }
            else sb.append( (char) ( (Integer.parseInt(String.valueOf(s.charAt(i))) - 1) + 'a') );    
        }
        return sb.toString();
    }
