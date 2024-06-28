package HashMap_Stack_Queue;

import java.util.Scanner;
import java.util.TreeMap;

/*
Q2. Implement a Map in java which takes the input and print the list in sorted order based on value.
Input: 5- Rahul, 7 Lakshman, 1 Ram, 4 Krrish, 2 Lakshay
Output: {Krish=4,Lakshay=2,Lakshman=7,Rahul=5,Ram=1}
 */
public class HashMap_Q2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of key-value pairs : ");
        int n = sc.nextInt();

        TreeMap<String, Integer> map = new TreeMap<>();

        System.out.println("Enter the key-value pairs : ");
        for (int i=0; i<n; i++) {
            int key = sc.nextInt();
            String value = sc.next();
            map.put(value,key);
        }

        System.out.println("The map is : " + map);
    }
}



