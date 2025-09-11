import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
    private Map<String, TreeMap<Integer, String>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, _ -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key))
            return "";

        TreeMap<Integer, String> vals = timeMap.get(key);
        Map.Entry<Integer, String> entry = vals.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}
