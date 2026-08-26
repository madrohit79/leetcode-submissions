class Solution {
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<a.length;i++){
            if(stack.isEmpty()){
                stack.push(a[i]);
            }
            else if(a[i]>0 && stack.peek()>0){
                stack.push(a[i]);
            }
            else if(a[i] > 0 && stack.peek() < 0){
                stack.push(a[i]);
            }
            else if(a[i]<0 && stack.peek() < 0){
                stack.push(a[i]);
            }
            else if(a[i]<0 && stack.peek()>0){
                while(!stack.isEmpty() && stack.peek()>0 && Math.abs(stack.peek()) < Math.abs(a[i])){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    stack.push(a[i]);
                }
                else if(stack.peek()<0){
                    stack.push(a[i]);
                }
                else if(Math.abs(stack.peek())==Math.abs(a[i])){
                    stack.pop();
                }
                else if(stack.peek()>Math.abs(a[i])){
                    continue;
                }
            }
        }
        int[] ans = new int[stack.size()];
        for(int i = 0; i<stack.size();i++){
            ans[i]=stack.get(i);
        }
        return ans;
    }
}