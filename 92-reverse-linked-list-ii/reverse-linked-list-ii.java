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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr=head;
        ListNode lcurr=head;
        ListNode rcurr=head;
        ListNode lcprev=null;
        ListNode rcnext=null;
        
        for(int i =1;i<left;i++){
            lcprev=curr;
            curr=curr.next;
        }
        lcurr = curr;
        for(int i = left;i<=right;i++){
            rcurr=curr;
            curr=curr.next;
        }
        rcnext=curr;

        ListNode prev = null;
        curr=lcurr;
        while(curr!=rcnext){
            ListNode next = curr.next;
            curr.next=prev;

            prev=curr;
            curr=next;
        }

        if(lcprev!=null){
            lcprev.next=rcurr;
        }
        else{
            head=rcurr;
        }
        lcurr.next=rcnext;
        return head;
    }
}