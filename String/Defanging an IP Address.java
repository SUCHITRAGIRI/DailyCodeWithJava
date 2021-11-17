//https://leetcode.com/problems/defanging-an-ip-address/

class Solution {
    public String defangIPaddr(String address) {
      //using String builder
        StringBuilder sb = new StringBuilder();
        
        for(char c : address.toCharArray()){
            sb.append(c == '.' ? "[.]" : c);
        }
        return sb.toString();
        
    }
}

//
class Solution {
    public String defangIPaddr(String address) {
      //using String join
        return String.join("[.]", address.split("\\."));
    }
}

//
class Solution {
    public String defangIPaddr(String address) {
      //using replaceAll
        return address.replaceAll("\\.", "[.]");
    }
}
