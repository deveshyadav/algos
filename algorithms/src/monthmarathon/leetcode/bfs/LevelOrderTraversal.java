package monthmarathon.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class LevelOrderTraversal {

    public static void main(String[] args) {
        // Create a sample tree:
        //        1
        //      /   \
        //     2     3
        //    / \   / \
        //   4   5 6   7
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        LevelOrderTraversal lot = new LevelOrderTraversal();
        lot.printLevel(root);
    }

    public void printLevel(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> currentLevel = new LinkedList<>();
        Queue<Node> nextLevel = new LinkedList<>();
        currentLevel.add(root);

        while (!currentLevel.isEmpty() ) { // ✅ Fixed condition
            while (!currentLevel.isEmpty()) {
                Node tmp = currentLevel.remove();
                System.out.print(tmp.data + " ");

                if (tmp.left != null) {
                    nextLevel.add(tmp.left);
                }
                if (tmp.right != null) {
                    nextLevel.add(tmp.right);
                }
            }
            System.out.println(); // Move to next level
            Queue<Node> temp = currentLevel;
            currentLevel = nextLevel;
            nextLevel = temp;
        }
    }
}
