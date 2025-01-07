package Tree_9;
/*
Q5. Given the root of a binary tree, convert the binary tree into its mirror and print it’s pre order

soln:
The idea is simple – traverse the tree in a postorder fashion, and for every node, swap its left and right child
pointer after recursively converting its left and right subtree to mirror first.
 */

// A class to store a binary tree node
class Node4
{
    int data;
    Node4 left = null, right = null;

    Node4(int data) {
        this.data = data;
    }
}

public class Q5
{
    // Function to perform preorder traversal on a given binary tree
    public static void preorder(Node root)
    {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Utility function to swap left subtree with right subtree
    public static void swap(Node root)
    {
        if (root == null) {
            return;
        }

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    // Function to convert a given binary tree into its mirror
    public static void convertToMirror(Node root)
    {
        // base case: if the tree is empty
        if (root == null) {
            return;
        }

        // convert left subtree
        convertToMirror(root.left);

        // convert right subtree
        convertToMirror(root.right);

        // swap left subtree with right subtree
        swap(root);
    }

    public static void main(String[] args)
    {
        /* Construct the following tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            4   5   6   7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        convertToMirror(root);
        preorder(root);
    }
}