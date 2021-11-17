//https://leetcode.com/problems/goal-parser-interpretation/

//using Regex:
//one way: runtime : 4ms
public String interpret1(String command) {
	return command.replaceAll("\\(\\)", "o").replaceAll("\\(al\\)", "al");
}

//another
public String interpret(String command) {
        return command.replaceAll("[(][)]", "o").replaceAll("[(]al[])]", "al");
    }




//runtime: 0ms
//without using regex
class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                sb.append('G');
            } else if (i + 1 < command.length() && command.charAt(i + 1) == ')') {
                sb.append('o');
                i++;
            } else {
                sb.append("al");
                i = i + 3;
            }
        }
        return sb.toString();
    }
}
