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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Nothing to reverse
        if (head == null || left == right) {
            return head;
        }
        // Dummy node helps when left = 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Move prev to the node just before 'left'
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // current is the first node that needs to be reversed
        ListNode current = prev.next;

        // Reverse nodes from left to right
        for (int i = 0; i < right - left; i++) { // Node that we want to move to the front
            ListNode temp = current.next;
            // Remove temp from its current position
            current.next = temp.next;
            // Put temp before current
            temp.next = prev.next;

            // Connect prev to temp
            prev.next = temp;
        }
        return dummy.next;
    }
}