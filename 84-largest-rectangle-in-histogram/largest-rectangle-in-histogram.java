class Solution {
    public int largestRectangleArea(int[] h) {
        Stack<Integer> stack = new Stack<>();
        int ma=0;
        for(int i = 0;i<h.length;i++){
            if(stack.isEmpty()){
                stack.push(i);
            }
            else if(h[stack.peek()]<=h[i]){
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && h[stack.peek()]>h[i]){
                    int ht = h[stack.pop()];
                    int w;
                    if(stack.isEmpty()){
                        w=i;
                    }
                    else{
                        w=i-stack.peek()-1;
                    }
                    int area = ht*w;
                    if(area>ma){
                        ma=area;
                    }
                }
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            int ht = h[stack.pop()];
            int w;
            if(stack.isEmpty()){
                w=h.length;
            }
            else{
                w=h.length-stack.peek()-1;
            }
            int area = ht*w;
            if(area>ma){
                ma=area;
            }
        }
        return ma;
    }
}