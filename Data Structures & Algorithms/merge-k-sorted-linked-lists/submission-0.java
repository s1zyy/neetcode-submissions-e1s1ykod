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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) {
            return null;
        }
        if(lists.length == 1 ){
            return lists[0];
        }

        for(int i = 0; i < lists.length-1; i++) {

            lists[i+1] = merge(lists[i], lists[i+1]);
            if(i == lists.length-2){
                return lists[lists.length-1];
            }
        }
        return null;
        
    }
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        dummy.next = l2;
        ListNode prev = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                ListNode temp = l1.next;
                prev.next = l1;
                l1.next = l2;
                prev = l1;
                l1 = temp;
            } else if(l2.val < l1.val) {
                prev = l2;
                l2 = l2.next;
            }
        }
        if(l1 != null) {
            prev.next = l1;
        }
        return dummy.next;
    }
}
