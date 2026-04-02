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
        ListNode mid = findMiddle(head);

        ListNode second = reverse(mid.next);
        mid.next=null;

        merge(head, second);
    }

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null) {
            fast = fast.next;
            if(fast.next == null) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while(current != null) {
            ListNode nextTemp = current.next;
            current.next = previous;
            previous = current;
            current = nextTemp;
        }

        return previous;
    } 

    public void merge(ListNode first, ListNode second) {

        

        while(first!=null && second!=null){
            ListNode fNext = first.next;
            ListNode sNext = second.next;

            first.next = second;
            first = fNext;

            second.next = first;
            second = sNext;
        }
        
    }
}
