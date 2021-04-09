
//LeetCode Qno. 17
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
class Solution {
    Map<String, String> phone = new HashMap<String, String>() {
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };

    List<String> output = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return output;
    }

    public void backtrack(String combination, String next_digits) {
        if (next_digits == null || next_digits.equals("")) {
            output.add(combination);
        } else {
            String next = next_digits.substring(0, 1);
            String val = phone.get(next);
            for (int i = 0; i < val.length(); i++) {
                backtrack(combination + Character.toString(val.charAt(i)), next_digits.substring(1));
            }
        }
    }
}
