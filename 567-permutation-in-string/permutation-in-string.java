class Solution {
    public boolean checkInclusion(String s1, String s2) {

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (map1.containsKey(c)) {
                map1.put(c, map1.get(c) + 1);
            } else {
                map1.put(c, 1);
            }
        }
        int l = 0;
        int r = 0;
        while (r < s2.length()) {
            char c = s2.charAt(r);
            if (map2.containsKey(c)) {
                map2.put(c, map2.get(c) + 1);
            } else {
                map2.put(c, 1);
            }
            r++;
            if (r - l == s1.length()) {
                if (map1.equals(map2)) {
                    return true;
                }
                char left = s2.charAt(l);
                if (map2.get(left) == 1) {
                    map2.remove(left);
                } else {
                    map2.put(left, map2.get(left) - 1);
                }
                l++;
            }
        }
        return false;
    }
}