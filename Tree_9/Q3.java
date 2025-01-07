package Tree_9;
/*
Q3. Given the root of a binary tree, return the reverse level order traversal of its nodes' values. The
solution should consider the binary tree nodes level by level in bottom-up order from left to right,
i.e., process all nodes of the last level first, followed by all nodes of the second last level, and so on.

soln:
A simple solution would be to print all nodes of level h first, followed by level h-1, until level 1, where h is the tree’s
height. We can print all nodes present in a level by modifying the preorder traversal on the tree. The time
complexity of this solution is O(n2), where n is the total number of nodes in the binary tree.
We can reduce the time complexity to O(n) by using extra space. Following is a pseudocode for a simple
queue-based reverse level order traversal, which requires space proportional to the maximum number of
nodes at a given depth. It can be as much as half of the total number of nodes.
levelorder(root)
q —> empty queue
s —> empty stack
q.enqueue(root)
while (not q.isEmpty())
node —> q.dequeue()
s.push(node)
if (node.right <> null)
q.enqueue(node.right)
if (node.left <> null)
q.enqueue(node.left)
while (not s.isEmpty())
node —> s.pop()
print(node)
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

// A class to store a binary tree node
class Node2
{
    int key;
    Node2 left = null, right = null;

    Node2(int key) {
        this.key = key;
    }
}

public class Q3
{
    // Function to print reverse level order traversal of a given binary tree
    public static void reverseLevelOrderTraversal(Node root)
    {
        if (root == null) {
            return;
        }

        // create an empty queue and enqueue the root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        // create a stack to reverse level order nodes
        Deque<Integer> stack = new ArrayDeque<>();

        // to store the current node
        Node curr;

        // loop till queue is empty
        while (!queue.isEmpty())
        {
            // process each node in the queue and enqueue their children
            curr = queue.poll();

            // push the current node into the stack
            stack.push(curr.key);

            // it is important to process the right node before the left node
            if (curr.right != null) {
                queue.add(curr.right);
            }

            if (curr.left != null) {
                queue.add(curr.left);
            }
        }

        // pop all nodes from the stack and print them
        while (!stack.isEmpty()) {
            System.out.print(stack.poll() + " ");
        }
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

        reverseLevelOrderTraversal(root);
    }
}