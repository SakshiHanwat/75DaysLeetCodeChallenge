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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Step 1: Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode second = slow.next;
        slow.next = null;

        ListNode prev = null;
        while (second != null) {
            ListNode nextNode = second.next;
            second.next = prev;
            prev = second;
            second = nextNode;
        }

        // prev is head of reversed second half
        ListNode first = head;
        ListNode reversedSecond = prev;

        // Step 3: Merge alternately
        while (reversedSecond != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = reversedSecond.next;

            first.next = reversedSecond;
            reversedSecond.next = temp1;

            first = temp1;
            reversedSecond = temp2;
        }
    }
}