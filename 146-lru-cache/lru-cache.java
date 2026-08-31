class LRUCache {
    class Node{
        int key;
        int val;
        Node next;

        Node(int key,int val){
            this.key=key;
            this.val = val;
        }
    }

    Node cur=null;
    Node head=null;
    int c;
    int size=0;
    public LRUCache(int capacity) {
        c=capacity;
    }
    
    public int get(int key) {
        Node prev = null;
        cur=head;
        while(cur!=null){
            if(cur.key==key){
                if(prev==null){
                    return cur.val;
                }
                prev.next=cur.next; //remove cur from its current position because we are going to pop it 

                cur.next=head;
                head=cur;

                return cur.val;
            }
            prev=cur;
            cur=cur.next;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        cur=head;
        while(cur!=null){
            if(cur.key==key){
                cur.val=value;
                if(cur!=head){
                    Node prev=head;

                    while(prev.next!=cur){
                        prev=prev.next;
                    }
                    prev.next=cur.next;
                    cur.next=head;
                    head=cur;
                }
                return;
            }
            cur=cur.next;
        }
        Node newn=new Node(key,value);
        if(head==null){
            head = newn;
            size++;
            return;
        }

        newn.next=head;
        head=newn;
        size++;

        if(size>c){
            cur=head;
            while(cur.next.next!=null){
                cur=cur.next;
            }
            cur.next=null;
            size--;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */