class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0;
        int maxf = 0;
        int l=0;
        int r=0;
        while(r<s.length()){
            char c = s.charAt(r);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
            r++;
            maxf = Math.max(maxf,map.get(c));
            if( (r-l)- maxf <= k ){
                max=Math.max(max,(r-l));
            }else{
                char left = s.charAt(l);
                map.put(left,map.get(left)-1);
                l++;
            }
        }
        return max;
    }
}