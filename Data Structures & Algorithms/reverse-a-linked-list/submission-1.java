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
    public ListNode reverseList(ListNode head) {
        /**
        head node1 -> node2 -> null
        null <- node1 <- node2 head
        */
        ListNode nextNode = head;
        ListNode previous = head;
        if(head == null || head.next == null) {
            return head;
        }
        head = head.next;
        while(nextNode != null){
            nextNode = head.next;
            head.next = previous;
            if(previous.next.equals(head)) {
                previous.next = null;
            }
            previous = head;
            if(nextNode != null) {
                head = nextNode;
            }            
        }
        return head;
    }
}
