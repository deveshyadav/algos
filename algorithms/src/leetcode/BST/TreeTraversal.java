package leetcode.BST;

import java.util.Arrays;
import java.util.List;

public class TreeTraversal {
    static class BinaryTreeNode {
        Integer value;
        BST.BinaryTreeNode left;
        BST.BinaryTreeNode right;

        BinaryTreeNode(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        BST.BinaryTreeNode root = new BST.BinaryTreeNode(2);
        List<Integer> keys = Arrays.asList(120, 100, 200,1000000000, 3, 89, 5433);
        for (int key : keys) {
            root = BST.insert_node_in_bst(root, key);
        }
        System.out.println("inorder");
        inorder(root);
        System.out.println();
        System.out.println("preorder");
        preorder(root);
        System.out.println();
        System.out.println("postorder");
        postorder(root);
        System.out.println();
    }

    private static void inorder(BST.BinaryTreeNode root) {
        if(root == null) return;
        inorder(root.left);
        System.out.println(root.value);
        inorder(root.right);
    }

    private static void preorder(BST.BinaryTreeNode root) {
        if(root == null) return;
        System.out.println(root.value);
        preorder(root.left);
        preorder(root.right);
    }

    private static void postorder(BST.BinaryTreeNode root) {
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.value);
    }

    static BST.BinaryTreeNode insert_node_in_bst(BST.BinaryTreeNode root, Integer value) {
        if(root == null)
            return new BST.BinaryTreeNode(value);

        BST.BinaryTreeNode curr = root;

        while(curr != null) {
            if(value < curr.value){
                if(curr.left == null) {
                    curr.left = new BST.BinaryTreeNode(value);
                    break;
                }
                else curr = curr.left;
            }
            else{
                if(curr.right == null) {
                    curr.right = new BST.BinaryTreeNode(value);
                    break;
                }
                else curr = curr.right;
            }
        }
        return root;
    }
}
