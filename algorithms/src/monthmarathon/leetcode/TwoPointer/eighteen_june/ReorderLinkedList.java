package monthmarathon.leetcode.TwoPointer.eighteen_june;

/**
 * Reorder linked list as L0 → Ln → L1 → Ln-1 → L2 → ...
 * Time: O(n), Space: O(1) — Find middle, reverse second half, merge alternately
 * Uses fast-slow pointer to split list, reverses second half in-place
 *
 * Alt: Use ArrayList to store nodes and reorder → Time: O(n), Space: O(n)
 */
public class ReorderLinkedList {

    static class ListNode {
        ListNode next;
        int data;

        ListNode(int data){
            this.data = data;
            next=null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode ListNode2 = new ListNode(2);
        ListNode ListNode3 = new ListNode(3);
        ListNode ListNode4 = new ListNode(4);
        ListNode ListNode5 = new ListNode(5);
        ListNode ListNode6 = new ListNode(6);
        ListNode ListNode7 = new ListNode(7);

        head.next = ListNode2;
        ListNode2.next = ListNode3;
        ListNode3.next = ListNode4;
        ListNode4.next = ListNode5;
        ListNode5.next = ListNode6;
        ListNode6.next = ListNode7;
        ListNode7.next = null;

        head = reorderList(head);
        ListNode current = head;
        while(current!=null){
            System.out.println(current.data);
        }


    }

    private static ListNode reorderList(ListNode head) {
        ListNode middle = findMiddle(head);
        ListNode curr1 = middle.next;
        middle.next = null;

        ListNode prev = null;
        while (curr1 != null) {
            ListNode next = curr1.next;  // Store next
            curr1.next = prev;           // Reverse pointer

            prev = curr1;                // Move prev
            curr1 = next;                // Move curr1 forward
        }

        ListNode t1 = head;
        ListNode t2 = prev; // Prev is the head of reversed second half linked list
        while(t1!=null && t2!=null){
            ListNode next1 = t1.next;
            ListNode next2 = t2.next;
            t1.next = t2;
            t2.next = next1;
            t1 = next1;
            t2 = next2;
        }

        print(head);

        return null;
    }

    private static ListNode findMiddle(ListNode head){
        ListNode x = head;
        ListNode y = head;
        while(y!=null && y.next!=null){
            x = x.next;
            y= y.next.next;
        }
        return x;
    }

    private static void print(ListNode head){
        while(head!=null){
            System.out.println(head.data);
            head = head.next;
        }
    }
}
