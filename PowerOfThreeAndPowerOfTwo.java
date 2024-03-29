//Power of three
class Solution {
    public boolean isPowerOfThree(int n) {
        
        return n > 0 && (n == 1 || (n % 3 == 0) && isPowerOfThree(n / 3));
    }
}

//Power of two
class Solution {
    public boolean isPowerOfTwo(int n) {
        
        return n > 0 && (n == 1 || (n % 2 == 0) && isPowerOfThree(n / 2));
    }
}
