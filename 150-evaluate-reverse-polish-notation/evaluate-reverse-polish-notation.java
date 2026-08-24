class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < tokens.length; i++){
            String s = tokens[i];
            if(s.equals("+")){
                int two = stack.pop();
                int one = stack.pop();
                stack.push(one + two);
            }
            else if(s.equals("-")){
                int two = stack.pop();
                int one = stack.pop();
                stack.push(one - two);
            }
            else if(s.equals("*")){
                int two = stack.pop();
                int one = stack.pop();
                stack.push(one * two);
            }
            else if(s.equals("/")){
                int two = stack.pop();
                int one = stack.pop();
                stack.push(one / two);
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
}