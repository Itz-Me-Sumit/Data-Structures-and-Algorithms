class MyStack {

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        
        Queue<Integer> filled_queue = queue1.isEmpty() ? queue2 : queue1;

        filled_queue.add(x);

    }
    
    public int pop() {
        Queue<Integer> filled_queue = queue1.isEmpty() ? queue2 : queue1;
        Queue<Integer> empty_queue = queue1.isEmpty() ? queue1 : queue2;
        
        int size = filled_queue.size();

        for(int i=0 ; i<size-1 ; i++){

            empty_queue.add(filled_queue.poll());

        }
        
        return filled_queue.poll();

    }
    
    public int top() {
        
        Queue<Integer> filled_queue = queue1.isEmpty() ? queue2 : queue1; 
        Queue<Integer> empty_queue = queue1.isEmpty() ? queue1 : queue2;

        int size = filled_queue.size();

        for(int i=0 ; i<size-1 ; i++){
            empty_queue.add(filled_queue.poll());
        }

        int top_elm = filled_queue.poll();
        empty_queue.add(top_elm);
        return top_elm;

    }
    
    public boolean empty() {

        return (queue1.isEmpty() && queue2.isEmpty());

    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */