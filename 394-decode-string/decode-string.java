class Solution {
    public String decodeString(String s) {
        Stack<Integer> n = new Stack<>();
        Stack<String> st = new Stack<>();
        String ans="";
        int num=0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num*10+(c-'0');
            }

            else if(c=='['){
                n.push(num);
                st.push(ans);

                num=0;
                ans="";
            }
            else if(c==']'){
                int k = n.pop();
                String p = st.pop();

                String t ="";
                for(int j=0;j<k;j++){
                    t+=ans;
                }
                ans=p+t;
            }
            else{
                ans+=c;
            }
        }
        return ans;

    }
}