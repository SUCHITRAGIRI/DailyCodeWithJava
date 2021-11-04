//https://leetcode.com/problems/number-of-good-pairs/

class Solution {
    public int numIdenticalPairs(int[] nums) {
        //brute force 
        // time : O(n^2)
        // space : O(1)
        int count = 0;
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j])count++;
            }
        }
        return count;
    }
}


//More understandable approach:
class Solution {
    //time : O(N)
    //soace : O(1)
    public int numIdenticalPairs(int[] A) {
        int res = 0, count[] = new int[101];
        
        for(int i = 0; i < A.length; i++){
            count[A[i]]++; //count the number of occurances
        }
        // Approach is :
        //[1, 1, 1, 1] => count = [4]
        // res :
        //for 1st 1: number of pairs = 3 (it will pair with its right sides of 1)
        // for 2nd 1: number of pairs = 2 (it will pair with right side of 1s not left side cuz it already got paied with it)
        //for 3rd 1: number of pairs = 1
        //Now :
        //res = 3 + 2 + 1 = 6 (pairs)
        //in general : n(n + 1) / 2;
        //but point to be noted that here n is 4 so we started n - 1 = 3
        // hence : (n - 1)(n) /2
        
        for(int i = 0; i < 101; i++){
            res += (count[i] - 1) * count[i] / 2;
        }
        
        return res;
    }
}


//Another one:

class Solution {
    //time : O(N)
    //soace : O(N)
    public int numIdenticalPairs(int[] A) {
        int res = 0, count[] = new int[101];
        for (int a: A) {
            res += count[a]++;
        }
        return res;
    }
}
