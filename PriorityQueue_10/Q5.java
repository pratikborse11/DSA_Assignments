package PriorityQueue_10;

/*
Q5. Given that integers are read from a data stream. Find the median of elements read so for in an efficient
way. For simplicity assume, there are no duplicates. For example, let us consider the streams 5, 15, 1, 3 ...
After reading 1st element of stream - 5 -> median - 5
After reading 2nd element of stream - 5, 15 -> median - 10
After reading 3rd element of stream - 5, 15, 1 -> median - 5
After reading the 4th element of stream - 5, 15, 1, 3 -> median - 4, so on.

Approach :
T The basic idea is to maintain two heaps: a max-heap and a min-heap. The max heap stores the smaller
half of all numbers while the min heap stores the larger halfk
T The sizes of two heaps need to be balanced each time when a new number is inserted so that their size will
not be different by more than 1k
T Therefore each time when findMedian() is called we check if two heaps have the same size.
T If they do, we should return the average of the two top values of heaps. Otherwise we return the top of the
heap which has one more elementk
T There are several possible situations when a new number is inserted:
1)If both heaps are empty, meaning that we are inserting the first number, we just arbitrarily inserted it into a
heap, let's say, the min-heap.
2)If the min-heap has more elements (later we will argue that the size won't be different by more than 1), we
need to compare the new number with the top of the min-heap. If it is larger than that, then the new number
belongs to the larger half and it should be added to the min-heap. But since we have to balance the heap,
we should move the top element of the min-heap to the max-heap. For the min-heap, we inserted a new
number but removed the original top, its size won't change. For the max-heap, we inserted a new element (the
top of the min-heap) so its size will increase by 1.
3)If max-heap has more elements, we did the similar thing as 2).
4)If they have the same size, we just compare the new number with one of the top to determine which heap
the new number should be inserted. We just simply inserted it thereE
2 It can be seen that for each insertion if it was in situation 1) and 4), then after insertion the heap size
difference will be 1. For 2) and 3), the size of the heap with fewer elements will increase by 1 to catch up with
the heap with more elements. Hence their sizes are well-balanced and the difference will never exceed 1E
2 Obviously, the median will be the top element of the heap which has one more element (if max-heap and
min-heap have different sizes), or the average of the two tops (if max-heap and min-heap have equal
sizes).
 */

import java.io.*;
import java.util.*;
public class Q5 {
    private static Queue<Integer> minHeap, maxHeap;

    static void add(int num) {
        if (!minHeap.isEmpty() && num < minHeap.peek()) {
            maxHeap.offer(num);
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            }
        } else {
            minHeap.offer(num);
            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.offer(minHeap.poll());
            }
        }
    }

    static double getMedian() {
        int median;
        if (minHeap.size() < maxHeap.size()) {
            median = maxHeap.peek();
        } else if (minHeap.size() > maxHeap.size()) {
            median = minHeap.peek();
        } else {
            median = (minHeap.peek() + maxHeap.peek()) / 2;
        }
        return median;
    }

    static void initialize(){
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        Q5 obj = new Q5();

        obj.add(3);
        System.out.println("The median is : " + getMedian());
        obj.add(3);
        obj.add(2);
        obj.add(5);
        System.out.println("The median is : " + getMedian());
        obj.add(7);
        obj.add(12);
        System.out.println("The median is : " + getMedian());
    }

    public static void main(String[] args){
        initialize();
    }
}
