class TimeMap {
    HashMap<String,ArrayList<Pair<Integer, String>>> map = new HashMap<>();
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new ArrayList<>());
        }
        map.get(key).add(new Pair<>(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        else{
            ArrayList<Pair<Integer,String>> list = map.get(key);
            int low = 0;
            int high = list.size()-1;
            int ans=-1;

            while(low<=high){
                int mid = low+high-low/2;
                int val = list.get(mid).getKey();

                if(val==timestamp){
                    return list.get(mid).getValue();
                }
                else if(val<timestamp){
                    ans=mid;
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
            if(ans==-1){
                return "";
            }
            else{
                return list.get(ans).getValue();
            }
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */