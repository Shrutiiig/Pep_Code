public class practice_java{
    private int size;
    private int maxSize;
    private int head;
    private int tail;
    private int[] arr;

    public queue(){
        setValues(10);
    }

    public queue(int n){
        setValues(n);
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int capacity(){
        return this.maxSize;
    }

    @Override 
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for( int i=0; i<this.size; i++ ){
            int idx = 

        }
    }

    protected void setValues(int n){
        this.size = 0;
        this.maxSize = n;
        this.head = 0;
        this.tail = 0;
        this.arr = new int[n];
    }

    public void push(int val) throws Exception{
        if( this.size == this.maxSize ){
            throw new Exception("Full Stack");
        }
        push_(val;)
    }

    protected void push_(int val){
        this.arr[this.tail] = val;
        this.tail = (this.tail+1) % this.maxSize;
        this.size++;
    }

    protected int peek_(){
        return this.arr[this.head];
    }

    public int peek() throws Exception{
        if(this.size == 0 ){
            throw new Exception("Empty Queue");
        }
        return peek_();
    }

    protected int remove_(){
        int rv = peek();
        this.arr[this.head] = 0;
        this.head = (this.head + 1) % this.maxSize;
        this.size--;
        return rv;
    }

    public int remove() throws Exception{
        if(this.size == 0){
            throw new Exception("Empty Queue");
        }
        return remove_();
    }
}

/////////////////////////////////////////////////////////

public class Dqueue extends queue{
    Dqueue(){
        super();
    }

    Dqueue(int n){
        super(n);
    }

    @Override
    public void push(int val){
        if(super.size() == super.maxSize()){
            int[] temp = new int[super.size()];
            int i = 0;
            while(super.size()!=0) temp[i++] = super.remove_();

            super.setValues(temp.length*2);
            
            for(int ele: temp) super.push_(ele);
        }

        super.push_(ele);
    }
}


















