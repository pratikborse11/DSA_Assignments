package HashMap_Stack_Queue;

/*
Q3.Detect if an Array contains a duplicate element. At Most 1 duplicate would be there.
Input: 1,2,3,4
Output: No
Input: 1, 2, 3, 4, 1
Output: Yes.
 */

import java.util.HashMap;
import java.util.Scanner;

public class HashMap_Q3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of elements in an array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements: ");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        boolean duplicate = false;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])){
                duplicate = true;
                System.out.println("Yes");
                break;
            }
            map.put(arr[i],1);
        }

        if (duplicate == false) {
            System.out.println("No");
        }
    }
}
