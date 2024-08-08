package SortingArray_2;
/*
Q1. Write a program to sort an array in descending order using bubble sort.
        Input Array {3,5,1,6,0}
        Output Array: {6, 5, 3, 1, 0}
 */

import java.util.*;
public class Q1 {
    // 0 based indexing used
    public static void bubbleSort(int[] a) {
        int n = a.length;

        for (int i = 0; i < n; i++) {
            boolean flag = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] < a[j + 1]) {
                    flag = true;
                    // swap the values of a[j] and a[j+1]
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            // No Swapping happened, array is sorted
            if (!flag) {
                return;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        bubbleSort(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
