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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;
    
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while(cur1 != null && cur2 != null) {
            if(cur1.val <= cur2.val) {
                tail.next = cur1;
                tail = tail.next;
                cur1 = cur1.next;
            } else {
                tail.next = cur2;
                tail = tail.next;
                cur2 = cur2.next;
            }
        }
        if(cur1 == null) {
            tail.next = cur2;
        } else if(cur2 == null) {
            tail.next = cur1;
        }
        return dummy.next;
    }
}