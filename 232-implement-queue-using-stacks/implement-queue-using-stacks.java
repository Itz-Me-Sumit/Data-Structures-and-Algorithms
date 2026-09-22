class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {

        int size = stack1.size();

        for(int i=0 ; i<size-1 ; i++){
            stack2.push(stack1.pop());
        }

        int popped_elm = stack1.pop();

        for(int i=0 ; i<size-1 ; i++){
            stack1.push(stack2.pop());
        }

        return popped_elm;

    }
    
    public int peek() {
        
        int size = stack1.size();

        for(int i=0; i<size-1 ; i++){
            stack2.push(stack1.pop());
        }
        int peek = stack1.pop();

        stack1.push(peek);

        for(int i=0 ; i<size-1 ; i++){
            stack1.push(stack2.pop());
        }

        return peek;

    }
    
    public boolean empty() {
      return stack1.empty();  
    } 
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */