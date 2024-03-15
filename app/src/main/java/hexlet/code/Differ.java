package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Differ {
    public static String generate(String file1, String file2) throws IOException {
        return generate(file1, file2, "stylish");
    }

    public static String generate(String file1, String file2, String formatName) throws IOException {
        var content1 = Parser.parseContent(getContent(file1), Parser.getMapper(file1));
        var content2 = Parser.parseContent(getContent(file2), Parser.getMapper(file2));
        return Formatter.format(TreeBuilder.build(content1, content2), formatName);
    }

    public static String getContent(String file) throws IOException {
        Path path = Paths.get(file).toAbsolutePath().normalize();
        return Files.readString(path);
    }
}
