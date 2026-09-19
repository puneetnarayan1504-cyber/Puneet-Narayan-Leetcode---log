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
    public ListNode swapPairs(ListNode head) {
        ListNode dum = new ListNode();
        dum.next = head;
        ListNode prev = dum;

        while (prev.next != null && prev.next.next != null){
            ListNode node1 = prev.next;
            ListNode node2 = prev.next.next;
            node1.next = node2.next;
            node2.next = node1;

            prev.next = node2;
            prev = node1;
        }

        return dum.next;
    }
}