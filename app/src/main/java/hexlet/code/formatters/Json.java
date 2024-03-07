package hexlet.code.formatters;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Json {
    public static String format(List<Map<String, Object>> diff) throws IOException {
        StringBuilder builder = new StringBuilder();
        ObjectMapper mapper = new JsonMapper();
        for (var map : diff) {
            builder.append(mapper.writeValueAsString(map));
            builder.append(",\n");
        }
        builder.insert(0, "[\n").replace(builder.length() - 2, builder.length(), "\n]");
        return builder.toString();
    }
}
