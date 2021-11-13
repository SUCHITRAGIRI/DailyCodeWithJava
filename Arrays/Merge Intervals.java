//https://leetcode.com/problems/merge-intervals/

// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

//  Example 1:

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// Example 2:

// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

// Constraints:

// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104
  
//Time complexity: O(M * N)  
class Solution {
    public int[][] merge(int[][] intervals) {
       
        int m = intervals.length;
        int n = intervals[0].length;
        
        List<int[]> ans = new ArrayList<>();
        int k = 0;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(intervals[i - 1][j] >= intervals[i][j - 1]){   
                    ans.add(new int[]{intervals[i - 1][j - 1], intervals[i][j]});
                    i++;
                }else{
                    ans.add(new int[]{intervals[i - 1][j - 1], intervals[i - 1][j]});
                }
            }  
        }
                
        return ans.toArray(new int[0][]);
    }
}

//https://www.interviewbit.com/problems/merge-intervals/
// Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

// You may assume that the intervals were initially sorted according to their start times.

// Example 1:

// Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

// Example 2:

// Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

// This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].


public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        Interval current = newInterval;
        int i = 0;
        while(i < intervals.size()){
            Interval in = intervals.get(i);
            if(in.end < current.start){
                i++;
            }else if(in.start > current.end){
                intervals.add(i, current);
                break;
            }else{
                current.start = Math.min(in.start, current.start);
                current.end = Math.max(in.end, current.end);
                intervals.remove(i);
            }
        }
        if(i == intervals.size()){
            intervals.add(current);
        }
        return intervals;
    }
}



