package Divide_n_Conquer;
/*
Q4. Given two arrays of equal size n and an integer k. The task is to permute both arrays such
that the sum of their corresponding element is greater than or equal to k i.e a[i] + b[i] >= k. The
task is to print “Yes” if any such permutation exists, otherwise print “No”.
Input: a[] = {2, 1, 3},
       b[] = { 7, 8, 9 },
       k = 10.
Output: Yes
Input: a[] = {1, 2, 2, 1},
       b[] = { 3, 3, 3, 4 },
       k = 5.
Output: No
 */
import java.util.*;
public class DC_Q4 {
    static boolean isPossible(Integer a[], int b[], int n, int k){
        // Sort the array a[] in decreasing order.
        Arrays.sort(a, Collections.reverseOrder());

        // Sort the array b[] in increasing order.
        Arrays.sort(b);

        // Checking condition on each index.
        for (int i = 0; i < n; i++)
            if (a[i] + b[i] < k)
                return false;

        return true;
    }
    public static void main(String[] args) {
        Integer a[] = {2, 1, 3, 5, 1};
        int b[] = {7, 8, 9 , 2 , 6};
        int k = 10;
        int n = a.length;

        if (isPossible(a, b, n, k))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}
