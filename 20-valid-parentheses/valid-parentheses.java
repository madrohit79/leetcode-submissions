class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char t = s.charAt(i);
            if(t == '(' || t == '{' || t == '['){
                stack.push(t);
            }
            else if(t == ')'){
                if(stack.isEmpty() || stack.peek() != '('){
                    return false;
                }
                stack.pop();
            }
            else if(t == '}'){
                if(stack.isEmpty() || stack.peek() != '{'){
                    return false;
                }
                stack.pop();
            }
            else if(t == ']'){
                if(stack.isEmpty() || stack.peek() != '['){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}