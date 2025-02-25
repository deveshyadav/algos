
package recursion.BST;

import java.util.*;

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

     static void inorderTraversal(BinaryTreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.value + " ");
            inorderTraversal(root.right);
        }
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


    static BinaryTreeNode delete_from_bst(BinaryTreeNode root, ArrayList<Integer> values_to_be_deleted) {


        for(Integer i:values_to_be_deleted){

            //System.out.println("root this-" + root.value);

            //System.out.println("deleting this-"+i);

            root = delete_node_from_bst(root, i);
            //inorderTraversal(root);

        }

        return root;
    }

    static BinaryTreeNode delete_node_from_bst(BinaryTreeNode root, Integer value) {

        BinaryTreeNode parent = null;
        BinaryTreeNode current = root;

        //System.out.println("while executes for root:"+(root!=null?root.value:null)+ "and value:"+value);

        // 1️⃣ Find the node and its parent
        while (current != null && !current.value.equals(value)) {
            // System.out.println("current in while start:" + (current !=null ? + current.value : null) + " value:" +value);
            // System.out.println("check current.value != value: " + (current.value != value) );
            parent = current;
            if (value < current.value && current.left !=null) {
                current = current.left;
            } else if(current.right!=null){
                current = current.right;
            }
            else current = null;
            //System.out.println("current in while end:" + (current !=null ? + current.value : null)+ " value:" +value);
        }

        // System.out.println("current this:" + (current !=null ? + current.value : null));


        if(current == null ) return root;

        if(current.left == null && current.right == null){
            //System.out.println("->first if");
            if (current == root) return null; // If deleting the root node
            if (parent.left == current) parent.left = null;
            else parent.right = null;
        }

        else if (current.left == null || current.right == null) {

            BinaryTreeNode child = (current.left != null) ? current.left : current.right;
            if (current == root) return child; // If deleting root
            if (parent.left == current) parent.left = child;
            else parent.right = child;
        }
        else
        {

            BinaryTreeNode successor = findMin(current.right);
            current.value = successor.value; // ✅ Replace node value with successor's value
            current.right = delete_node_from_bst(current.right, successor.value); // ✅ Delete successor from right subtree


        }

        return root;
    }

    private static BinaryTreeNode findMin(BinaryTreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    static ArrayList<ArrayList<Integer>> levelOfTraversal(BinaryTreeNode node){
        Queue<BinaryTreeNode> qq = new LinkedList<>();
        qq.offer(node);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if(node == null){
            return res;
        }

        while(!qq.isEmpty()) {
            int len = qq.size();
            List<Integer> currentLevel = new ArrayList<>();

            for(int i=0;i<len;i++){
                BinaryTreeNode current = qq.poll();
                currentLevel.add(current.value);
                if(current.left !=null) qq.offer(current.left);
                if(current.right !=null) qq.offer(current.right);
            }
            res.add(new ArrayList<>(currentLevel));
        }
        return res;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = null;

        // Insert nodes into BST
        List<Integer> keys = Arrays.asList(120, 100, 200,1000000000, 3, 89, 5433);
        for (int key : keys) {
            root = BST.insert_node_in_bst(root, key);
        }

        System.out.println("Inorder before deletion:");
        ArrayList<ArrayList<Integer>> res = BST.levelOfTraversal(root);
        System.out.println(res);
        for (ArrayList<Integer> level : res) {
            System.out.println(String.join(" ", level.stream().map(String::valueOf).toList())); // Java 16+
        }


        System.out.println();

        // Delete node 50 (root)
        //,//root = BST.delete_from_bst(root, new ArrayList<>(List.of(50)));

        System.out.println("Inorder after deleting 50:");
        //BST.inorderTraversal(root);
        System.out.println();
    }



}

