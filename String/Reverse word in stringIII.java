//https://leetcode.com/problems/reverse-words-in-a-string-iii/

//Time : O(N), where N is the string length
//space: the word and result size up to n
public class Solution {
    public String reverseWords(String input) {
         StringBuilder result = new StringBuilder();
         StringBuilder word = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                word.append(input.charAt(i));
            } else {
                result.append(word.reverse());
                result.append(" ");
                word.setLength(0);
            }
        }
        result.append(word.reverse());
        return result.toString();
    }
}
