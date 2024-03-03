package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "differ 0.1",
        description = "Compares two configuration files and shows a difference.")
class MyDiffer implements Callable<Integer> {

    @Parameters(index = "0", description = "path to first file")
    private String filepath1;
    @Parameters(index = "1", description = "path to second file")
    private String filepath2;

    @Option(names = {"-f", "--format"}, defaultValue = "stylish", description = "output format [default: stylish]")
    private String format;

    @Override
    public Integer call() { // your business logic goes here...
        try {
            String result = Differ.generate(filepath1, filepath2, format);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Some went wrong");
        }
        return 0;
    }
}

public class App {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new MyDiffer()).execute(args);
        System.exit(exitCode);
    }
}