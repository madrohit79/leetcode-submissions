class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode ncurr = head; // to keep track of the new current after first iteration of reordering 
        while(ncurr != null && ncurr.next != null){
            ListNode curr = ncurr;
            ListNode prev = null;
            while(curr.next != null){
                prev = curr;
                curr = curr.next;
            }
            ListNode dummy = curr;
            prev.next = null;
            ListNode fcurr = ncurr.next;
            ncurr.next = dummy;
            dummy.next = fcurr;
            ncurr = fcurr;
        }
    }
}