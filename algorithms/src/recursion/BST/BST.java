/*
package recursion.BST;

import java.util.ArrayList;

public class BST {

    static class BinaryTreeNode {
        Integer value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static BinaryTreeNode search_node_in_bst(BinaryTreeNode root, Integer value) {
        if(root == null)
            return null;

        BinaryTreeNode curr = root;
        if(curr.value == value)
            return curr;
        else if(value<curr.value)
            curr = curr.left;
        else
            curr = curr.right;
        return search_node_in_bst(curr,value);
    }

     static BinaryTreeNode insert_node_in_bst(BinaryTreeNode root, Integer value) {
        if(root == null)
            return new BinaryTreeNode(value);

        BinaryTreeNode curr = root;

        while(curr != null) {
            if(value < curr.value){
                if(curr.left == null) {
                    curr.left = new BinaryTreeNode(value);
                    break;
                }
                else curr = curr.left;
            }
            else{
                if(curr.right == null) {
                    curr.right = new BinaryTreeNode(value);
                    break;
                }
                else curr = curr.right;
            }
        }
        return root;
    }


    static BinaryTreeNode build_a_bst(ArrayList<Integer> values) {
        BinaryTreeNode root = null;
        for (Integer x : values) {
            root = insert_node_in_bst(root, x);
        }
        return root;
    }

    static void delete_node_from_bst(BinaryTreeNode root, Integer value) {
        BinaryTreeNode searchedNode = search_node_in_bst(root, value);
        if(searchedNode == null) {
            return;
        }
        if(searchedNode.left == null && searchedNode.right==null){
            searchedNode = null;
            return;
        }
        if(searchedNode.left == null){
            //searchedNode;
        }
    }

    static BinaryTreeNode search_node_in_bst(BinaryTreeNode root, Integer value) {
        if(root == null)
            return null;

        BinaryTreeNode curr = root;
        if(curr.value == value)
            return curr;
        else if(value<curr.value)
            curr = curr.left;
        else
            curr = curr.right;
        return search_node_in_bst(curr,value);
    }





}
*/
