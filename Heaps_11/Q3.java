package Heaps_11;

/*
Q3. Given an array of string ‘words’ and an integer k, return the k most frequent strings. Return the answer
sorted by the frequency from highest to lowest. Sort the words with the same frequency by their
lexicographical order.
Example 1:
Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrences
being 4, 3, 2 and 1 respectively.

Approach :
 1. The idea is to keep a count of each word in a HashMap and then insert in a Priority Queueg
 2. While inserting in pq, if the count of two words is the same then insert them based on string comparison of
    the keys.
 */


import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.*;

public class Q3{
    public static void topKFrequent(String[] words, int k) {

        List<String> result = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<words.length; i++){
            if(map.containsKey(words[i]))
                map.put(words[i], map.get(words[i])+1);
            else
                map.put(words[i], 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );

        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            pq.offer(entry);
            if(pq.size()>k)
                pq.poll();
        }

        while(!pq.isEmpty()) result.add(0, pq.poll().getKey());

        for(String res : result){
            System.out.print(res + "  ");
        }
    }
    public static void main(String[] args){
        String[] input = { "PW" , "PWskills" , "PhysicsWallah" , "PW" , "PhysicsWallah" , "PWJAVA" , "Code" };
        topKFrequent(input , 3);
    }
}
