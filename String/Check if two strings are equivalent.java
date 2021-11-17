//https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/



//take : 1ms
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }
}

//take : 0ms
//using string builder
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i=0;i<word1.length;i++){
            sb1.append(word1[i]);
        }
        for(int i=0;i<word2.length;i++){
            sb2.append(word2[i]);
        }
        
        return sb1.compareTo(sb2) == 0; //Since Java 11, StringBuilder implements Comparable, so you can use a compareTo method for the equality test:
        
    }
}

//Bit tweek

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i=0;i<word1.length;i++){
            sb1.append(word1[i]);
        }
        for(int i=0;i<word2.length;i++){
            sb2.append(word2[i]);
        }
        
        return sb1.toString().equals(sb2.toString()); //here
        
    }
}
