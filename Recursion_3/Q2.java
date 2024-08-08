package Recursion_3;
/*
Q2: Given a number n. Find the sum of natural numbers till n but with alternate signs.
That means if n = 5 then you have to return 1-2+3-4+5 = 3 as your answer.
Constraints : 0<=n<=1e6
Input1 : n = 10
Output 1 : -5
Explanation : 1-2+3-4+5-6+7-8+9-10 = -5
Input 2 : n = 5
Output 2 : 3
 */

import java.io.*;
import java.util.*;

public class Q2
{   static int go(int n  , int i){
    if(i == n + 1)return 0;
    if(i%2 == 0)return go(n , i + 1) - i;
    else return go(n , i + 1) + i;
}
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(go(n,1));
    }
}
