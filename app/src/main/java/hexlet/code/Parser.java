package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;

public class Parser {
    public static HashMap<String, Object> parseContent(String data, ObjectMapper mapper) throws IOException {
        return mapper.readValue(data, new TypeReference<>() {
        });
    }
}
