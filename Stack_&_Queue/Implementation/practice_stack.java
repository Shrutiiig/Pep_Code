public class practice_stack{
    private int size;
    private Object[] st;
    private int maxSize;
    private int tos;

    public Stack(){
        setValues(10);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for( int i=this.tos; i>=0; i--){
            sb.append(this.st[i]);
            if( i != 0 ) sb.ppend(",");
        }
        sb.append["]"];
        return sb.toString();
    }

    protected void setValues(int n){
        this.st = new Object[n];
        this.size = 0;
        this.tos = -1;
        this.maxSize = n;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int size(){
        return this.size;
    }

    public int capacity(){
        return this.maxSize;
    }

    public void push(T val) throws Exception{
        if(this.size == this.maxSize){
            throw new Exception("StackIsFull");
        }
        push_(val);
    }

    protected void push_(T val){
        this.st[this.tos++] = (T)val;
        this.size++;
    }

    public T pop() throws Exception{
        if( this.size == 0 ){
            throw new Exception("Stack Empty");
        }
        return pop();
    }

    protected void pop_(){
        T rv = (T)top_();
        this.st[this.tos--] = 0;
        this.size--;
        return rv;
    }

    public T top() throws Exception{
        if( this.size == 0 ){
            throw new Exception("Empty Stack");
        }
        return top();
    }

    protected T top_(){
        return (T)this.st[this.tos];
    }
}