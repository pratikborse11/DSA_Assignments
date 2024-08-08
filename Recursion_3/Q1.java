package Recursion_3;
/*
Q1 : Given an integer, find out the sum of its digits using recursion.
Input: n= 1234
Output: 10
Explanation: 1+2+3+4=10
 */

import java.io.*;
import java.util.*;

public class Q1
{   static int func(int n)
{
    if (n == 0)
        return 0;
    return (n % 10 + func(n / 10));
}
    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int ans = func(n);
        System.out.println(" Sum of digits in " + n
                + " is " + ans );
    }
}



