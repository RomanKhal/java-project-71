package formatters;


import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String format(List<Map<String, Object>> diff) {
        StringBuilder builder = new StringBuilder();
        for (Map<String, Object> innerMap : diff) {
            String type = (String) innerMap.get("type");
            if (type.equals("changed")) {
                Object oldValue = checkingComplexValue(innerMap.get("valueOld"));
                Object newValue = checkingComplexValue(innerMap.get("value"));
                builder.append("Property '")
                        .append(innerMap.get("key"))
                        .append("' was updated. From ")
                        .append(oldValue)
                        .append(" to ")
                        .append(newValue)
                        .append("\n");
            }
            if (type.equals("deleted")) {
                builder.append("Property '")
                        .append(innerMap.get("key"))
                        .append("' was removed")
                        .append("\n");
            }
            if (type.equals("added")) {
                Object value = checkingComplexValue(innerMap.get("value"));
                builder.append("Property '")
                        .append(innerMap.get("key"))
                        .append("' was added with value: ")
                        .append(value)
                        .append("\n");
            }
        }
        return builder.toString().trim();
    }

    private static Object checkingComplexValue(Object obj) {
        if (obj instanceof Collection<?>) {
            obj = "[complex value]";
        }
        if (obj instanceof Map<?, ?>) {
            obj = "[complex value]";
        }
        if (obj instanceof String && !obj.equals("[complex value]")) {
            obj = "'" + obj + "'";
        }
        return obj;
    }
}
