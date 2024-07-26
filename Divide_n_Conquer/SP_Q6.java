package Divide_n_Conquer;
/*
Q1. Given an integer array, find the kth largest element using the quickselect algorithm.
Input1: arr[] = {1,3,2,4,5,6,7} , k = 3
Output 1: output 1 : 5

Input 2: arr[] = {4,3,3,2,1} , k = 4
Output 2: 2
 */
import java.util.*;

public class SP_Q6 {
    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length-1, nums.length-k);
    }

    private static int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left];

        int pIndex = new Random().nextInt(right - left + 1) + left;
        pIndex = partition(nums, left, right, pIndex);

        if (pIndex == k) return nums[k];
        else if (pIndex < k) return quickSelect(nums, pIndex+1, right, k);
        return quickSelect(nums, left, pIndex-1, k);
    }

    private static int partition(int[] nums, int left, int right, int pIndex) {
        int pivot = nums[pIndex];
        swap(nums, pIndex, right);
        pIndex = left;

        for (int i=left; i<=right; i++)
            if (nums[i] <= pivot)
                swap(nums, i, pIndex++);

        return pIndex - 1;
    }

    private static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    public static void main(String[] args) {
        int[] array = new int[] { 10, 4, 5, 8, 6, 11, 26 };

        int kPosition = 3;
        int length = array.length;

        if (kPosition > length) {
            System.out.println("Index out of bound");
        }
        else {
            System.out.println("K-th largest element in array : "+ findKthLargest(array, kPosition));
        }
    }
}
