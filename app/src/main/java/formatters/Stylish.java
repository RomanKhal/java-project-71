package formatters;


import java.util.List;
import java.util.Map;

public class Stylish {
    static final String FORMAT = "  %s %s: %s\n";

    public static String format(List<Map<String, Object>> diff) {
        StringBuilder builder = new StringBuilder();
        for (Map<String, Object> innerMap : diff) {
            String type = (String) innerMap.get("type");
            if (type.equals("notChanged")) {
                builder.append(String.format(FORMAT, " ", innerMap.get("key"), innerMap.get("value")));
            }
            if (type.equals("changed")) {
                builder.append(String.format(FORMAT, "-", innerMap.get("key"), innerMap.get("valueOld")));
                builder.append(String.format(FORMAT, "+", innerMap.get("key"), innerMap.get("value")));
            }
            if (type.equals("deleted")) {
                builder.append(String.format(FORMAT, "-", innerMap.get("key"), innerMap.get("value")));
            }
            if (type.equals("added")) {
                builder.append(String.format(FORMAT, "+", innerMap.get("key"), innerMap.get("value")));
            }
        }
        builder.insert(0, "{\n").append("}\n");
        return builder.toString();
    }
}
