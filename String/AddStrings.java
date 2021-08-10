
//https://leetcode.com/problems/add-strings/
//Naive approach!
class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        String res = "";
        int sum = 0, rem = 0, div = 0;
        while(i >= 0 || j >= 0){
            int d1 = i < 0 ? 0 : num1.charAt(i) - '0';
            int d2 = j < 0 ? 0 : num2.charAt(j) - '0';
            
            sum = d1 + d2 + rem;
            div = sum % 10;
            rem = sum / 10;
            res = div + res;         
            i--;
            j--;            
        }
               
        return rem == 0 ? res : rem + res;
    }
}

//Using string builder (optimized)
public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}
