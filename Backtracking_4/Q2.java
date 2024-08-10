package Backtracking_4;
/*
Q2. Given an integer array arr, print all the possible permutations of the given array.
Note : The array will only contain non repeating elements.
Input 1 : arr = [1, 2, 3]
Output1 : [[1,2,3] , [1,3,2] , [2,1,3] , [2,3,1] , [3,1,2] , [3,2,1]]
*/

import java.util.*;
import java.util.Scanner;
public class Q2{

    public static void permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return;
        }

        permutationsHelper(result, nums, 0);

        for(List<Integer> list : result){
            for(Integer item : list){
                System.out.print(item + "  ");
            }
            System.out.println("");
        }
    }

    private static void permutationsHelper(List<List<Integer>> result, int[] nums, int start) {
        if (start == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) {
                list.add(n);
            }
            result.add(list);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            permutationsHelper(result, nums, start + 1);
            swap(nums, start, i);
        }
    }

    private static void swap(int[] nums, int x, int y) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }
    public static void main(String[] args){
        int []arr = {1 , 2 , 3};
        System.out.println("The possible permutations are : ");
        permute(arr);
    }
}