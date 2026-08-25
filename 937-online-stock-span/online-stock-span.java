class StockSpanner {
    Stack<int[]> stack = new Stack<>();
    int i= 0;
    int count = 1;
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        while(!stack.isEmpty() && stack.peek()[0]<=price){
            stack.pop();
        }
        int span;   
        if(stack.isEmpty()){
            span=i+1;
        }else{
            span=i-stack.peek()[1];
        }
        stack.push(new int[]{price,i});
        i++;
        return span;        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */