package hexlet.code;


import java.io.IOException;
import java.util.TreeSet;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Objects;

import static hexlet.code.Parser.getData;

public class Differ {
    public static String generate(String file1, String file2) throws IOException {
        return generate(file1, file2, "stylish");
    }

    public static String generate(String file1, String file2, String formatName) throws IOException {
        return Formatter.format(computigDiff(getData(file1), getData(file2)), formatName);
    }

    private static List<Map<String, Object>> computigDiff(Map<String, Object> map1, Map<String, Object> map2) {
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
