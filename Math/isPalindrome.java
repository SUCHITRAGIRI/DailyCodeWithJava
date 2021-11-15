//


class Solution {
    
    public boolean isPalindrome(int x) {
        My 1st approach ==>  Time: O(n / 2), where n length of string!
        convert integer to string ans apply two pointer approach!
        if(x < 0)return false;
        String s = Integer.toString(x);
        int i = 0, j = s.length() - 1;
        while(i < j){  
            if(s.charAt(i) != s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
    
  
  //time: O(log10(n))
    public boolean isPalindrome(int x) {    
    //using math
        if(x < 0 || (x % 10 == 0 && x != 0))return false;
        
        int rev = 0;
        int temp = x;

        while(x > 0){
            int rem = x % 10;
            rev = rev * 10 + rem;
            x /= 10;
        }
        return rev == temp;        
    }    
}
