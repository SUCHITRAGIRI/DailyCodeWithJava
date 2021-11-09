//

class Solution {
    public String addBinary(String a, String b) {
        int[] nums = new int[Math.max(a.length(),b.length())+1];    
        int carry = 0;
        for(int i = 0;i<a.length() || i < b.length() || carry != 0;i++){
            int sum = carry;
            if(i < a.length()) sum += a.charAt(a.length()-1-i) - '0';//add from last digit to 1st digit in a
            if(i < b.length()) sum += b.charAt(b.length()-1-i) - '0';//add from last digit to 1st digit in b
            nums[i] = sum % 2;
            carry = sum/2;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = nums.length-1;i>=0;i--){                        //reverse the nums array
            if(i == nums.length-1 && nums[i] == 0) continue;        //skip leading 0s
            sb.append(nums[i]);
        }
        return sb.toString();
    }
}

//More explanation:

public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder(); //Google immutability or string vs stringbuilder if you don't know why we use this instead of regular string
        int i = a.length() - 1, j = b.length() -1, carry = 0; //two pointers starting from the back, just think of adding two regular ints from you add from back
        while (i >= 0 || j >= 0) {
            int sum = carry; //if there is a carry from the last addition, add it to carry 
            if (j >= 0) sum += b.charAt(j--) - '0'; //we subtract '0' to get the int value of the char from the ascii
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2); //if sum==2 or sum==0 append 0 cause 1+1=0 in this case as this is base 2 (just like 1+9 is 0 if adding ints in columns)
            carry = sum / 2; //if sum==2 we have a carry, else no carry 1/2 rounds down to 0 in integer arithematic
        }
        if (carry != 0) sb.append(carry); //leftover carry, add it
        return sb.reverse().toString();
    }


// Optimized
public class Solution {
    public String addBinary(String a, String b) {
    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0;
    StringBuilder sb = new StringBuilder();
    
    while (i >= 0 || j >= 0 || carry > 0){
        int sum = ((i < 0) ? 0 : (a.charAt(i--) - '0')) + 
                    ((j < 0) ? 0 : (b.charAt(j--) - '0')) + 
                    carry; 
        
        sb.append(Integer.toString(sum & 1));
        carry = (sum >> 1) & 1;
    }
    
    return sb.reverse().toString();
}
}
