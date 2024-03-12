package hexlet.code.formatters;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Json {
    public static String format(List<Map<String, Object>> diff) throws IOException {
        ObjectMapper mapper = new JsonMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(diff);
    }
}
