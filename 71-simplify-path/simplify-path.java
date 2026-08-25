class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");
        for(int i =0;i<parts.length;i++){
            String a = parts[i];
            if(a.equals("") || a.equals(".")){
                continue;
            }
            if(a.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                stack.push(a);
            }
        }
        String ans = "";
        for(int i=0;i<stack.size();i++){
            String a = stack.get(i);
            ans += "/" + a;
        }
        if(ans.equals("")){
            return "/";
        }
        return ans;
    }
}