package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class Parser {
    public static HashMap<String, Object> getData(String file) throws IOException {
        Path path = Paths.get(file).toAbsolutePath().normalize();
        String data = Files.readString(path);
        ObjectMapper objectMapper = getMapper(file);
        return objectMapper.readValue(data, new TypeReference<>() {
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
