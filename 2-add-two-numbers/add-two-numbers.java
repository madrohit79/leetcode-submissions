class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sll = null;
        ListNode scurr = null;
        int carry = 0;
        while(c1!=null||c2!=null){
            int val1 = 0;
            int val2 = 0;
            if(c1!=null){
                val1=c1.val;
            }
            if(c2!=null){
                val2=c2.val;
            }
            int sum=val1+val2+carry;
            int digit=sum%10;
            carry = sum/10;
            ListNode newnode = new ListNode(digit);
            if(sll==null){
                sll=newnode;
                scurr=newnode;
            }
            else{
                scurr.next=newnode;
                scurr=newnode;
            }
            if(c1!=null){
                c1=c1.next;
            }
            if(c2!=null){
                c2=c2.next;
            }
        }
        if(carry>0){
            scurr.next = new ListNode(carry);
        }
        return sll;
    }
}