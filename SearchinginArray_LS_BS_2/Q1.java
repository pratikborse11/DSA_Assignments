package SearchinginArray_LS_BS_2;
/*
Q1. Given an array. FInd the number X in the array. If the element is present, return the index of the element,
else print “Element not found in array”. Input the size of array, array from user and the element X from user.
Use Linear Search to find the element.
Example 1:
Enter the number of elements you want to add : 5
Enter the elements of the array: 6
2
3
1
7
Enter the elements to be searched in array2
1
Example 2
Enter the number of elements you want to add: 5
Enter the elements of the array: 6
2
3
1
7
Enter the elements to be searched in array5
Element not found in array
 */
import java.util.*;

public class Q1 {
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

        int element;
        System.out.print("Enter the elements to be searched in array: ");
        element = sc.nextInt();


        int idx = -1;
        for(int i=0;i<m;i++){
            if(arr[i]==element){
                idx = i;
                break;
            }
        }

        if(idx!=-1){
            System.out.println(idx);
        }
        else{
            System.out.println("Element not found in array");
        }
    }
}
