class TimeMap {
    HashMap<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();

        
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
            map.get(key).add(new Pair(value,timestamp));
        } else {
            List pairs = map.get(key);
            pairs.add(new Pair(value,timestamp));
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Pair> pairs = map.get(key);
        String answer = "";
        int left = 0;
        int right = pairs.size()-1;
        while(left <= right) {
            int middle = left + (right-left)/2;
            Pair mid = pairs.get(middle);
            if(mid.timestamp <= timestamp) {
                answer = mid.value;
                left = middle +1;
            }
            else{
                right = middle -1;
            }
        }
        return answer;


        
    }

    class Pair {
        String value;
        int timestamp;

        Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
