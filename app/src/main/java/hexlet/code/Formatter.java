package hexlet.code;


import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(List<Map<String, Object>> data, String formatName) throws IOException {
        return switch (formatName) {
            case "stylish" -> Stylish.format(data);
            case "plain" -> Plain.format(data);
            case "json" -> Json.format(data);
            default -> "Wrong format. Try stylish/plain";
        };
    }
}
