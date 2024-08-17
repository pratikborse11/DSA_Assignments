package GreedyAlgo_8;
/*
Q5. Given an array of intervals where intervals[i] = [starti, endi], return the minimum number of
intervals you need to remove to make the rest of the intervals non-overlapping.

Example 1:
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.

Example 2:
Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.

Example 3:
Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
*/


import java.io.*;
import java.lang.*;
import java.util.*;

class Solution5 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int[] curr = new int[] {intervals[0][0], intervals[0][1]};
        int maxCap = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < curr[1]) continue;
            curr[0] = intervals[i][0];
            curr[1] = intervals[i][1];
            maxCap++;
        }
        return intervals.length - maxCap;
    }
    public static void main(String[] args){
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        int n = 1;
        System.out.println("The desired output is :  " + eraseOverlapIntervals(intervals));
    }
}
