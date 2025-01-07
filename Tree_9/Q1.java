package Tree_9;
/*
Q1. Given the root of a binary tree, return the spiral level order traversal of its nodes' values. The
solution should consider the binary tree nodes level by level in spiral order, i.e., all nodes present
at level 1 should be processed first from left to right, followed by nodes of level 2 from right to left,
followed by nodes of level 3 from left to right and so on... In other words, odd levels should be
processed from left to right, and even levels should be processed from right to left.

Approach:
A simple solution is to print all nodes of level 1 first, followed by level 2, ... till level h, where h is the tree’s height.
We can print all nodes present in a level by modifying the preorder traversal on the tree.
We will keep on iterating at each level, starting from level 1. If the level is odd we will print left to right, else we will
print right to left.
Time Complexity: O(N) as we are visiting every node once.
 */

class Node
{
    public boolean data;
    int key;
    Node left = null, right = null;

    Node(int data) {
        this.key = data;
    }
}

public class Q1 {
    // Function to print all nodes of a given level from left to right
    public static boolean printLevelLeftToRight(Node root, int level)
    {
        if (root == null) {
            return false;
        }

        if (level == 1)
        {
            System.out.print(root.key + " ");
            return true;
        }

        // process left child before the right child
        boolean left = printLevelLeftToRight(root.left, level - 1);
        boolean right = printLevelLeftToRight(root.right, level - 1);

        return left || right;
    }

    // Function to print all nodes of a given level from right to left
    public static boolean printLevelRightToLeft(Node root, int level)
    {
        if (root == null) {
            return false;
        }

        if (level == 1)
        {
            System.out.print(root.key + " ");
            return true;
        }

        // process right child before the left child
        boolean right = printLevelRightToLeft(root.right, level - 1);
        boolean left = printLevelRightToLeft(root.left, level - 1);

        return right || left;
    }

    // Function to print level order traversal of a given binary tree
    public static void spiralOrderTraversal(Node root)
    {
        if (root == null) {
            return;
        }

        // start from level 1 — till the height of the tree
        int level = 1;

        // run till either function returns false
        while (printLevelLeftToRight(root, level++) &&
                printLevelRightToLeft(root, level++));
    }

    public static void main(String[] args)
    {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);

        spiralOrderTraversal(root);
    }
}
