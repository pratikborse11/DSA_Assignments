package GreedyAlgo_8;
/*
Q1. Find the minimum sum of Products of two arrays of the same size, given that k modifications
are allowed on the first array. In each modification, one array element of the first array can either
be increased or decreased by 2.
Examples:
Input: a[] = {1, 2, -3}
       b[] = {-2, 3, -5}
       k = 5
Output: -31
Explanation:
Here n = 3 and k = 5.
So, we modified a[2], which is -3 and
increased it by 10 (as 5 modifications
are allowed).
Final sum will be :
(1 * -2) + (2 * 3) + (7 * -5)
-2 + 6 - 35
-31
(which is the minimum sum of the array
with given conditions)

Input: a[] = {2, 3, 4, 5, 4}
       b[] = {3, 4, 2, 3, 2}
       k = 3
Output: 25
Explanation:
Here, total numbers are 5 and total
modifications allowed are 3. So, modify
a[1], which is 3 and decreased it by 6
(as 3 modifications are allowed).
Final sum will be :
(2 * 3) + (-3 * 4) + (4 * 2) + (5 * 3) + (4 * 2)
6 – 12 + 8 + 15 + 8
25
(which is the minimum sum of the array with given conditions)
 */


import java.math.*;

class Solution {
    static int minproduct(int a[], int b[], int n, int k){
        int diff = 0, res = 0;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            int pro = a[i] * b[i];
            res = res + pro;
            if (pro < 0 && b[i] < 0)
                temp = (a[i] + 2 * k) * b[i];

            else if (pro < 0 && a[i] < 0)temp = (a[i] - 2 * k) * b[i];
            else if (pro > 0 && a[i] < 0)temp = (a[i] + 2 * k) * b[i];
            else if (pro > 0 && a[i] > 0)temp = (a[i] - 2 * k) * b[i];

            int d = Math.abs(pro - temp);
            if (d > diff)diff = d;
        }

        return res - diff;
    }

    public static void main(String[] args){
        int a[] = { 2, -3, 4, 6, 9 };
        int b[] = { 1, 4, -2, -3, 7 };
        int n = 5, k = 3;
        System.out.println(minproduct(a, b, n, k));
    }
}
