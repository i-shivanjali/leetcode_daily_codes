
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode nHead = new ListNode(-1);
        ListNode node = head;
        while (node != null){
            ListNode nodeNext = node.next;
            node.next = nHead.next;
            nHead.next = node;
            node = nodeNext;
        }
        return nHead.next;
    }
}
