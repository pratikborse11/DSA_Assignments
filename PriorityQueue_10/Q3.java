package PriorityQueue_10;

/*
Q3. You are playing a solitaire game with three piles of stones of sizes a​, b,​ and c​ respectively. Each turn you
choose two different non-empty piles, take one stone from each, and add 1 point to your score. The game
stops when there are fewer than two non-empty piles (meaning there are no more available moves).
Given three integers a​, b,​ and c​, return the maximum score you can get.
Example 1:
Input: a = 2, b = 4, c = 6
Output: 6
Explanation: The starting state is (2, 4, 6). One optimal set of moves is:
- Take from 1st and 3rd piles, state is now (1, 4, 5)
- Take from 1st and 3rd piles, state is now (0, 4, 4)
- Take from 2nd and 3rd piles, state is now (0, 3, 3)
- Take from 2nd and 3rd piles, state is now (0, 2, 2)
Take from 2nd and 3rd piles, state is now (0, 1, 1)
- Take from 2nd and 3rd piles, state is now (0, 0, 0)
There are fewer than two non-empty piles, so the game ends. Total: 6 points.
Example 2:
Input: a = 4, b = 4, c = 6
Output: 7
Explanation: The starting state is (4, 4, 6). One optimal set of moves is:
- Take from 1st and 2nd piles, state is now (3, 3, 6)
- Take from 1st and 3rd piles, state is now (2, 3, 5)
- Take from 1st and 3rd piles, state is now (1, 3, 4)
- Take from 1st and 3rd piles, state is now (0, 3, 3)
- Take from 2nd and 3rd piles, state is now (0, 2, 2)
- Take from 2nd and 3rd piles, state is now (0, 1, 1)
- Take from 2nd and 3rd piles, state is now (0, 0, 0)
There are fewer than two non-empty piles, so the game ends. Total: 7 points.

Approach :
; The idea is to get the two stones with maximum value and decrease the two stones value by 1.
; We do this until we don’t find two non zero valued stones.
 */

import java.util.*;
public class Q3 {
    public static int maximumScore(int a, int b, int c) {
        //maxheap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a1, b1) -> (b1 - a1));

        //store in maxHeap
        maxHeap.add(a);
        maxHeap.add(b);
        maxHeap.add(c);

        int score = 0;
        while(maxHeap.size() > 1){
            //find first two max number
            int maxNum1 = maxHeap.remove();
            int maxNum2 = maxHeap.remove();

            //decrement both
            maxNum1--;
            maxNum2--;

            //only add in heap, if greater than 0
            if(maxNum1 > 0) maxHeap.add(maxNum1);
            if(maxNum2 > 0) maxHeap.add(maxNum2);

            //increase score
            score++;
        }

        return score;
    }
    public static void main(String[] args){
        int a = 5 , b = 4 , c = 7;
        System.out.println("The desired output is : " + maximumScore(a,b,c));
    }
}
