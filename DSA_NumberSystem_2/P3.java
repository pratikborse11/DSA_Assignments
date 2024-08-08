package DSA_NumberSystem_2;
/*
Q3. Problem 1: Given a number. Using bit manipulation, check whether it is odd or even.
        Input 8, Even
        3, False
*/

import java.util.Scanner;

public class P3
{
    public static void main(String[] args) {
        int number;
        System.out.println("Enter the integer: ");

        // Create Scanner object
        Scanner s = new Scanner(System.in);

        // Read the next integer from the screen
        number = s.nextInt();

        if((number & 1) == 1) System.out.println("Given number is odd.");
        else  System.out.println("Given number is even.");
    }
}
