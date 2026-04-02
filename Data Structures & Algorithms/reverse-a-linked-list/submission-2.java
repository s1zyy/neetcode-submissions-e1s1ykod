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
        ListNode previous = null;
        ListNode current = head;
        
        while(current != null){
            ListNode nextTemp = current.next;

            current.next = previous;

            previous = current;
            current = nextTemp;
                      
        }
        return previous;
    }
}
