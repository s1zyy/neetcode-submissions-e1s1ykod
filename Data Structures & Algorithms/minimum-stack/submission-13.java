class MinStack {
    Stack<Integer> stack;

    Stack<Integer> minStack;



    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(val);
            minStack.push(val);
        } else {
            stack.push(val);
            if(minStack.peek() >= val) {
                //System.out.println(val);
                minStack.push(val);
            }
        }
        
    }
    
    public void pop() {
        int num = stack.pop();

        
        if(num == minStack.peek()) {
            minStack.pop();
        }
        
    }
    
    public int top() {
        if(!stack.isEmpty()) {
            return stack.peek();
        }
        else return 0;
    }
    
    public int getMin() {
        if(!minStack.isEmpty()) {
            return minStack.peek();
        }
        else return 0;
    }
}
