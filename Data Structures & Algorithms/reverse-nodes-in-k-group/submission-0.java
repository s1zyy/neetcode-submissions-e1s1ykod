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
     
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevHead = dummy;
        
        while(true) {
            ListNode kth = getKth(prevHead, k);
            if(kth == null) break;

            ListNode nextHead = kth.next;

            ListNode curr = prevHead.next;
            ListNode prev = nextHead;
            while(curr != nextHead) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            ListNode temp = prevHead.next;
            prevHead.next = kth;
            prevHead = temp;
            
            

        }
        return dummy.next;

    }
    public ListNode getKth(ListNode curr, int k) {

        for(int i = 0; i < k; i ++) {
            curr = curr.next;
            if(curr == null) return null;
        }
        return curr;
        
    }
}
