package hexlet.code;

import java.util.TreeSet;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Objects;
public class TreeBuilder {

    static List<Map<String, Object>> build(Map<String, Object> map1, Map<String, Object> map2) {
        TreeSet<String> keySet = new TreeSet<>();
        keySet.addAll(map1.keySet());
        keySet.addAll(map2.keySet());
        List<Map<String, Object>> diff = new ArrayList<>();
        for (String key : keySet) {
            var map = new TreeMap<String, Object>();
            map.put("key", key);
            if (map1.containsKey(key) && map2.containsKey(key)) {
                Object valueOld = map1.get(key);
                Object newValue = map2.get(key);
                if (!Objects.equals(valueOld, newValue)) {
                    map.put("type", "changed");
                    map.put("valueOld", valueOld);
                    map.put("value", newValue);
                } else {
                    map.put("type", "notChanged");
                    map.put("value", valueOld);
                }
            } else if (!map2.containsKey(key)) {
                map.put("type", "deleted");
                map.put("value", map1.get(key));
            } else {
                map.put("type", "added");
                map.put("value", map2.get(key));
            }
            diff.add(map);
        }
        return diff;
    }
}
