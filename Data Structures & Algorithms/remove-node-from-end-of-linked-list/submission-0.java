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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return head;
        }
        if(head.next == null) {
            return null;
        }
        ListNode slow = new ListNode(0);
        slow.next = head;
        ListNode result = slow;
        ListNode fast = head;

        for(int i = 1; i < n; i++) {
            if(fast != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }

        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }

        if(slow.next != null) {
            slow.next = slow.next.next;
        }
        return result.next;

    }
}
