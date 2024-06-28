package HashMap_Stack_Queue;

/*
Q5. Given an array of integers temperatures represents the daily temperatures, return an array
answer such that answer[i] is the number of days you have to wait after the ith day to get a
warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0
instead.
Example 1:
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:
Input: temperatures = [30,60,90]
Output: [1,1,0]
 */

import java.util.Stack;

public class Stack_Q5 {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int []nge = new int [n];
        for(int i=0;i<n;i++)nge[i] = 0;

        Stack<Integer>st = new Stack();

        // move from right to left
        for(int i = n-1; i>=0; --i){
            // pop until we find next greater element to the right
            // since we came from right stack will have element from right only
            // s.top() is the index of elements so we put that index inside temperatures vector to check
            while(!st.empty() && temperatures[st.peek()] <= temperatures[i])
                st.pop();

            // if stack not empty, then we have some next greater element,
            // so we take distance between next greater and current temperature
            // as we are storing indexes in the stack
            if(!st.empty())
                nge[i] = st.peek()-i; // distance between next greater and current

            // push the index of current temperature in the stack,
            // same as pushing current temperature in stack
            st.push(i);
        }
        return nge;
    }
    public static void main(String[] args) {
        int[] a = {60, 45, 34, 65, 38, 79, 80};
        System.out.println("The desired output is : ");

        int[] arr = dailyTemperatures(a);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
