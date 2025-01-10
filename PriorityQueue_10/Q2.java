package PriorityQueue_10;

/*
Q2. You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
Define a pair (u, v) which consists of one element from the first array and one element from the second
array.
Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
Example 1:
Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:
Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [[1,1],[1,1]]
Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:
Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [[1,3],[2,3]]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]

Approach :v
N Use min_heap to keep track of the next minimum pair sum, and we only need to maintain K possible
candidates in the data structure<
N For every number in nums1, its best partner(yields min sum) always starts from nums2[0] since arrays are
all sorted<
N And for a specific number in nums1, its next candidate should be [this specific number] +
nums2[current_associated_index + 1], unless out of boundary<
N Here is a simple example demonstrating how this algorithm works.
 */

import java.util.*;
public class Q2 {
    public static void kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
        List<int[]> res = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0) return ;
        for(int i=0; i<nums1.length && i<k; i++) que.offer(new int[]{nums1[i], nums2[0], 0});
        while(k-- > 0 && !que.isEmpty()){
            int[] cur = que.poll();
            res.add(new int[]{cur[0], cur[1]});
            if(cur[2] == nums2.length-1) continue;
            que.offer(new int[]{cur[0],nums2[cur[2]+1], cur[2]+1});
        }
        for(int[] a : res){
            for(int b : a){
                System.out.printf(b + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int nums1[] = {1,2,5,6,8};
        int nums2[] = {4,5,16};

        int k = 4;
        System.out.println("The desired output is : ");
        kSmallestPairs(nums1 , nums2 , k);
    }
}
