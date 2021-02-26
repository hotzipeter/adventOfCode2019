package hu.adventofcode2019.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FileProcessor {


    private static BufferedReader getBufferedReaderByPath(String path) throws FileNotFoundException {
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        return new BufferedReader(fileReader);
    }

    public static <T> List<T> processFileByPathWithStringProcessFunction(String path, Function<String, T> processFunction) throws FileNotFoundException {
        return getBufferedReaderByPath(path).lines().map(processFunction).collect(Collectors.toList());
    }

    public static <T> T processFileByPathWithListOfStringProcessFunction(String path, Function<List<String>, T> processFunction) throws FileNotFoundException {
        return processFunction.apply(getBufferedReaderByPath(path).lines().collect(Collectors.toList()));
    }
}
