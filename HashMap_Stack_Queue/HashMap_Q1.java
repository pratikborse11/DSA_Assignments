package HashMap_Stack_Queue;
/*
Q1. Implement a Map in java which takes the input and print the list in sorted order based on key.
Input: 5- Rahul, 7 Lakshman, 1 Ram, 4 Krrish, 2 Lakshay
Output: {1=Ram, 2=Lakshay, 4=Krrish, 5=Rahul, 7=lakshman}
 */

import java.util.Scanner;
import java.util.TreeMap;

public class HashMap_Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of key-value pairs: ");
        int n = sc.nextInt();

        TreeMap<Integer,String> map = new TreeMap<>();
        System.out.println("Enter the key value pairs: ");
        for (int i=0; i<n; i++) {
            int key = sc.nextInt();
            String value = sc.next();
            map.put(key,value);
        }

        System.out.println("The map is: " + map);
    }
}
