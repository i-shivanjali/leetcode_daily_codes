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
          ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode preDelete = dummy;  
        for(int i = 0; i < n; i++){
            head = head.next;
        }
        
        while(head != null){
            head = head.next;
            preDelete = preDelete.next;
        }
        preDelete.next = preDelete.next.next; 
        
        return dummy.next;   
    }
}
