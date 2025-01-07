package Tree_9;
/*
Q4. Given the root of a binary tree, return the left view of its nodes' values. Assume the left and
right child of a node makes a 45–degree angle with the parent.

soln:
We can also solve this problem by using hashing. The idea is to traverse the tree in a preorder fashion and pass
level information in function arguments. If the level is visited for the first time, insert the current node and level
information into the map. Finally, when all nodes are processed, traverse the map and print the left view.
Time Complexity: O(N) as we are visiting every node once.
 */

import java.util.HashMap;
import java.util.Map;

// A class to store a binary tree node
class Node3
{
    int key;
    Node3 left = null, right = null;

    Node3(int key) {
        this.key = key;
    }
}

public class Q4
{
    // Recursive function to traverse the nodes in a preorder fashion
    public static void leftView(Node root, int level, Map<Integer, Integer> map)
    {
        // base case
        if (root == null) {
            return;
        }

        // if the level is visited for the first time, insert the current node
        // and level information into the map
        map.putIfAbsent(level, root.key);

        leftView(root.left, level + 1, map);
        leftView(root.right, level + 1, map);
    }

    // Function to print the left view of a given binary tree
    public static void leftView(Node root)
    {
        // create an empty HashMap to store the first node for each level
        Map<Integer, Integer> map = new HashMap<>();

        // traverse the tree and fill the map
        leftView(root, 1, map);

        // iterate through the HashMap in sorted order of its keys
        // and print the left view
        for (int i = 1; i <= map.size(); i++) {
            System.out.print(map.get(i) + " ");
        }
    }

    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        leftView(root);
    }
}