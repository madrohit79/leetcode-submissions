class FreqStack {
    HashMap<Integer,Integer> m1 = new HashMap<>();
    HashMap<Integer,Stack<Integer>> m2 = new HashMap<>();
    int maxf=0;
    public FreqStack() {
        
    }
    
    public void push(int val) {
        if(!m1.containsKey(val)){
            m1.put(val,1);
        }else if(m1.containsKey(val)){
            m1.put(val,m1.get(val)+1);
        }
        int f = m1.get(val);
        if(!m2.containsKey(f)){
            m2.put(f,new Stack<>());
        }
        m2.get(f).push(val);
        if(f>maxf){
            maxf=f;
        }
    }
    
    public int pop() {
        int p=m2.get(maxf).pop();
        m1.put(p,m1.get(p)-1);
        if(m2.get(maxf).isEmpty()){
            maxf--;
        }
        return p;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */