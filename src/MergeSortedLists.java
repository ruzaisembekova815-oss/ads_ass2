import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MergeSortedLists {

    // Function to merge two sorted singly linked lists
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Attach the remaining nodes
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for first list
        System.out.print("How many elements in the first list: ");
        int n1 = sc.nextInt();
        ListNode l1 = buildList(sc, n1, "first");

        // Input for second list
        System.out.print("How many elements in the second list: ");
        int n2 = sc.nextInt();
        ListNode l2 = buildList(sc, n2, "second");

        // Merge the lists
        MergeSortedLists merger = new MergeSortedLists();
        ListNode result = merger.mergeTwoLists(l1, l2);

        // Print the result
        System.out.print("Merged sorted list: ");
        printList(result);

        sc.close();
    }

    // Helper method to build a linked list from user input
    private static ListNode buildList(Scanner sc, int n, String listName) {
        if (n == 0) return null;

        System.out.println("Enter " + n + " numbers for the " + listName + " list (must be sorted):");
        ListNode head = new ListNode(sc.nextInt());
        ListNode current = head;

        for (int i = 1; i < n; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }
        return head;
    }

    // Helper method to print the linked list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
