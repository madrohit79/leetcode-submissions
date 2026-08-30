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
        int size=0;
        ListNode curr = head;
        while(curr!=null){
            size++;
            curr=curr.next;
        }
        if(size==n){
            return head.next;
        }
        ListNode prev=null;
        ListNode ncurr=head;
        int target=1;
        while(ncurr!=null){
             if(target==(size-n+1)){
                prev.next = ncurr.next;
                break;
            }
            prev = ncurr;
            ncurr = ncurr.next;
            target++;
        }
        return head;
    }
}