package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parseContent(String data, ObjectMapper mapper) throws IOException {
        return mapper.readValue(data, new TypeReference<>() {
        });
    }

    public static ObjectMapper getMapper(String file) {
        if (file.endsWith(".yml")) {
            return new YAMLMapper();
        }
        if (file.endsWith(".json")) {
            return new JsonMapper();
        }
        return new ObjectMapper();
    }
}
