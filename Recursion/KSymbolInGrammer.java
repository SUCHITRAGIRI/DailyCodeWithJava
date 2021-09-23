//https://leetcode.com/problems/k-th-symbol-in-grammar/

class Solution {
    public int kthGrammar(int n, int k) {
        if(n == 1)return 0;
        int len = (1 << n - 1);
        if(k > len / 2)return kthGrammar(n - 1, k - len / 2) == 0 ? 1 : 0;
        else return kthGrammar(n - 1, k);
    }
}
