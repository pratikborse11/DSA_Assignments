package PriorityQueue_10;

/*
Q4. You are given an m x n matrix mat that has its rows sorted in non-decreasing order and an integer k.
You are allowed to choose exactly one element from each row to form an array.
Return the kth smallest array sum among all possible arrays.
Example 1:
Input: mat = [[1,3,11],[2,4,6]], k = 5
Output: 7
Explanation: Choosing one element from each row, the first k smallest sum are:
[1,2], [1,4], [3,2], [3,4], [1,6]. Where the 5th sum is 7.
Example 2:
Input: mat = [[1,3,11],[2,4,6]], k = 9
Output: 17
Example 3:
Input: mat = [[1,10,10],[1,4,5],[2,3,6]], k = 7
Output: 9
Explanation: Choosing one element from each row, the first k smallest sum are:
[1,1,2], [1,1,3], [1,4,2], [1,4,3], [1,1,6], [1,5,2], [1,5,3]. Where the 7th sum is 9.

Approach :
T Calculate max priority queue of size k for the first rowk
T Add the rest rows one by one to the max priority queue and make sure that max priority queue size is less
than or equal to k.
 */

import java.util.*;
public class Q4 {
    public static int kthSmallest(int[][] mat, int k) {
        int col = Math.min(mat[0].length, k);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        for (int[] row : mat) {
            // max priority queue for the i-th row
            PriorityQueue<Integer> nextPq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i : pq) {
                for (int c = 0; c < col; c++) {
                    nextPq.add(i + row[c]);
                    // keep pq size <= k
                    if (nextPq.size() > k) {
                        nextPq.poll();
                    }
                }
            }
            pq = nextPq;
        }
        return pq.poll();
    }
    public static void main(String[] args){
        int [][]input = {{1,3,11} , {2,4,6}};
        int k = 5;

        System.out.println("The desired output is : " + kthSmallest(input , k));
    }
}
