class Solution {
    public String minWindow(String s, String t) {
        String ians = "";
        int min = 1000000;
        int st = 0;
        HashMap<Character,Integer> mapt = new HashMap<>();
        HashMap<Character,Integer> maps = new HashMap<>();
        if(s.length() < t.length()){
            return ians;
        }
        else{
            for(char c : t.toCharArray()){
                if(!mapt.containsKey(c)){
                    mapt.put(c,1);
                }
                else{
                    mapt.put(c,mapt.get(c)+1);
                }
            }
            int l = 0;
            int r = 0;
            while(r < s.length()){
                char a = s.charAt(r);
                if(!maps.containsKey(a)){
                    maps.put(a,1);
                }
                else{
                    maps.put(a,maps.get(a)+1);
                }
                r++;
                while(compare(mapt,maps)){
                    if(r-l < min){
                        min = r-l;
                        st = l;
                    }
                    char d = s.charAt(l);
                    if(maps.get(d) == 1){
                        maps.remove(d);
                    }
                    else{
                        maps.put(d,maps.get(d)-1);
                    }
                    l++;
                }
            }

            if(min == 1000000){
                return "";
            }
            return s.substring(st,st+min);
        }
    }

    private boolean compare(HashMap<Character,Integer> map1, HashMap<Character,Integer> map2){
        for(char h : map1.keySet()){
            if(!map2.containsKey(h) || map2.get(h) < map1.get(h)){
                return false;
            }
        }
        return true;
    }
}