class Solution {
    public int calPoints(String[] o) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<o.length ; i++){
            String x = o[i];
            if(x.equals("+")){
                int two = stack.pop();
                int one = stack.peek();
                stack.push(two);
                stack.push(one+two);
            }
            else if(x.equals("D")){
                int d = stack.peek();
                stack.push(2*d);
            }
            else if(x.equals("C")){
                stack.pop();
            }
            else{
                stack.push(Integer.parseInt(x));
            }
        }
        int score = 0;
        for(int i = 0; i<stack.size() ;i++){
            score += stack.get(i);
        }
        return score;
    }
}