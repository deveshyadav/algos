import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        // Edge case: if the input list array is empty
        if (lists == null || lists.length == 0) return null;

        // Min-heap to hold the nodes
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);

        // Add the head of each list to the heap
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        // Dummy node to simplify the merging process
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Extract nodes from the heap and form the sorted linked list
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            current.next = minNode; // Add the smallest node to the result
            current = current.next;

            // If there's more nodes in the list of the extracted node, add the next node to the heap
            if (minNode.next != null) {
                minHeap.add(minNode.next);
            }
        }

        return dummy.next; // Return the head of the merged list
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example usage
        ListNode[] lists = new ListNode[3];

        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        MergeKSortedLists solution = new MergeKSortedLists();
        ListNode mergedList = solution.mergeKLists(lists);

        // Print merged linked list
        printList(mergedList);
    }
}

