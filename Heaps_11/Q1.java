package Heaps_11;

/*
Q1. Given an integer array, find the kth largest element using priority queue.
Input 1 : arr[] = {1,2,3,5,2,6,9} k = 3
Output 1: 5
Input 2 : arr[] = {1,7,8,5,2,6,9} k = 6
Output 2: 2

Approach :
Method 1 :  Using maxheapE
 Insert all elements into a maxheap.
 Remove first (k-1) elements9
 The element at the top of the heap is the kth largest element.
Time complexity : O(nlogn) where n is the number of elements in the array.
Space complexity : O(n) because n elements are inserted in the heap9
Method 2 :  Using minheae
 Insert first k elements into a minheap9
 for remaining (n-k) elements if the ith element is greater than the top element of the queue, remove it
  from the top and insert this current element into the queue9
 Since the element at the top will never be considered in k largest elements until another element greater
  than this peek element is outside the queue9
 If the ith element is lesser then do nothing and move to the next iteration9
 repeat this process until all the elements are traversed9
 This way the kth largest element will be at the top of the queue in the end.
Time complexity : O(nlogk)
Space complexity : O(k) because in the worst case queue will be only holding k elements.
 */


                           // *** METHOD - 1 ***
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Q1{
    // Function to find the k'th largest element in an array using max-heap
    public static int findKthLargest(List<Integer> ints, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        // or pass `Comparator.reverseOrder()`
        pq.addAll(ints);

        // pop from max-heap exactly `k-1` times
        while (--k > 0) {
            pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args){
        List<Integer> ints = Arrays.asList(7, 4, 6, 3, 9, 1);
        int k = 2;
        System.out.println("k'th largest array element is " + findKthLargest(ints, k));
    }
}


                                     // *** METHOD - 2 ***
/*
import java.util.Arrays;
        import java.util.List;
        import java.util.PriorityQueue;

public class Q1{
    public static int findKthLargest(List<Integer> ints, int k){
        // create a min-heap using the `PriorityQueue` class and insert the first `k` array elements into the heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(ints.subList(0, k));

        for (int i = k; i < ints.size(); i++){
            // if the current element is more than the root of the heap
            if (ints.get(i) > pq.peek()){
                // replace root with the current element
                pq.poll();
                pq.add(ints.get(i));
            }
        }
        return pq.peek();
    }

    public static void main(String[] args){
        List<Integer> ints = Arrays.asList(7, 4, 6, 3, 9, 1);
        int k = 2;

        System.out.println("k'th largest array element is " + findKthLargest(ints, k));
    }
}
*/
