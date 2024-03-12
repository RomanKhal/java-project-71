package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static hexlet.code.Parser.parseContent;

public class Differ {
    public static String generate(String file1, String file2) throws IOException {
        return generate(file1, file2, "stylish");
    }

    public static String generate(String file1, String file2, String formatName) throws IOException {
        var content1 = parseContent(getContent(file1), getMapper(file1));
        var content2 = parseContent(getContent(file2), getMapper(file2));
        return Formatter.format(TreeBuilder.build(content1, content2), formatName);
    }

    public static String getContent(String file) throws IOException {
        Path path = Paths.get(file).toAbsolutePath().normalize();
        return Files.readString(path);
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
