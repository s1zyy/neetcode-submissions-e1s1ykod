/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node current = head;
        while(current != null) {

            Node newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;

        }
        current = head;
        while (current != null) {
            if(current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
            
            
        }
        Node answer = new Node(0);
        Node copyCurr = answer;
        current = head;
        while(current != null){
            Node copy = current.next;
            current.next = copy.next;
            copyCurr.next = copy;
            copyCurr = copyCurr.next;
            current = current.next;
        }
        return answer.next;
        
    }
}
