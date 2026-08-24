class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for(int i = 0; i < s.length() ; i++){
            char ss = s.charAt(i);
            if(ss=='#'){
                if(!s1.isEmpty()){
                    s1.pop();
                }
            }else{
                s1.push(ss);
            }
        }
        for(int i = 0; i < t.length() ; i++){
            char tt = t.charAt(i);
            if(tt=='#'){
                if(!s2.isEmpty()){
                    s2.pop();
                }
            }else{
                s2.push(tt);
            }
        }
        if(s1.equals(s2)){
            return true;
        }
        return false;

    }
}