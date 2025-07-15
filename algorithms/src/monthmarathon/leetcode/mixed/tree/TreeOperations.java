package monthmarathon.leetcode.mixed.tree;

public class TreeOperations {
    public static void main(String[] args) {
        Node n4 = new Node(4, null, null);
        Node n5 = new Node(5, null, null);
        Node n6 = new Node(6, null, null);
        Node n2 = new Node(2, n4, n5);
        Node n3 = new Node(3, null, n6);
        Node root = new Node(1, n2, n3);

        System.out.println("Inorder traversal");
        inorder1(root);
        System.out.println("Preorder traversal");
        preorder1(root);
        System.out.println("Postorder traversal");
        postorder1(root);

    }

    private static void postorder1(Node root) {
        if(root==null) return;
        Node left = root.left;
        Node right = root.right;
        postorder1(left);
        postorder1(right);
        System.out.println("->" + root.val);
    }

    private static void preorder1(Node root) {
        if(root==null) return;
        Node left = root.left;
        Node right = root.right;
        System.out.println("->" + root.val);
        preorder1(left);
        preorder1(right);
    }

    private static void inorder1(Node root) {
        if(root==null) return;
        Node left = root.left;
        Node right = root.right;
        inorder1(left);
        System.out.println("->" + root.val);
        inorder1(right);
    }

    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val, Node left,Node right){
            this.left=left;
            this.right=right;
            this.val=val;
        }
    }
}
