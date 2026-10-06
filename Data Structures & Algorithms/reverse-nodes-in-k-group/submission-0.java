/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (true) {
            ListNode current = prev; // prev and current pointing to dummy ONLY starting
            for (int i = 0; i < k; i++) {
                current = current.next;
                if (current == null) {
                    return dummy.next;
                }
            }

            // current = kth node
            ListNode kth = current;

            // Save the node after the group
            ListNode nextGroup = kth.next;

            // Reverse the current group
            ListNode previous = nextGroup;
            current = prev.next;

            while (current != nextGroup) {
                ListNode temp = current.next;

                current.next = previous;

                previous = current;

                current = temp;
            }

            // Connect previous group to reversed group
            ListNode oldStart = prev.next;

            prev.next = kth;

            // Move prev to the end of reversed group
            prev = oldStart;
        }
    }
}
