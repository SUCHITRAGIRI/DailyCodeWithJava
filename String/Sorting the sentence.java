//https://leetcode.com/problems/sorting-the-sentence/


//Time: O(N), where N is the length of string
//Note: better to use StringBuilder for great efficiency cuz if we use string and '+' operator try to append the sentence it is taking 4ms, but in contrast if we use the String Builder then it is taking 0ms!

class Solution{
    public static String sortSentence(String s) {
	String[] str = s.split(" ");                // Since the String contains only whitespaces, it's safe to split the String at them
	String[] res = new String[str.length];      // This String array will hold the rearranged words
	StringBuilder sb = new StringBuilder();     // Instead of using '+' operator to concat repeatedly, I have created a StringBuilder object which is more efficient
	int i = 0;                          
	for (String elem : str) {
		i = (int) (elem.charAt(elem.length() - 1) - '0');  // This  will extract the digit present at the end of each String and store it in i (i = index of the word in res[])
		res[i - 1] = elem.substring(0, elem.length() - 1); // This gives the substring of each String except for the digit in the end and stores the word at an appropriate index (i - 1) in res[]
	}
	//append the words from res[] to StringBuilder object to form a sentence
	for (i = 0; i < res.length - 1; i++)
		sb.append(res[i]).append(" ");
	  sb.append(res[i]);
	return sb.toString();
}
}

//
class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] bucket = new String[words.length];
        for (String word : words) {
            // Get 0th-based index from the word
            int index = Character.getNumericValue(word.charAt(word.length() - 1)) - 1;
            // Store the original word without a numeric value
            bucket[index] = word.substring(0, word.length() - 1);
        }
        
        return String.join(" ", bucket);
    }
}

//
class Solution{
public String sortSentence(String s) {
        String[] ans = new String[s.split(" ").length];
        for(String st: s.split(" ")){
            ans[st.charAt(st.length()-1) - '1'] = st.substring(0,st.length()-1);
        }
        return String.join(" ", ans);
    }
}
