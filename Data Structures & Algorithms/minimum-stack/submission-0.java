class MinStack {

    private List<Integer> stack;
    private List<Integer> minStack;

    public MinStack() 
    {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }
    
    public void push(int val) 
    {
        stack.add(val);
        
        // If minStack is empty, this val is the current minimum.
        // Otherwise, the new minimum is the smaller of 'val' and the previous minimum.
        if (minStack.isEmpty()) 
        {
            minStack.add(val);
        } 
        else 
        {
            int currentMin = minStack.getLast();
            minStack.add(Math.min(val, currentMin));
        }
    }
    
    public void pop() 
    {
        if (!stack.isEmpty()) 
        {
            stack.removeLast();
            minStack.removeLast(); // Pop from both to keep them synchronized // this is main story , 
                                    // both stack can be diff but at any time main is main stack and when we pop from both minstack will have min from remaining list 
        }
    }
    
    public int top() 
    {
        return stack.getLast();
    }
    
    public int getMin() 
    {
        return minStack.getLast();
    }
}
