class TimeMap 
{
    private Map<String, TreeMap<Integer,String>> m;

    public TimeMap() 
    {
        m = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) 
    {
        TreeMap<Integer, String> innerMap = m.getOrDefault(key, new TreeMap<>());

        innerMap.put(timestamp, value);

        m.put(key, innerMap);

    }
    
    public String get(String key, int timestamp) 
    {
        if(!m.containsKey(key))
        {
            return "";
        }
        TreeMap<Integer, String> timestamps = m.get(key);

        // 2. Find the highest timestamp number less than or equal to our target
        Integer closestTime = timestamps.floorKey(timestamp);

        if (closestTime == null) 
        {
            return ""; 
        } 
        else 
        {
            return timestamps.get(closestTime); 
        }
    }
}
