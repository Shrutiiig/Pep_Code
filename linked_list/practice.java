public class practice{
    private class Node{
        int data = 0;
        Node next = null;

        Node(int data){
            this.data = data;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int getFirst() throws Exception{
        if( this.size == 0 ){
            throw new Exception ("EmptyList");
        }
        return this.head.data;
    }

    public int getLast() throws Exception{
        if( this.size == 0){
            throw new Exception( "EmptyList" );
        }
        return this.tail.data;
    }

    public int getAt(int idx) throws Exception{
        if( idx < 0 || idx >= this.size ){
            throw new Exception("NULLPointer");
        }
        return getNodeAt(idx).data;
    }

    private Node getNodeAt(int idx){
        Node temp = head;
        while( idx-- > 0 ){
            temp = temp.next;
        }
        return temp;
    }

    public void addFirst(int data){
        Node node = new Node(data);
        addFirstNode(node);
    }

    private void addFirstNode(Node node){
        if( this.size == 0 ){
            this.head = node;
            this.tail = node;
        }
        else{
            node.next = this.head;
            this.head = node;
        }
        this.size++;
    }

    public void addLast(int data){
        Node node = new Node(data);
        addLastNode(node);
    }

    private void addLastNode( Node node ){
        if( this.size == 0 ){
            this.head = node;
            this.tail = node;
        }else{
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }

    public void addAt( int data, int idx ) throws Exception{
        if( idx < 0 || idx > this.size ) {
            throw new Exception("NULLPointer");
        }

        Node node = new Node(data);
        addAtNode(node,idx);
    }

    private void addAtNode(Node node, int idx){
        if( idx == 0 ) addFirstNode();
        else if( idx == this.size ) addLastNode();
        else{
            Node temp = getNodeAt(idx-1);
            node.next = temp.next;
            temp.next = node;
        }
        this.size++;
    }

    public int removeFirst() throws Exception{
        if( this.size == 0 ){
            throw new Exception ("NULLPointer");
        }
        Node rn = removeFirstNode();
        return rn.data;
    }

    private Node removeFirstNode(){
        Node rn = this.head;
        if( this.size == 1 ){
            this.head = null;
            this.tail = null;
        }else{
            this.head=this.head.next;
        }
        rn.next = null;
        this.size--;
        return rn;
    }

    public int removeLast() throws Exception{
        if( this.size == 0 ){
            throw new Exception("EmptyList");
        }
        Node rn = removeLastNode();
        return rn.data;
    }

    private Node removeLastNode(){
        Node last = this.tail;
        if( this.size == 1 ){
            this.head = null;
            this.tail = null;
        }else{
            Node rn = getAt(this.size - 2 );
            rn.next = null;
            this.tail = rn;
        }
        this.size--;
        return last;
    }

    public int removeAt(int idx) throws Exception{
        if( idx<0 || idx>=this.size ){
            throw new Exception("NULLPointer");
        }
        Node rn = removeNodeAt(idx);
        return rn.data;
    }

    private Node removeNodeAt(int idx){
        if( idx == 0 ) removeFirstNode();
        else if( idx == this.size-1 ) removeLastNode();
        else{
            Node previous = getNodeAt(idx-1);
            Node rn = previous.next;
            prev.next = rn.next;
            rn.next = null;
        }
        
        this.size--;
        return rn;
    }

    public Node middleNode( Node head ){
        if( head == null ) return head;
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node middleNode( Node head ){
        if( head == null || head.next == null ) return head;
        Node slow = head;
        Node fast = head;
        while( fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node reverseList( Node head ){
        Node prev = null;
        Node curr = head;
        Node frwd = null;

        while( curr != null ){
            frwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = frwd;
        }return prev;
    }

    public boolean isPalindrome( Node head ){
        if( head == null || head.next == null ) return true;
        Node mid = middleNode(head);
        Node nhead = mid.next;
        mid.next = null;

        nhead = reverseList(nhead);

        Node curr1 = head;
        Node curr2 = nhead;

        while( curr1 != null && curr2 != null ){
            if( curr1.data != curr2.data ){
                return false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return true;
    }

    public Node mergeTwoLists(Node l1, Node l2){
        if(l1 == null || l2 == null) return l1!=null?l1:l2;
        Node dummy = new Node(-1);
        Node prev = dummy;

        Node c1 = l1.head;
        Node c2 = l2.head;

        while(c1!=null && c2!=null){
            if( c1.data > c2.data ){
                prev.next = c1;
                c1 = c1.next;
            }else{
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }
        if(c1!=null) prev.next = c1;
        else if(c2!=null) prev.next = c2;

        return dummy.next;
    }

    public Node oddEvenList(Node head){
        if( head == null ) return null;
        Node ehead = head.next;
        Node c1 = head;
        Node c2 = ehead;
        while( c1.next!=null && c2.next!null ){
            c1.next = c2.next;
            c1 = c1.next;
            c2.next = c1.next;
            c2 = c2.next;
        }
        c1.next = eHead;
        return head;
    }

    public boolean hasCycle(Node head){
        if( head == null || head.next == null ) return false;

        Node slow = head;
        Node fast = head;

        while( fast != null && fast.next != null ){
            slow == slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

    public Node detectCycle(Node head){
        if( head == null || head.next == null ) return null;

        Node slow = head;
        Node fast = head;
        while( fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            if( slow == fast ) break;
        }
        if( slow != fast ) return null;

        slow = head;
        while( slow != fast ){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public Node mergeKLists(ListNode[] lists){
        if( lists.length == 0 ) return null;

        return mergeKLists_(lists,0,lists.length-1);
    }

    public ListNode mergeKLists_(ListNode[] lists, int si, int ei){
        if( si == ei ) return lists[0];

        int mid = (si+ei)/2;
        return mergeTwoLists(mergeKLists_(lists,si,mid), mergeKLists_(lists,mid+1,ei) );
    }
}