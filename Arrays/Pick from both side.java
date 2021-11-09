//https://www.interviewbit.com/problems/pick-from-both-sides/
//Nice problem!!


//Input : [5, -2, 3, 4, 6]
//B = 3

//intution : In this we have to calculate max sum num of B elements, from left and right!
left:                                                   right:                   sum             maxSum of all sums = 15
5 -2 3                                                  _                         6
5 -2                                                    6                         9
5                                                       4 6                       15 
_                                                       3 4 6                     13

//Another way
// as we know we have to calculate max B nos of ele, so in remain array we have min ele of n - B ele, where n is the no. of ele in array.
//so, for find the contigues min n - B ele  
//and subtract with total number of ele=> total - minOf (n - ele)  
  
public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
       int totalSum = 0;
       for(int i = 0; i < A.size(); i++){  //calculate the total sum
           totalSum += A.get(i);
       }

       int min = 0, k = A.size() - B;
       for(int i = 0; i < k; i++){  // sum up to n - B
           min += A.get(i);
       }
       int s = 0;
       int temp = min;
       for(int i = k; i < A.size(); i++){   //find min of n - B
           temp = temp - A.get(s) + A.get(i); 
           min = Math.min(min, temp);
           s++;
       }

      return totalSum - min;  //max sum of B eles

    }
}



