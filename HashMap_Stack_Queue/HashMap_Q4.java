package HashMap_Stack_Queue;

/*
Q4. Given an array nums of size n, return the majority element.
Input: 4,2,7,1,9
Output: 9
 */

import java.util.Scanner;
import java.util.TreeMap;

public class HashMap_Q4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of elements in an array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i],1);
        }

        System.out.println("The Largest element is : " + map.lastEntry().getKey());
    }
}
