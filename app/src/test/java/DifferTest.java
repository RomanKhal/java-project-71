

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import hexlet.code.Differ;
import hexlet.code.Parser;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DifferTest {


    @Test
    public void testStylish() throws IOException {
        String json1 = "src/test/resources/file1.json";
        String json2 = "src/test/resources/file2.json";
        String expected = Files.readString(Path.of("src/test/resources/result_stylish.txt"));
        assertEquals(expected, Differ.generate(json1, json2, "stylish"));
    }

    @Test
    public void testPlain() throws IOException {
        String json1 = "src/test/resources/file1.yml";
        String json2 = "src/test/resources/file2.yml";
        String expected = Files.readString(Path.of("src/test/resources/result_plain.txt"));
        assertEquals(expected, Differ.generate(json1, json2, "plain"));
    }

    @Test
    public void testJson() throws IOException {
        String json1 = "src/test/resources/file1.yml";
        String json2 = "src/test/resources/file2.yml";
        String expected = Files.readString(Path.of("src/test/resources/result_json.txt"));
        assertEquals(expected, Differ.generate(json1, json2, "json"));
    }

    @Test
    public void testYamlParserOn() {
        String tsrc = "src/test/resources/file1.yml";
        String expected = YAMLMapper.class.getSimpleName();
        assertEquals(expected, Parser.getMapper(tsrc).getClass().getSimpleName());
    }

    @Test
    public void testJsonParserOn() {
        String tsrc = "src/test/resources/file2.json";
        String expected = JsonMapper.class.getSimpleName();
        assertEquals(expected, Parser.getMapper(tsrc).getClass().getSimpleName());
    }
}
