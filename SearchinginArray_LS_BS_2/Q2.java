package SearchinginArray_LS_BS_2;
/*
Q2. Given an array and an integer “target”, return the last occurrence of “target” in the array. If the target is
not present return -1.
Input 1: arr = [1 1 1 2 3 4 4 5 6 6 6 6] , target = 4
Output 1: 6
Input 2: arr = [2 2 2 6 6 18 29 30 30 30] , target = 15
Output 2: -1
 */

import java.util.*;

public class Q2 {
    public static int lastOccurrence(int[] nums, int low, int high  , int target){
        int answer = -1;
        while(low <= high){
            int mid = low + (high  - low)/2;

            if(nums[mid] == target){
                answer = mid;
                low = mid + 1;  //if you found the target or if target is greater than the current element, to find last occurrence move to right half of the array
            }
            else if(nums[mid] > target){
                high  = mid - 1;
            }
            else low = mid + 1;
        }
        return answer;
    }

    public static void main(String args[]){

        int m;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of elements you want to add : ");
        m=sc.nextInt();

        int []arr = new int[m];

        System.out.print("Enter the elements of the array: ");

        for(int i=0;i<m;i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the target : ");

        int target;
        Scanner s1 = new Scanner(System.in);
        target = s1.nextInt();

        System.out.println("The last occurrence of target is at index : " + lastOccurrence(arr , 0 , m - 1 , target));
    }
}
