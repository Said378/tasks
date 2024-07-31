package com.task.datastructure.linked_list;

public class MiddleOfLinkedList {
    public static ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void testLinkedList(){

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        ListNode middle1 = findMiddleNode(head1);
        printListFromNode(middle1); // Output: 3, 4, 5


        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next = new ListNode(6);
        ListNode middle2 = findMiddleNode(head2);
        printListFromNode(middle2); // Output: 4, 5, 6
    }

    public static void printListFromNode(ListNode node) {

        System.out.println("Node values: " );

        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
